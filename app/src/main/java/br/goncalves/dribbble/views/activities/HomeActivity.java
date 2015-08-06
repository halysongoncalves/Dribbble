package br.goncalves.dribbble.views.activities;

import android.os.Bundle;

import br.goncalves.dribbble.R;
import br.goncalves.common.FragmentNames;
import br.goncalves.dribbble.views.fragments.HomeFragment;

/**
 * Created by halysongoncalves on 21/03/15.
 */
public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.activity_default_content_container, new HomeFragment(), FragmentNames.FRAGMENT_HOME).commit();
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_default;
    }

    @Override
    protected int getTitleToolbar() {
        return R.string.app_name;
    }
}