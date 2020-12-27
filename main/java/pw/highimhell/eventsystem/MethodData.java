package pw.highimhell.eventsystem;

import java.lang.reflect.Method;

/**
 * @author hell
 * 12/3/2020
 */
public final class MethodData {
    private final Object object;
    private final Method method;
    private final EventPriority priority;

    public MethodData(Object object, Method method, EventPriority priority) {
        this.object = object;
        this.method = method;
        this.priority = priority;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }

    public EventPriority getPriority() {
        return priority;
    }
}
