package com.taplytics.example;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.taplytics.sdk.Taplytics;

/**
 * In this activity, we send some basic events to taplytics.
 * 
 * @author vicv
 * 
 */
public class EventsActivity extends ActionBarActivity {

	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_layout);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		// Very simply you can have taplytics log events.
		Taplytics.logEvent("Activity Started");

		// However, Taplytics will automatically track all activity changes for you!

		// You can also attach optional metaData. Here we'll put something like 'subscriber' as an example.
		final JSONObject eventMetaData = new JSONObject();
		try {
			eventMetaData.put("subsrciber", false);
		} catch (JSONException e) {
			// Do something with json exception
		}

		((Button) findViewById(R.id.events_send_button)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				count++;

				// And thats it! If you don't want to send any metaData, just send 'null'
				Taplytics.logEvent("Button Clicked", count, eventMetaData);
			}
		});
	}

	// Animation overrides..
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			super.onBackPressed();
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
		return true;
	}
}