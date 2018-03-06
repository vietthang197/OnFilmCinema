package tagroup.thangducanh.com.onfilmcinema;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by asus on 3/6/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{



    @Override
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.e("TOKEN",recent_token);
        registerToken(recent_token);
    }

    public void registerToken(String recent_token) {
        OkHttpClient httpClient = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("Token",recent_token).build();
        Request request = new Request.Builder().url("http://192.168.1.103/fcm/register.php").post(body).build();
        try {
            httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
