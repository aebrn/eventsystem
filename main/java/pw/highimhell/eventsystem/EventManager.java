package pw.highimhell.eventsystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hell
 * 12/3/2020
 */
public final class EventManager {
    private static final EventManager INSTANCE = new EventManager();

    private final List<MethodData> methods = new CopyOnWriteArrayList<>();

    public void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Listener.class)) {
                Listener listener = method.getAnnotation(Listener.class);
                MethodData methodData = new MethodData(object, method, listener.priority());
                if (!methods.contains(methodData)) {
                    methods.add(methodData);
                }
            }
        }

        methods.sort(Comparator.comparing(MethodData::getPriority));
    }

    public void unregister(Object object) {
        methods.removeIf(methodData -> methodData.getObject() == object);
    }

    public void call(Event event) {
        for (MethodData methodData : methods) {
            if (methodData.getObject() != null) {
                invoke(methodData.getObject(), methodData.getMethod(), event);
            }
        }
    }

    private void invoke(Object object, Method method, Event event) {
        try {
            boolean accessible = true;
            if (!method.isAccessible()) {
                accessible = false;
                method.setAccessible(true);
            }
            method.invoke(object, event);
            if (!accessible) {
                method.setAccessible(false);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }

    public static EventManager getInstance() {
        return INSTANCE;
    }
}
