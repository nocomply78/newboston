package com.thenewboston.travis;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SoundStuff extends Activity implements OnClickListener{

	SoundPool sP;
	int explosion = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = new View(this);
		v.setOnClickListener(this);
		setContentView(v);
		sP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		explosion = sP.load(this, R.raw.explosion, 1);
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(explosion != 0)
			sP.play(explosion, 1, 1, 0, 0, 1);
	}
	
}
