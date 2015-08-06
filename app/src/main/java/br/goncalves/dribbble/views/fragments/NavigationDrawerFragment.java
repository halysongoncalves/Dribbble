package br.goncalves.dribbble.views.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.goncalves.dribbble.Dribbble;
import br.goncalves.dribbble.R;
import br.goncalves.dribbble.interfaces.NavigationDrawerPresenter;
import br.goncalves.dribbble.interfaces.NavigationDrawerView;
import br.goncalves.dribbble.presenters.NavigationDrawerPresenterImpl;
import br.goncalves.dribbble.utils.PreferencesEditor;
import br.goncalves.dribbble.views.activities.AboutActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class NavigationDrawerFragment extends Fragment implements NavigationDrawerView {
    /**
     * Por as diretrizes de design, você deve mostrar o menu drawer até que o usuário expande ele manualmente.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    @InjectView(R.id.fragment_drawer_menu_roudend_image_view)
    ImageView imageViewProfile;
    @InjectView(R.id.fragment_drawer_menu_text_view_name)
    TextView textViewName;
    @InjectView(R.id.fragment_drawer_menu_text_view_about)
    TextView textViewAbout;

    private NavigationDrawerPresenter navigationDrawerPresenter;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View mFragmentContainerView;
    private boolean mUserLearnedDrawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = PreferencesEditor.getBooleanPreference(Dribbble.getContext(), PREF_USER_LEARNED_DRAWER, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewDrawerMenu = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        ButterKnife.inject(this, viewDrawerMenu);
        initializePresenter();

        return viewDrawerMenu;
    }

    @Override
    public void initializePresenter() {
        navigationDrawerPresenter = new NavigationDrawerPresenterImpl(this);
        navigationDrawerPresenter.loadProfile();
    }

    @Override
    public void onDestroy() {
        navigationDrawerPresenter.onDestroy();
        super.onStop();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mDrawerLayout != null) {
                if (isDrawerOpen()) {
                    mDrawerLayout.closeDrawer(mFragmentContainerView);
                } else {
                    mDrawerLayout.openDrawer(mFragmentContainerView);
                }
            } else {
                getActivity().finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),
                mDrawerLayout, toolbar,
                R.string.app_name,
                R.string.app_name
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    mUserLearnedDrawer = true;
                    PreferencesEditor.savePreference(Dribbble.getContext(), PREF_USER_LEARNED_DRAWER, true);
                }

                getActivity().supportInvalidateOptionsMenu();
            }
        };

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void showPictureProfile(String avatarUrl) {
        Picasso.with(Dribbble.getContext())
                .load(avatarUrl)
                .into(imageViewProfile);
    }

    @Override
    public void showNameProfile(String name) {
        textViewName.setText(name);
    }

    @OnClick(R.id.fragment_drawer_menu_text_view_about)
    public void about() {
        mDrawerLayout.closeDrawer(mFragmentContainerView);
        startActivity(new Intent(getActivity(), AboutActivity.class));
    }

    @Override
    public void fragmentTransaction(Fragment fragment) {
        mDrawerLayout.closeDrawer(mFragmentContainerView);
        if (fragment != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_default_content_container, fragment)
                    .commit();
        }
    }
}
