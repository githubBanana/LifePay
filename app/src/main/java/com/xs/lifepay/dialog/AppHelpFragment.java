package com.xs.lifepay.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-06 16:48
 * @email Xs.lin@foxmail.com
 */
public class AppHelpFragment extends DialogFragment {
    private static final String TAG = "AppHelpFragment";

    private static final String EXTRA_MESSAGE = "message";
    public static AppHelpFragment getInstance(String message) {
        final AppHelpFragment ahf = new AppHelpFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MESSAGE,message);
        ahf.setArguments(bundle);
        return ahf;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Bundle bundle = getArguments();
        final String message = bundle.getString(EXTRA_MESSAGE);

        return new AlertDialog.Builder(getActivity())
                .setTitle("Notify")
                .setMessage(message)
                .setPositiveButton("ok",null)
                .show();
    }
}
