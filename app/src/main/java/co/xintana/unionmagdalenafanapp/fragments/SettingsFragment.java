package co.xintana.unionmagdalenafanapp.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import co.xintana.unionmagdalenafanapp.R;

/**
 * Created by Jose on 5/3/2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_general);
    }
}
