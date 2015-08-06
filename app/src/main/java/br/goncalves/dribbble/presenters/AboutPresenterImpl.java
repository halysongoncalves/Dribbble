package br.goncalves.dribbble.presenters;

import com.squareup.otto.Subscribe;

import br.goncalves.common.BusProvider;
import br.goncalves.dribbble.domain.GetProfileController;
import br.goncalves.dribbble.interfaces.AboutPresenter;
import br.goncalves.dribbble.interfaces.AboutView;
import br.goncalves.dribbble.model.entities.Profile;
import br.goncalves.dribbble.model.rest.WebServiceManagerImpl;

public class AboutPresenterImpl implements AboutPresenter {
    private final AboutView aboutView;

    public AboutPresenterImpl(AboutView aboutView) {
        BusProvider.getUIBusInstance().register(this);
        this.aboutView = aboutView;
    }

    @Override
    public void loadProfile() {
        new GetProfileController(WebServiceManagerImpl.getInstance(),
                BusProvider.getUIBusInstance())
                .requestProfile();
    }

    @Subscribe
    public void onPopulateProfileUserReceived(Profile profile) {
        aboutView.showPictureProfile(profile.getAvatar_url());
        aboutView.showNameProfile(profile.getName());
        aboutView.showLocation(profile.getLocation());
    }

    @Override
    public void onDestroy() {
        BusProvider.getUIBusInstance().unregister(this);
    }
}
