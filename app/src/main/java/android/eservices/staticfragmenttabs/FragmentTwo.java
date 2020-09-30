package android.eservices.staticfragmenttabs;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "ADD TO COUNTER";

    public FragmentTwo() {
        //TODO
    }

    public static FragmentTwo newInstance() {
        //TODO
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup fragmentOneView = (ViewGroup) inflater.inflate(
                R.layout.fragment_two, container, false);

        return fragmentOneView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}