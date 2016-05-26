package com.libin.customdialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

/**
 * @author Libin
 */
public class CustomDialogFragment extends DialogFragment{

    /**
     * The identifier for the positive button.
     */
    public static final int BUTTON_POSITIVE = -1;

    /**
     * The identifier for the negative button.
     */
    public static final int BUTTON_NEGATIVE = -2;

    /**
     * The identifier for the neutral button.
     */
    public static final int BUTTON_NEUTRAL = -3;
    private static final String KEY_ALERT_TYPE = "key-alert-type";
    private static final String KEY_BUNDLE = "key-bundle";

    private OnCustomDialogFragmentListener mListener;
    private AlertType mAlertType;
    private Bundle mBundle;

    public static CustomDialogFragment newInstance(AlertType alertType , Bundle bundle) {
        Bundle args = new Bundle();
        args.putSerializable(KEY_ALERT_TYPE , alertType);
        args.putBundle(KEY_BUNDLE , bundle);
        CustomDialogFragment fragment = new CustomDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Bundle args = savedInstanceState != null ? savedInstanceState : getArguments();
        mAlertType = (AlertType) args.getSerializable(KEY_ALERT_TYPE);
        mBundle = args.getBundle(KEY_BUNDLE);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_messge);
        builder.setPositiveButton(R.string.dialog_positive_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mListener != null) {
                    mListener.onDialogResult(mAlertType, BUTTON_POSITIVE , mBundle);
                }
            }
        });

        builder.setNegativeButton(R.string.dialog_negative_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mListener != null) {
                    mListener.onDialogResult(mAlertType, BUTTON_NEGATIVE , mBundle);
                }
            }
        });

        builder.setPositiveButton(R.string.dialog_neutral_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(mListener != null) {
                    mListener.onDialogResult(mAlertType, BUTTON_NEUTRAL , mBundle);
                }
            }
        });
        return builder.create();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBundle(KEY_BUNDLE , mBundle);
        outState.putSerializable(KEY_ALERT_TYPE , mAlertType);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment targetFragment = getTargetFragment();
        if(targetFragment instanceof OnCustomDialogFragmentListener) {
            mListener = (OnCustomDialogFragmentListener) targetFragment;
        }
        else if(context instanceof OnCustomDialogFragmentListener) {
            mListener = (OnCustomDialogFragmentListener) context;
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    public interface OnCustomDialogFragmentListener {
        void onDialogResult(AlertType alertType , int buttonIdentifier , Bundle bundle);
    }

}
