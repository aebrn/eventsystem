package io.aebrn.eventsystem.interfaces;

/**
 * @author aebrn
 * 12/27/2020
 */
public interface Cancellable {
    boolean isCancelled();
    void setCancelled(boolean flag);
}
