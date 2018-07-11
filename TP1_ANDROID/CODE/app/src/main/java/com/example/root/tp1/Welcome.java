package com.example.root.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    public TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String username = getIntent().getStringExtra("Username");
        String password = getIntent().getStringExtra("Password");
        TextView us =(TextView)findViewById(R.id.textView2);
        us.setText(username);

    }
}
