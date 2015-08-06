package br.goncalves.dribbble.interfaces;

import com.squareup.otto.Subscribe;

import br.goncalves.dribbble.model.entities.Profile;

/**
 * Created by Halyson on 21/03/15.
 */
public interface AboutPresenter extends Presenter {
    void loadProfile();

    @Subscribe
    void onPopulateProfileUserReceived(Profile profile);
}
