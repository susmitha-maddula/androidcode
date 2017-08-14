package com.chaitu.services;

import static com.chaitu.services.Constants.TAG;

import android.util.Log;

/**
 * Created by chaitanya.ak on 18/07/17.
 */

public class MyThread extends Thread {

  @Override
  public void run() {
    super.run();
    Log.d(TAG, "thread : " + getName() + " entered run");
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Log.d(TAG, "printing for " + getName() + " i :  " + i);
    }

    Log.d(TAG, "thread : " + getName() + " exited run");
  }
}
