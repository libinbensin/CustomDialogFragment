package com.libin.customdialogfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author Libin
 */
public class BaseActivity extends AppCompatActivity
        implements CustomDialogFragment.OnCustomDialogFragmentListener{

    private Toast mToast;

    @Override
    public void onDialogResult(AlertType alertType, int buttonIdentifier, Bundle bundle) {
        //NOP
    }

    public void showAlert(AlertType alertType , Bundle bundle) {
        CustomDialogFragment customDialogFragment = CustomDialogFragment.newInstance(alertType, bundle);
        customDialogFragment.show(getSupportFragmentManager() , CustomDialogFragment.class.getSimpleName());
        return;
    }

    public void showLongToast(@NonNull String msg) {
        showToast(msg, Toast.LENGTH_LONG);
    }

    private void showToast(final String msg, final int length) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mToast != null)
                    mToast.cancel();
                mToast = Toast.makeText(BaseActivity.this, msg, length);
                mToast.show();
            }
        });
    }
}
