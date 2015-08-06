package br.goncalves.dribbble.interfaces;

import android.support.v4.app.Fragment;


public interface NavigationDrawerView {
    void initializePresenter();

    void showPictureProfile(String avatarUrl);

    void showNameProfile(String name);

    void fragmentTransaction(Fragment fragment);
}
