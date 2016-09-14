package com.example.a1338559.lab3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String tag = "TAG";
    private SharedPreferences preferences;
    int onCreateCount = 0;
    int onStartCount = 0;
    int onResumeCount = 0;
    int onPauseCount = 0;
    int onStopCount = 0;
    int onRestartCount = 0;
    int onDestroyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag,"on create");

        //Save Instance State
        /*
			if(savedInstanceState != null) {
				onCreateCount = savedInstanceState.getInt("onCreateCounter");
				if(onCreateCount == -1)
					((TextView)findViewById(R.id.onCreateString)).setText(getString(R.string.onCreateString) + onCreateCount);
				onStartCount = savedInstanceState.getInt("onStartCounter");
				if(onStartCount == -1)
					((TextView)findViewById(R.id.onStartString)).setText(getString(R.string.onStartString) + onStartCount);
				onResumeCount = savedInstanceState.getInt("onResumeCounter");
				if(onResumeCount == -1)
					((TextView)findViewById(R.id.onResumeString)).setText(getString(R.string.onResumeString) + onResumeCount);
				onPauseCount = savedInstanceState.getInt("onPauseCounter");
				if(onPauseCount == -1)
					((TextView)findViewById(R.id.onPauseString)).setText(getString(R.string.onPauseString) + onPauseCount);
				onStopCount = savedInstanceState.getInt("onStopCounter");
				if(onStopCount == -1)
					((TextView)findViewById(R.id.onStopString)).setText(getString(R.string.onStopString) + onStopCount);
				onRestartCount = savedInstanceState.getInt("onRestartCounter");
				if(onRestartCount == -1)
					((TextView)findViewById(R.id.onRestartString)).setText(getString(R.string.onRestartString) + onRestartCount);
				onDestroyCount = savedInstanceState.getInt("onDestroyCounter");
				if(onDestroyCount == -1)
					((TextView)findViewById(R.id.onDestroyString)).setText(getString(R.string.onDestroyString) + onDestroyCount);
			}*/

        //Shared Preferences
        preferences = getPreferences(MODE_PRIVATE);
        onCreateCount = preferences.getInt("onCreateCounter", onCreateCount);
        ((TextView)findViewById(R.id.onCreateString)).setText(getString(R.string.onCreateString) + onCreateCount);
        onStartCount = preferences.getInt("onStartCounter", onStartCount);
        ((TextView)findViewById(R.id.onStartString)).setText(getString(R.string.onStartString) + onStartCount);
        onResumeCount = preferences.getInt("onResumeCounter", onResumeCount);
        ((TextView)findViewById(R.id.onResumeString)).setText(getString(R.string.onResumeString) + onResumeCount);
        onPauseCount = preferences.getInt("onPauseCounter", onPauseCount);
        ((TextView)findViewById(R.id.onPauseString)).setText(getString(R.string.onPauseString) + onPauseCount);
        onStopCount = preferences.getInt("onStopCounter", onStopCount);
        ((TextView)findViewById(R.id.onStopString)).setText(getString(R.string.onStopString) + onStopCount);
        onRestartCount = preferences.getInt("onRestartCounter", onRestartCount);
        ((TextView)findViewById(R.id.onRestartString)).setText(getString(R.string.onRestartString) + onRestartCount);
        onDestroyCount = preferences.getInt("onDestroyCounter", onDestroyCount);
        ((TextView)findViewById(R.id.onDestroyString)).setText(getString(R.string.onDestroyString) + onDestroyCount);


        onCreateCount++;
        ((TextView)findViewById(R.id.onCreateString)).setText(getString(R.string.onCreateString)+onCreateCount);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(tag,"on start");
        onStartCount++;
        ((TextView)findViewById(R.id.onStartString)).setText(getString(R.string.onStartString)+onStartCount);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(tag,"on resume");
        onResumeCount++;
        ((TextView)findViewById(R.id.onResumeString)).setText(getString(R.string.onResumeString)+onResumeCount);
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(tag,"on pause");
        onPauseCount++;
        ((TextView)findViewById(R.id.onPauseString)).setText(getString(R.string.onPauseString)+onPauseCount);
    }

    @Override
    //it is in here where we save everything
    protected void onStop() {
        super.onStop();

        Log.i(tag,"on stop");
        onStopCount++;
        ((TextView)findViewById(R.id.onStopString)).setText(getString(R.string.onStopString)+onStopCount);

        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt("onCreateCounter", onCreateCount);
        edit.putInt("onStartCounter", onStartCount);
        edit.putInt("onResumeCounter", onResumeCount);
        edit.putInt("onPauseCounter", onPauseCount);
        edit.putInt("onStopCounter", onStopCount);
        edit.putInt("onRestartCounter", onRestartCount);
        edit.putInt("onDestroyCounter", onDestroyCount);
        edit.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(tag,"on restart");
        onRestartCount++;
        ((TextView)findViewById(R.id.onRestartString)).setText(getString(R.string.onRestartString)+onRestartCount);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(tag,"on destroy");
        onDestroyCount++;
        ((TextView)findViewById(R.id.onDestroyString)).setText(getString(R.string.onDestroyString)+onDestroyCount);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        Log.i(tag, "onSaveInstanceState called");

        savedInstanceState.putInt("onCreateCount", onCreateCount);
        savedInstanceState.putInt("onStartCount", onStartCount);
        savedInstanceState.putInt("onResumeCount", onResumeCount);
        savedInstanceState.putInt("onPauseCount", onPauseCount);
        savedInstanceState.putInt("onStopCount", onStopCount);
        savedInstanceState.putInt("onRestartCount", onRestartCount);
        savedInstanceState.putInt("onDestroyCount", onDestroyCount);
    }

    public void clearAll(View view)
    {
        Log.i(tag, "clearing all");
        onCreateCount = 0;
        onStartCount = 0;
        onResumeCount = 0;
        onPauseCount = 0;
        onStopCount = 0;
        onRestartCount = 0;
        onDestroyCount = 0;

        ((TextView)findViewById(R.id.onCreateString)).setText(getString(R.string.onCreateString)+onCreateCount);
        ((TextView)findViewById(R.id.onStartString)).setText(getString(R.string.onStartString)+onStartCount);
        ((TextView)findViewById(R.id.onResumeString)).setText(getString(R.string.onResumeString)+onResumeCount);
        ((TextView)findViewById(R.id.onPauseString)).setText(getString(R.string.onPauseString)+onPauseCount);
        ((TextView)findViewById(R.id.onStopString)).setText(getString(R.string.onStopString)+onStopCount);
        ((TextView)findViewById(R.id.onRestartString)).setText(getString(R.string.onRestartString)+onRestartCount);
        ((TextView)findViewById(R.id.onDestroyString)).setText(getString(R.string.onDestroyString)+onDestroyCount);
    }

    public void launchActivityTwo(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
}
