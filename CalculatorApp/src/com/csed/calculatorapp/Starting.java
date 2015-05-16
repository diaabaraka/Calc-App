package com.csed.calculatorapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Starting extends Activity {
	MediaPlayer sound;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starting);
		sound=MediaPlayer.create(Starting.this, R.raw.sound);
		sound.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint=new Intent("com.csed.calculatorapp.CALC");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sound.release();
		finish();
	}
	
}
