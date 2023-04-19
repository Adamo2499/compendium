package com.example.compendium;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.nio.charset.Charset;
import java.util.Random;

public class AISiriService extends Service {
    private boolean isRunning;
    private Handler handler;
    private Runnable runnable;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                String rngString = getAlphaNumericString(11);
                Log.e("Service", "Service is running...");
                Log.e("ServiceString",rngString);
                Toast.makeText(AISiriService.this, "Wiadomość od AISiri:\n"+rngString, Toast.LENGTH_SHORT).show();
                handler.postDelayed(this, 3000);
            }
        };
        handler.post(runnable);
        isRunning = true;
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Log.e("Service", "Service stopped");
        Toast.makeText(AISiriService.this, "Service stopped", Toast.LENGTH_SHORT).show();
        handler.removeCallbacks(runnable);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    static String getAlphaNumericString(int n)
    {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }
}