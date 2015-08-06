
/**
 * @author Saul M.
 */
package br.goncalves.dribbble.interfaces;

/**
 * Interface that represents a Presenter in the model view presenter Pattern
 * defines methods to manage the Activity / Fragment lifecycle
 */
public interface Presenter {
    /**
     * Called when the presenter is onDestroy, i.e when an activity
     * or a fragment finishes
     */
    void onDestroy();
}
