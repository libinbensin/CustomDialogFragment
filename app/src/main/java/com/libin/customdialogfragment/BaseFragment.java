package com.libin.customdialogfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author Libin
 */
public class BaseFragment extends Fragment
        implements CustomDialogFragment.OnCustomDialogFragmentListener{

    @Override
    public void onDialogResult(AlertType alertType, int buttonIdentifier, Bundle bundle) {
        //NOP
    }

    public void showLongToast(@NonNull String msg) {
        ((BaseActivity)getActivity()).showLongToast(msg);
    }

    public void showAlert(AlertType alertType , Bundle bundle) {
        CustomDialogFragment customDialogFragment = CustomDialogFragment.newInstance(alertType, bundle);
        customDialogFragment.setTargetFragment(this , alertType.ordinal());
        customDialogFragment.show(getFragmentManager() , CustomDialogFragment.class.getSimpleName());
    }
}
