package com.example.a1338559.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String tag = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Log.i(tag,"in activity two create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"in activity two start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"in activity two resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"in activity two pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"in activity two stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag,"in activity two restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"in activity two destroy");
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
