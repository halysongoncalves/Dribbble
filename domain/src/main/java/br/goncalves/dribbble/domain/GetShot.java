package br.goncalves.dribbble.domain;


import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.Shot;

/**
 * Representation of an use case to get the configuration parameters
 * to use with the Shot api, such as the image endpoint
 */
@SuppressWarnings("UnusedDeclaration")
public interface GetShot extends RequestError {
    /**
     * Callback used to be notified when the most popular Shot have been
     * received
     *
     * @param shot the response containing a details shot
     */
    @Subscribe
    void onPopulateShot(Shot shot);

    /**
     * Request data source the configuration data
     *
     * @param shotId the response containing a  shots
     */
    void requestShot(int shotId);
}
