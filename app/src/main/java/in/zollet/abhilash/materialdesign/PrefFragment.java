package in.zollet.abhilash.materialdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrefFragment extends Fragment {


    public PrefFragment() {
    }
     TextView summery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_summery, container, false);
        // Inflate the layout for this fragment


        return rootView;
    }

}
