package br.goncalves.dribbble.interfaces;

public interface AboutView {
    void loadToolbar();

    void initializePresenter();

    void showPictureProfile(String avatarUrl);

    void showNameProfile(String name);

    void showLocation(String company);


}
