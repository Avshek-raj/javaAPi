package avshek.apiData;

import org.apache.cordova.CordovaPlugin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class apiData extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getData")) {
            String message = args.getString(0);
            this.getData(callbackContext);
            return true;
        }
        return false;
    }

    private void getData(CallbackContext callbackContext) {
        try {
            URL url = new URL("https://api.chucknorris.io/jokes/random");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            // JSONObject result = new JSONObject(sb.toString());
            String line;
            while ((line = reader.readLine())!= null){
                sb.append(line);
            }
            callbackContext.success(sb.toString());
        } catch (Exception e) {
            callbackContext.error("Error: " + e );
        }     
    } 
}
