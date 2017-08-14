package com.chaitu.services;

import static com.chaitu.services.Constants.TAG;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by chaitanya.ak on 18/07/17.
 */

public class MyService extends Service {

  public MyService() {

  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    Log.d(TAG, "Service onCreate called");
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    int mode = START_REDELIVER_INTENT;
    Log.d(TAG, "onStartCommand called : " + mode);
    String number = null;
    if (intent != null) {
      number = intent.getStringExtra("number");
    } else {
      Log.d(TAG, "App restarted");
    }
    ServiceThread serviceThread = new ServiceThread(number);
    serviceThread.start();

    return mode;//also @see : START_NOT_STICKY, START_STICKY, START_REDELIVER_INTENT
  }

  class ServiceThread extends Thread {

    private final String number;

    public ServiceThread(String number) {
      this.number = number;
    }

    @Override
    public void run() {
      super.run();
      Log.d(TAG, "onStartCommand entered for : " + number);
      print(number);
      Log.d(TAG, "onStartCommand exited for : " + number);
    }

  }

  private void print(String number) {
    try {

      for (int i = 0; i < 10; i++) {
        Thread.sleep(1 * 1000);
        Log.d(TAG, "printing for " + number + " i :  " + i);

//        if (i == 5) {
//          stopSelf();
//        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "Service onDestroy called");
  }
}
