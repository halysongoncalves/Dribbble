package br.goncalves.dribbble.interfaces;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Page;

/**
 * Created by Halyson on 21/03/15.
 */
public interface HomePresenter extends Presenter {
    void loadAllPopularityShots(boolean showProgressBar, int page);

    @Subscribe
    void onPopulateAllPopularityShots(Page page);

    @Subscribe
    void onConnectionError(ConnectionError connectionError);

    @Subscribe
    void onHttpError(HttpError httpError);

    @Subscribe
    void onGenericError(GenericError genericError);
}
