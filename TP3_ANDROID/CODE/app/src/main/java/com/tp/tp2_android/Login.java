package com.tp.tp2_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button button3 ;
    private Button button;
    private Button button2;

    DbHandler db;
    public void Register (View view)
    {
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {
                                           EditText n =(EditText)findViewById(R.id.editText) ;
                                           String name = n.getText().toString();
                                           EditText p =(EditText)findViewById(R.id.editText2) ;
                                           String password = p.getText().toString();
                                           int id= checkUser(new User(name,password));
                                           if(id==-1)
                                           {
                                               Toast.makeText(Login.this,name+":User Does Not Exist",Toast.LENGTH_SHORT).show();

                                           }
                                           else
                                           {
                                               Toast.makeText(Login.this,"Connected.Welcome "+name,Toast.LENGTH_SHORT).show();
                                               Intent startNewActivity = new Intent(Login.this,MainActivity.class);
                                               startActivity(startNewActivity);
                                           }

                                       }
                                   }
        );

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          Intent st = new Intent(Login.this,signup.class);
                                          startActivity(st);
                                      }
                                  }
        );

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {

                                          EditText n =(EditText)findViewById(R.id.editText) ;
                                          String name = n.getText().toString();
                                          EditText p =(EditText)findViewById(R.id.editText2) ;
                                          String password = p.getText().toString();
                                          int id= checkUser(new User(name,password));
                                          if(id==-1)
                                          {
                                              Toast.makeText(Login.this,name+":User Does Not Exist",Toast.LENGTH_SHORT).show();

                                          }
                                          else
                                          {
                                              db.deleteUser(new User(name, password));
                                              Toast.makeText(Login.this,"Account Deleted "+name,Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
        );


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DbHandler(Login.this);
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
