package android.eservices.staticfragmenttabs;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment  implements View.OnClickListener {

    //2 - Declare callback
    private FragmentOne.OnButtonClickedListener mCallback;

    @Override
    public void onClick(View view) {
        // 5 - Spread the click to the parent activity
        mCallback.onCounterUpdated(false);;
    }

    // ----
    public static final String TAB_NAME = "SUB TO COUNTER";

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
        fragmentOneView.findViewById(R.id.button_decrement).setOnClickListener(this);

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



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity(context);
    }

    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(Context context){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (FragmentOne.OnButtonClickedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }


    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}