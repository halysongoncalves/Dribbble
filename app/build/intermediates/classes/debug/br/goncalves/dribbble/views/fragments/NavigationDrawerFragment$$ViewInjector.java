// Generated code from Butter Knife. Do not modify!
package br.goncalves.dribbble.views.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class NavigationDrawerFragment$$ViewInjector {
  public static void inject(Finder finder, final br.goncalves.dribbble.views.fragments.NavigationDrawerFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296367, "field 'imageViewProfile'");
    target.imageViewProfile = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131296368, "field 'textViewName'");
    target.textViewName = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296369, "field 'textViewAbout' and method 'about'");
    target.textViewAbout = (android.widget.TextView) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.about();
        }
      });
  }

  public static void reset(br.goncalves.dribbble.views.fragments.NavigationDrawerFragment target) {
    target.imageViewProfile = null;
    target.textViewName = null;
    target.textViewAbout = null;
  }
}
