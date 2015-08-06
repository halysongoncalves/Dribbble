// Generated code from Butter Knife. Do not modify!
package br.goncalves.dribbble.views.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AboutActivity$$ViewInjector {
  public static void inject(Finder finder, final br.goncalves.dribbble.views.activities.AboutActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296339, "field 'imageViewAvatar'");
    target.imageViewAvatar = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131296340, "field 'textViewName'");
    target.textViewName = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296341, "field 'textViewLocation'");
    target.textViewLocation = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296338, "field 'toolbar'");
    target.toolbar = (android.support.v7.widget.Toolbar) view;
  }

  public static void reset(br.goncalves.dribbble.views.activities.AboutActivity target) {
    target.imageViewAvatar = null;
    target.textViewName = null;
    target.textViewLocation = null;
    target.toolbar = null;
  }
}
