package pw.highimhell.commons.interfaces;

/**
 * @author hell
 * 12/3/2020
 */
public interface Cancellable {
    boolean isCancelled();
    void setCancelled(boolean flag);
}
