package com.taplytics.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.taplytics.sdk.CodeBlockListener;
import com.taplytics.sdk.Taplytics;

/**
 * This Activity contains an example of a code block experiment.
 * <p/>
 * For this experiment, we will be testing multiple variations of dialog on a popup box.
 * <p/>
 * The dialog text, and title will be changed according to the variation chosen.
 *
 * @author vicv
 */
public class CodeBlockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_block_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Taplytics.runCodeBlock("hide button", new CodeBlockListener() {
            @Override
            public void run() {
                findViewById(R.id.code_block_dialog_button).setVisibility(View.GONE);
            }
        });

        // Make a popup when the button is clicked
    }


    // Back button animation...
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
