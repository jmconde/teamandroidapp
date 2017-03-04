package co.xintana.unionmagdalenafanapp.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import co.xintana.unionmagdalenafanapp.MainPageAdapter;
import co.xintana.unionmagdalenafanapp.R;

public class MainActivity extends UMAppCompatActivity {
    private ViewPager mPager;
    private MainPageAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Actualidad"));
        tabLayout.addTab(tabLayout.newTab().setText("Historia"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        mPageAdapter = new MainPageAdapter(fm, tabLayout.getTabCount());
        mPager.setAdapter(mPageAdapter);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(getTag(), "" + tab.getPosition());
                mPager.setCurrentItem(tab.getPosition());
                Log.d(getTag(), "After");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Intent intent = getIntent();
        if (!intent.hasExtra(Intent.EXTRA_TEXT)) {
            Toast.makeText(this, "No se cargaron datos correctamente.", Toast.LENGTH_LONG).show();
        }

    }
}
