package in.zollet.abhilash.materialdesign;


import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomSheetSetting extends AppCompatDialogFragment {


    public BottomSheetSetting() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_sheet_setting, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new BottomSheetDialog(getActivity(), getTheme());
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState == null) {
            /*Fragment fragment = Fragment.instantiate(getActivity(),
                    PrefFragment.class.getName(), getArguments());
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, fragment)
                    .commit();*/
            //PrefFragment fragment = new PrefFragment();
            Fragment fragment = Fragment.instantiate(getActivity(),
                    PrefFragment.class.getName(), getArguments());
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
        }
    }

    public static class PrefFrag extends PreferenceFragmentCompat {

        /*@Override
        public void onCreate(Bundle savedInstanceState, String rootKey) {
            // Load the preferences from an XML resource
            setPreferencesFromResource(R.xml.preference, rootKey);
        }*/
       /* @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
        }
*/
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preference, rootKey);
        }
    }
}

