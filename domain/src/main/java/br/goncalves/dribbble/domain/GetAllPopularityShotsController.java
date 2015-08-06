package br.goncalves.dribbble.domain;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Page;
import br.goncalves.dribbble.model.rest.WebServiceManager;

/**
 * This class is an implementation of {@link GetPopularityShots}
 */
public class GetAllPopularityShotsController implements GetPopularityShots {
    private final WebServiceManager mWebServiceManager;
    private final Bus mUiBus;

    /**
     * Constructor of the class.
     *
     * @param uiBus             The bus to communicate the domain module and the app module
     * @param webServiceManager The data source to retrieve the  configuariton
     */
    public GetAllPopularityShotsController(WebServiceManager webServiceManager, Bus uiBus) {

        if (webServiceManager == null)
            throw new IllegalArgumentException("webServiceManager data source cannot be null");

        if (uiBus == null)
            throw new IllegalArgumentException("Ui bus cannot be null");

        mWebServiceManager = webServiceManager;
        mUiBus = uiBus;
        BusProvider.getRestBusInstance().register(this);
    }

    @Subscribe
    public void onPopulateAllPopularityShots(Page page) {
        mUiBus.post(page);
        BusProvider.getRestBusInstance().unregister(this);
    }

    @Override
    public void requestAllPopularityShots(int page) {
        mWebServiceManager.getAllPopularityShots(page);
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
