package com.chaitu.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class ActivityForService extends BaseActivity {

  private Intent mIntent1;
  private Intent mIntent2;
  private ServiceConnection mServiceConnection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
  };

  @Override
  void onClick(int id) {
    switch (id) {
      case R.id.one:
        mIntent1 = new Intent(this, MyService.class);
        mIntent1.putExtra("number", "first");
        startService(mIntent1);
        break;
      case R.id.two:
        mIntent2 = new Intent(this, MyService.class);
        mIntent2.putExtra("number", "second");
        startService(mIntent2);
        break;
      case R.id.stop:
        if (mIntent1 != null) {
          stopService(mIntent1);
        }
        break;
    }
  }
}
