package pw.highimhell.eventsystem;

/**
 * @author hell
 * 12/3/2020
 */
public class Event {
    private boolean cancelled = false;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean flag) {
        this.cancelled = flag;
    }

    public Event call() {
        EventManager.getInstance().call(this);
        return this;
    }
}
