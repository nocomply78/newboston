package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements OnClickListener{
	Button start, startFor;
	EditText sendET;
	TextView gotAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		initialise();
	}
	
	private void initialise() {
		start = (Button) findViewById(R.id.bSA);
		startFor = (Button) findViewById(R.id.bSAFR);
		sendET = (EditText) findViewById(R.id.etSend);
		gotAnswer = (TextView) findViewById(R.id.tvText);
		start.setOnClickListener(this);
		startFor.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()){
		case R.id.bSA:
			String bread = sendET.getText().toString();
			Bundle basket = new Bundle();
			basket.putString("key", bread);
			Intent a = new Intent(this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent i = new Intent(this, OpenedClass.class);
			startActivityForResult(i, 0);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			Bundle basket = data.getExtras();
			String s = basket.getString("answer");
			gotAnswer.setText(s);
		}
	}


}
