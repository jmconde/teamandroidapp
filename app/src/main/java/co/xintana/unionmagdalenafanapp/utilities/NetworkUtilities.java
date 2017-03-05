package co.xintana.unionmagdalenafanapp.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by jmcon on 3/4/2017.
 */

public class NetworkUtilities {
    private static final String TAG = "UMAPP " + NetworkUtilities.class.getSimpleName();

    private static final String BASE_URL = "http://xintana.co:5501/actualidad";

    public static URL buildURL() {
        Uri uri = Uri.parse(BASE_URL).buildUpon().build();

        URL url = null;

        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String get(URL url) throws IOException{
        Log.d(TAG, url.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = conn.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            if(scanner.hasNext()){
                return scanner.next();
            }
            Log.d(TAG, "Aquiva");
            return null;
        } finally {
            conn.disconnect();
        }
    }
}
