package pw.highimhell.eventsystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
            MethodData methodData = new MethodData(object, method);
            if (method.isAnnotationPresent(Listener.class)  && !methods.contains(methodData)) {
                methods.add(methodData);
            }
        }
    }

    public void unregister(Object object) {
        methods.removeIf(methodData -> methodData.getObject() == object && methods.contains(methodData));
    }

    public void call(Event event) {
        for (MethodData methodData : methods) {
            if (methodData.getObject() != null) {
                try {
                    methodData.getMethod().invoke(methodData.getObject(), event);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public static EventManager getInstance() {
        return INSTANCE;
    }
}
