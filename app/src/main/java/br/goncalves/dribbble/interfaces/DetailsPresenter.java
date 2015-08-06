package br.goncalves.dribbble.interfaces;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;
import br.goncalves.dribbble.model.entities.Shot;

/**
 * Created by Halyson on 21/03/15.
 */
public interface DetailsPresenter extends Presenter {
    void loadShot(int shotId);

    @Subscribe
    void onPopulateShot(Shot shot);

    @Subscribe
    void onConnectionError(ConnectionError connectionError);

    @Subscribe
    void onHttpError(HttpError httpError);

    @Subscribe
    void onGenericError(GenericError genericError);
}
