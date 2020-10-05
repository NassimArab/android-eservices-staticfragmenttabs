package android.eservices.staticfragmenttabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements FragmentOne.OnButtonClickedListener {

    private ViewPager2 viewPager;
    private int currentCounter;
    private TextView counterTextView;
    private int nbFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewPager = (ViewPager2) findViewById(R.id.tab_viewpager);

        counterTextView = findViewById(R.id.counter_textview);

        currentCounter = 0;
        Resources res = getResources();
        String text = String.format(res.getString(R.string.counter_text), currentCounter);

        counterTextView.setText(text);

      /*  EmployeeFragmentStateAdapter adapter = new EmployeeFragmentStateAdapter(this);
        this.viewPager.setAdapter(adapter);*/
        this.viewPager.setAdapter(new FragmentStateAdapter(this) {
                                      @NonNull
                                      @Override
                                      public Fragment createFragment(int position) {
                                          if (position==0){
                                              return FragmentOne.newInstance();
                                          }else{
                                              return FragmentTwo.newInstance();
                                          }
                                      }

                                      @Override
                                      public int getItemCount() {
                                          return 2;
                                      }
                                  });

        TabLayout tabLayout = findViewById(R.id.tablayout);
        new TabLayoutMediator(tabLayout, viewPager,(tab, position) -> tab.setText("Activite " + (position + 1))
        ).attach();
                // viewPager.setAdapter(new EmployeeFragmentStateAdapter(getSupportFragmentManager()));
/*
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
        });*/

                //TODO we want two fragments with layouts : fragment_one, fragment_two.

                //TODO set adapter to viewpager and handle tragment change inside
                //viewpager.setAdapter(...);

    }

    @Override
    public void  onCounterUpdated(boolean isIncremented) {

        if (isIncremented == true)
            currentCounter++;
        else
            currentCounter--;

        Resources res = getResources();
        String Newtext = String.format(res.getString(R.string.counter_text), currentCounter);

        counterTextView.setText(Newtext);
        //Log.e(getClass().getSimpleName(),"Button clicked ! " + currentCounter +view.toString());

    }
    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}

