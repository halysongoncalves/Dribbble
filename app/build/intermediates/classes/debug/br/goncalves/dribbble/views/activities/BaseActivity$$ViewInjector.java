// Generated code from Butter Knife. Do not modify!
package br.goncalves.dribbble.views.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class BaseActivity$$ViewInjector {
  public static void inject(Finder finder, final br.goncalves.dribbble.views.activities.BaseActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296344, "field 'toolbar'");
    target.toolbar = (android.support.v7.widget.Toolbar) view;
  }

  public static void reset(br.goncalves.dribbble.views.activities.BaseActivity target) {
    target.toolbar = null;
  }
}
