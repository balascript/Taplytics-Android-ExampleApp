package com.taplytics.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

		((Button) findViewById(R.id.code_experiments_button)).setOnClickListener(getOnClickListener(this, CodeExperimentsActivity.class));
		((Button) findViewById(R.id.user_information_button)).setOnClickListener(getOnClickListener(this, UserAttributesActivity.class));
		((Button) findViewById(R.id.events_button)).setOnClickListener(getOnClickListener(this, EventsActivity.class));

	}

	private OnClickListener getOnClickListener(final Context c, final Class<?> activityClass) {
		return new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(c, activityClass);
				startActivity(intent);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

			}
		};
	}
}
