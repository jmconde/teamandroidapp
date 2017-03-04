package co.xintana.unionmagdalenafanapp.activities;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by jmcon on 3/4/2017.
 */

public class UMAppCompatActivity extends AppCompatActivity {
    protected String getTag() {
        return "UMAPP " + this.getClass().getSimpleName();
    }
}
