package pw.highimhell.eventsystem;

import java.lang.reflect.Method;

/**
 * @author hell
 * 12/3/2020
 */
public final class MethodData {
    private final Object object;
    private final Method method;

    public MethodData(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }
}
