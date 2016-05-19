package com.taplytics.example;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.taplytics.sdk.TaplyticsVar;
import com.taplytics.sdk.TaplyticsVarListener;

/**
 * This Activity contains an example of a code block experiment.
 * <p/>
 * For this experiment, we will be testing multiple variations of dialog on a popup box.
 * <p/>
 * The dialog text, and title will be changed according to the variation chosen.
 *
 * @author vicv
 */
public class DynamicVariablesActivity extends AppCompatActivity {

    /**
     * The popup dialog text. Default it to the baseline variation *
     */
    private String DIALOG_TEXT = "This is the Baseline variation!";

    /**
     * The popup dialog title. Default it to the baseline variation *
     */
    private String DIALOG_TITLE = "The below text can be modified on the Taplytics Dashboard";

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_experiments_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TaplyticsVar<String> dialogTextVar = new TaplyticsVar<>("example var", "This is the default value", new TaplyticsVarListener() {
            @Override
            public void variableUpdated(Object o) {
                DIALOG_TEXT = (String) o;
            }
        });

        DIALOG_TEXT = dialogTextVar.get();

        // Make a popup when the button is clicked
        findViewById(R.id.code_experiment_dialog_button).setOnClickListener(dialogPopupClickListener());
    }

    /**
     * Create a popup with the text and title received from Taplytics, set by the code experiment. \
     */
    private OnClickListener dialogPopupClickListener() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // Set the text and title to the variables we are changing
                builder.setMessage(DIALOG_TEXT).setTitle(DIALOG_TITLE).setCancelable(true)
                        .setPositiveButton("NEAT!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
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
