package br.goncalves.dribbble.domain;


import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.Profile;

/**
 * Representation of an use case to get the configuration parameters
 * to use with the MovieDatabase api, such as the image endpoint
 */
@SuppressWarnings("UnusedDeclaration")
public interface GetProfile extends RequestError {
    /**
     * Callback used to be notified when the most popular User have been
     * received
     *
     * @param profile the response containing a list with User
     */
    @Subscribe
    void onPopulateProfileReceived(Profile profile);

    /**
     * Request data source the configuration data
     */
    void requestProfile();
}
