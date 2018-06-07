package ccm.gospel.misook.settings;

import android.os.Bundle;

import ccm.gospel.misook.R;


public class DebugSettingsFragment extends BasePreferenceFragment {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.debug_settings);
    }
}
