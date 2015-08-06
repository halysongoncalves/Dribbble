package br.goncalves.dribbble.presenters;

import com.squareup.otto.Subscribe;

import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.domain.GetProfileController;
import br.goncalves.dribbble.interfaces.NavigationDrawerPresenter;
import br.goncalves.dribbble.interfaces.NavigationDrawerView;
import br.goncalves.dribbble.model.entities.Profile;
import br.goncalves.dribbble.model.rest.WebServiceManagerImpl;

public class NavigationDrawerPresenterImpl implements NavigationDrawerPresenter {
    private final NavigationDrawerView navigationDrawerView;

    public NavigationDrawerPresenterImpl(NavigationDrawerView navigationDrawerView) {
        BusProvider.getUIBusInstance().register(this);
        this.navigationDrawerView = navigationDrawerView;
    }

    @Override
    public void loadProfile() {
        new GetProfileController(WebServiceManagerImpl.getInstance(),
                BusProvider.getUIBusInstance())
                .requestProfile();
    }

    @Subscribe
    public void onPopulateProfileUserReceived(Profile profile) {
        navigationDrawerView.showPictureProfile(profile.getAvatar_url());
        navigationDrawerView.showNameProfile(profile.getName());

    }

    @Override
    public void onDestroy() {
        BusProvider.getUIBusInstance().unregister(this);
    }
}
