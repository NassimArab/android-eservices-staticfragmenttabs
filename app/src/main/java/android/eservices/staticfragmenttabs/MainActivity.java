package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewPager = (ViewPager) findViewById(R.id.tab_viewpager);



        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position==0){
                    //FragmentOne f1 = FragmentOne.newInstance();
                    //if (f1.equals(null))
                    return FragmentOne.newInstance();
                }else{
                    return FragmentTwo.newInstance();
                }

            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle tragment change inside
        //viewpager.setAdapter(...);

    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
