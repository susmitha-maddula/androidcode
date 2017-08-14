package com.chaitu.services;

public class ActivityForThread extends BaseActivity {

  private MyThread mMyThread1;
  private MyThread mMyThread2;

  @Override
  void onClick(int id) {
    switch (id) {
      case R.id.one:
        mMyThread1 = new MyThread();
        mMyThread1.setName("one");
        mMyThread1.start();
        break;
      case R.id.two:
        mMyThread2 = new MyThread();
        mMyThread2.setName("two");
        mMyThread2.start();
        break;
      case R.id.stop:
        if (mMyThread1 != null) {
          mMyThread1.interrupt();
        }
        break;
    }
  }
}
