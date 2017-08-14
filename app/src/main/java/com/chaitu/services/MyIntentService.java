package com.chaitu.services;

import static com.chaitu.services.Constants.TAG;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by chaitanya.ak on 18/07/17.
 */

public class MyIntentService extends IntentService {

  /**
   * Creates an IntentService.  Invoked by your subclass's constructor.
   *
   * @param name Used to name the worker thread, important only for debugging.
   */

  public MyIntentService() {
    super(null);
  }

  public MyIntentService(String name) {
    super(name);
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "IntentService onCreate called");
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    String number = null;
    if (intent != null) {
      number = intent.getStringExtra("number");
    } else {
      Log.d(TAG, "App restarted");
    }
    Log.d(TAG, "onHandleIntent entered for : " + number);
    print(number);
    Log.d(TAG, "onHandleIntent exited for : " + number);
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
    Log.d(TAG, "IntentService onDestroy called");
  }
}
