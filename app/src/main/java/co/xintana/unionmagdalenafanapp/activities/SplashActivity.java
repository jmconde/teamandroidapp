package co.xintana.unionmagdalenafanapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import co.xintana.unionmagdalenafanapp.R;
import co.xintana.unionmagdalenafanapp.activities.MainActivity;
import co.xintana.unionmagdalenafanapp.utilities.NetworkUtilities;

/**
 * Created by joseconde on 3/2/17.
 */

public class SplashActivity extends UMAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash);
        Log.d(getTag(), "=====================================Initializing");
        new LoadDataTask().execute(NetworkUtilities.buildURL());
    }

    private class LoadDataTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            URL url = params[0];
            String json = null;

            try {
                json = NetworkUtilities.get(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return json;
        }

        @Override
        protected void onPostExecute(String json) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);

            if (json != null && !json.equals("")) {
                intent.putExtra(Intent.EXTRA_TEXT, json);
                Log.d(getTag(), "json: "+json);
            }
            startActivity(intent);
            finish();
        }
    }
}
