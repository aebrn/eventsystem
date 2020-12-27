package pw.highimhell.eventsystem.interfaces;

/**
 * @author hell
 * 12/27/2020
 */
public interface Cancellable {
    boolean isCancelled();
    void setCancelled(boolean flag);
}
