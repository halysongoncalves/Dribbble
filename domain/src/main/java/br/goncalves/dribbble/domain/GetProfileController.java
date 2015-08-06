package br.goncalves.dribbble.domain;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Profile;
import br.goncalves.dribbble.model.rest.WebServiceManager;

/**
 * This class is an implementation of {@link GetPopularityShots}
 */
public class GetProfileController implements br.goncalves.dribbble.domain.GetProfile {
    private final WebServiceManager mWebServiceManager;
    private final Bus mUiBus;

    /**
     * Constructor of the class.
     *
     * @param uiBus             The bus to communicate the domain module and the app module
     * @param webServiceManager The data source to retrieve the  configuariton
     */
    public GetProfileController(WebServiceManager webServiceManager, Bus uiBus) {

        if (webServiceManager == null)
            throw new IllegalArgumentException("Media data source cannot be null");

        if (uiBus == null)
            throw new IllegalArgumentException("Ui bus cannot be null");

        mWebServiceManager = webServiceManager;
        mUiBus = uiBus;
        BusProvider.getRestBusInstance().register(this);
    }

    @Subscribe
    public void onPopulateProfileReceived(Profile profile) {
        mUiBus.post(profile);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Override
    public void requestProfile() {
        mWebServiceManager.getProfile();
    }

    @Subscribe
    public void onRequestErrorConnection(ConnectionError connectionError) {
        mUiBus.post(connectionError);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Subscribe
    public void onRequestErrorHttp(HttpError httpError) {
        mUiBus.post(httpError);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Subscribe
    public void onRequestErrorGeneric(GenericError genericError) {
        mUiBus.post(genericError);
        BusProvider.getRestBusInstance().unregister(this);
    }
}
