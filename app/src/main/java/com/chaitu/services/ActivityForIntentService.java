package com.chaitu.services;

import android.content.Intent;

public class ActivityForIntentService extends BaseActivity {

  private Intent mIntent1;
  private Intent mIntent2;

  @Override
  void onClick(int id) {
    switch (id) {
      case R.id.one:
        mIntent1 = new Intent(this, MyIntentService.class);
        mIntent1.putExtra("number", "first");
        startService(mIntent1);
        break;
      case R.id.two:
        mIntent2 = new Intent(this, MyIntentService.class);
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
