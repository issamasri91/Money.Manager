package com.issamelasri.moneymanager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExamplDialog extends AppCompatDialogFragment {
    private EditText username;
    private EditText password;
    private ExamplDialogListener examplDialogListener;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("add")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String us = username.getText().toString();
                        String pass = password.getText().toString();
                        examplDialogListener.applyTexte(us, pass);

                    }
                });
        username = view.findViewById(R.id.editUsername);
        password = view.findViewById(R.id.editPassword);
        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            examplDialogListener = (ExamplDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implements Example dialog listener ");
        }
    }

    public interface ExamplDialogListener {
        void applyTexte(String username, String password);

    }
}
