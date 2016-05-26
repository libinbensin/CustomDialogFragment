package com.libin.customdialogfragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                showAlert(AlertType.TEST_DIALOG , bundle);
            }
        });
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container , new TestFragment())
                    .commit();
        }
    }

    @Override
    public void onDialogResult(AlertType alertType, int buttonIdentifier, Bundle bundle) {
        super.onDialogResult(alertType, buttonIdentifier, bundle);
        switch (buttonIdentifier) {
            case CustomDialogFragment.BUTTON_POSITIVE:
                showLongToast("Dialog Positive button clicked");
                break;
            case CustomDialogFragment.BUTTON_NEGATIVE:
                showLongToast("Dialog Negative button clicked");
                break;
            case CustomDialogFragment.BUTTON_NEUTRAL:
                showLongToast("Dialog Neutral button clicked");
                break;
        }
    }
}
