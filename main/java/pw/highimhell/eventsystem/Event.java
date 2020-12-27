package pw.highimhell.eventsystem;

import pw.highimhell.eventsystem.interfaces.Cancellable;

/**
 * @author hell
 * 12/3/2020
 */
public class Event implements Cancellable {
    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean flag) {
        this.cancelled = flag;
    }

    public Event call() {
        EventManager.getInstance().call(this);
        return this;
    }
}
