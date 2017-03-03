package co.xintana.unionmagdalenafanapp;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import co.xintana.unionmagdalenafanapp.fragments.HistoriaFragment;
import co.xintana.unionmagdalenafanapp.fragments.NoticiasFragment;

/**
 * Created by joseconde on 3/2/17.
 */

public class MainPageAdapter extends FragmentStatePagerAdapter {
    public static final int TAB_POSITION_ACTUALIDAD = 0;
    public static final int TAB_POSITION_HISTORIA = 1;
    private static final String TAG = MainPageAdapter.class.getSimpleName();
    private int mCount;

    public MainPageAdapter(FragmentManager fm, int count) {
        super(fm);
        Log.d(TAG, "Count " + count);
        mCount = count;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "Position " + position);
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        //args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
        //fragment.setArguments(args);
        switch (position){
            case TAB_POSITION_ACTUALIDAD:
                return new NoticiasFragment();
            case TAB_POSITION_HISTORIA:
                return new HistoriaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
