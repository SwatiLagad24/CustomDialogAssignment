package com.example.customedialougass3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText editText;
private Button button;
private  LoginDialog loginDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



editText=findViewById(R.id.editText);
button=findViewById(R.id.btnSignIn);
button.setOnClickListener(new ButtonClickListener());



    }


    interface inputText {
        void onEditClick(MainActivity Main);
    }



    class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){

            loginDialog = new LoginDialog(MainActivity.this, editText.getText().toString(),new DoneActions());
            loginDialog.setOnDoneListner(new DoneActions());
            loginDialog.show();



        }
    }

    class DoneActions implements LoginDialog.OnDoneListner{
        @Override
        public void onDoneListner(LoginDialog EdtPopup, String strEditedInput) {

            editText.setText(strEditedInput+"");
            loginDialog.dismiss();
        }
    }


}
