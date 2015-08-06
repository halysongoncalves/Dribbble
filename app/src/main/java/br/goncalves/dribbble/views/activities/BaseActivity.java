package br.goncalves.dribbble.views.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.goncalves.dribbble.R;
import br.goncalves.dribbble.interfaces.BaseView;
import br.goncalves.dribbble.views.fragments.NavigationDrawerFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Halyson on 21/03/15.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    @InjectView(R.id.activity_default_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.inject(this);

        loadToolbar();
        loadDrawerMenu();
    }

    @Override
    public void loadToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getTitleToolbar());
    }

    @Override
    public void loadDrawerMenu() {
        NavigationDrawerFragment mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.activity_default_navigation_drawer);

        mNavigationDrawerFragment.setUp(
                R.id.activity_default_navigation_drawer,
                (DrawerLayout) findViewById(R.id.activity_default_drawer_layout), toolbar);
    }

    protected abstract int getLayoutResId();

    protected abstract int getTitleToolbar();
}
