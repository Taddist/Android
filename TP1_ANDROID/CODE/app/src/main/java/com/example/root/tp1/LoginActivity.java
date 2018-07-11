package com.example.root.tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import  android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String tag="Function_is_EXECUTE_Lo";
    private Button button3 ;
    private Button button;

    public void Register (View view)
    {
        button3 = (Button)findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {
                                           EditText n =(EditText)findViewById(R.id.editText) ;
                                           String strn = n.getText().toString();
                                           EditText p =(EditText)findViewById(R.id.editText2) ;
                                           String strp = p.getText().toString();
                                           Intent startNewActivity = new Intent(LoginActivity.this,Welcome.class);
                                           startNewActivity.putExtra("Username",strn);
                                           startNewActivity.putExtra("Password",strp);
                                           startActivity(startNewActivity);
                                       }
                                   }
        );

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {
                                           Intent st = new Intent(LoginActivity.this,MainActivity.class);
                                           startActivity(st);
                                       }
                                   }
        );

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(tag,"onCreate");
    }
}
