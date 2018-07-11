package com.example.root.tp1;
import android.content.Intent;
import android.util.Log;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String tag="Function_is_EXECUTE_Mai";
    public Button button2 ;
    public void SignIn (View view)
    {
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent startNewActivity = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(startNewActivity);
            }
        }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag,"onCreate");
    }
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Log.i(tag,"onDestroy");
    }
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Log.i(tag,"onPause");
    }
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Log.i(tag,"onResume");
    }
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.i(tag,"onStart");
    }
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Log.i(tag,"onStop");
    }
}