package com.example.customedialougass3;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
class LoginDialog extends Dialog {

    private TextView txtView;
    private RadioButton rdtUpper, rdtLower, rdtInit;
    private CheckBox txtReverse;
    private Button btnFinish;
    private String strInput;


    public interface OnDoneListner {
        void onDoneListner(LoginDialog EdtPopup, String strEditedInput);
    }

    private OnDoneListner onDoneListner = null;

    public void setOnDoneListner(OnDoneListner onDoneListner) {
        this.onDoneListner = onDoneListner;
    }


    LoginDialog(Context context, String input, OnDoneListner onDoneListner) {
        super(context);

        setContentView(R.layout.login_dialog);
        this.onDoneListner = onDoneListner;


        init();
        //String str=txtView.getText().toString();
        txtView.setText(input);

        String str = txtView.getText().toString();
        Listeners();


    }

    private void Listeners() {

        rdtUpper.setOnClickListener(new rdtUpperClickListener());
        rdtInit.setOnClickListener(new rdtinitClickListener());
        rdtLower.setOnClickListener(new rdtLowerClickListener());
        txtReverse.setOnClickListener(new txtReverseClickListener());
        btnFinish.setOnClickListener(new btnOnFinishListener());
    }

    private void init() {
        btnFinish = findViewById(R.id.btnFinish);
        txtReverse = findViewById(R.id.chReverseText);
        txtView = findViewById(R.id.txtView);
        rdtInit = findViewById(R.id.rdtinit);
        rdtLower = findViewById(R.id.rdtLower);
        rdtUpper = findViewById(R.id.rdtUpper);
        btnFinish = findViewById(R.id.btnFinish);
    }


    class rdtUpperClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {


            strInput = txtView.getText().toString();
            String MyString = strInput.toUpperCase();
            txtView.setText(MyString);

        }
    }


    class rdtLowerClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            strInput = txtView.getText().toString();
            String MyString = strInput.toLowerCase();
            txtView.setText(MyString);

        }
    }


    class rdtinitClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            strInput = txtView.getText().toString();
            String MyString = strInput.substring(0, 1).toUpperCase() + strInput.substring(1).toLowerCase();
            txtView.setText(MyString);


        }

    }


    class txtReverseClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            strInput = txtView.getText().toString();

            StringBuffer stringBuffer = new StringBuffer(strInput);
            txtView.setText(stringBuffer.reverse());
        }


    }


    class btnOnFinishListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            strInput = txtView.getText().toString();
            onDoneListner.onDoneListner(LoginDialog.this, strInput);

        }

    }
}
