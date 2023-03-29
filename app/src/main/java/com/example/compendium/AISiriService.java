package com.example.compendium;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Random;

public class AISiriService extends Service {

    private Handler handler;
    private Runnable runnable;
    private Random random;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        random = new Random();
        runnable = new Runnable() {
            @Override
            public void run() {
                showToast();
                handler.postDelayed(this, getRandomInterval());
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(runnable);
        return START_STICKY;
    }

    public AISiriService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }

    private int getRandomInterval() {
        return random.nextInt(5000) + 1000; // Random interval between 1 to 5 seconds
    }

    private void showToast() {
        String message = generateRandomText(5,12);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public static String generateRandomText(int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength; // Random length between minLength and maxLength
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(random.nextInt(26) + 'a')); // Random lowercase letter
        }
        return sb.toString();
    }
}