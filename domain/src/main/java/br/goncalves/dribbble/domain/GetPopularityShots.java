package br.goncalves.dribbble.domain;


import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.Page;

/**
 * Representation of an use case to get the configuration parameters
 * to use with the MovieDatabase api, such as the image endpoint
 */
@SuppressWarnings("UnusedDeclaration")
public interface GetPopularityShots extends RequestError {
    /**
     * Callback used to be notified when the most popular User have been
     * received
     *
     * @param page the response containing a list with user
     */
    @Subscribe
    void onPopulateAllPopularityShots(Page page);

    /**
     * Request data source the configuration data
     *
     * @param page the response containing a list shots in page
     */
    void requestAllPopularityShots(int page);
}
