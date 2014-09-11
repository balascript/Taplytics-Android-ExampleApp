package com.taplytics.example;

import java.util.HashMap;
import java.util.Map;

import com.taplytics.sdk.Taplytics;

import android.app.Application;

public class ExampleApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("debugLogging", true);
		Taplytics.startTaplytics(this, "8fb61a0da77a42509e5956988fbd457f4a8cdb46", options);
	}

}
