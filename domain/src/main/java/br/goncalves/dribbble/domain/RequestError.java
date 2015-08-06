package br.goncalves.dribbble.domain;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.ConnectionError;
import br.goncalves.dribbble.model.entities.GenericError;
import br.goncalves.dribbble.model.entities.HttpError;

/**
 * Created by Halyson on 21/03/15.
 */
public interface RequestError {
    @Subscribe
    void onRequestErrorConnection(ConnectionError connectionError);

    @Subscribe
    void onRequestErrorHttp(HttpError httpError);

    @Subscribe
    void onRequestErrorGeneric(GenericError genericError);
}
