package com.libin.customdialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Libin
 */
public class TestFragment extends BaseFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test , null);
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.show_alert_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showAlert(AlertType.TEST_DIALOG , null);
                    }
                });
    }
}
