package co.xintana.unionmagdalenafanapp.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import co.xintana.unionmagdalenafanapp.MainPageAdapter;
import co.xintana.unionmagdalenafanapp.R;
import co.xintana.unionmagdalenafanapp.data.ActualidadInfo;
import co.xintana.unionmagdalenafanapp.utilities.DataUtilities;

public class MainActivity extends UMAppCompatActivity {
    private ViewPager mPager;
    private MainPageAdapter mPageAdapter;
    public ActualidadInfo mActualidadInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
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
                Log.d(getLogTag(), "" + tab.getPosition());
                mPager.setCurrentItem(tab.getPosition());
                Log.d(getLogTag(), "After");
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
        } else {
            JSONObject json = null;
            try {
                json = new JSONObject(intent.getStringExtra(Intent.EXTRA_TEXT));
                mActualidadInfo = DataUtilities.populate(json);
                Log.d(getLogTag(), mActualidadInfo.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
