package com.taplytics.example;

import android.app.Application;

import com.taplytics.sdk.Taplytics;

/**
 * Overriding the application is necessary. This is so application context is passed to the sdk, as well as to set up the sdk before any
 * other content loads.
 * <p/>
 * It is possible to do this in your application's main activity onCreate(), however for maximum functionality, instantiate Taplytics in an
 * application class.
 * <p/>
 * Do not forget to add the name descriptor to your application tag in androidmanifest.xml!
 *
 * @author vicv
 */
public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Supply your api key here and that's it!
        Taplytics.startTaplytics(this, "Your API key");
    }

}
