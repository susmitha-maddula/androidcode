package com.chaitu.services;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by chaitanya.ak on 18/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements OnClickListener {

  public static final int ONE = R.id.one;
  public static final int TWO = R.id.two;
  public static final int STOP = R.id.stop;
  @IntDef({ONE, TWO, STOP})
  public @interface ButtonClick {

  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.one).setOnClickListener(this);
    findViewById(R.id.two).setOnClickListener(this);
    findViewById(R.id.stop).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.one:
        onClick(ONE);
        break;
      case R.id.two:
        onClick(TWO);
        break;
      case R.id.stop:
        onClick(STOP);
        break;
    }
  }

  abstract void onClick(@ButtonClick int id);
}