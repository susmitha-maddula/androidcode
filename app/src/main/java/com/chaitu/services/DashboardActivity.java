package com.chaitu.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

public class DashboardActivity extends AppCompatActivity implements OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);
    findViewById(R.id.service).setOnClickListener(this);
    findViewById(R.id.thread).setOnClickListener(this);
    findViewById(R.id.intent_service).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent = null;
    switch (v.getId()) {
      case R.id.service:
        intent = new Intent(this, ActivityForService.class);
        break;
      case R.id.intent_service:
        intent = new Intent(this, ActivityForIntentService.class);
        break;
      case R.id.thread:
        intent = new Intent(this, ActivityForThread.class);
        break;
    }

    if (intent != null) {
      startActivity(intent);
    }
  }
}
