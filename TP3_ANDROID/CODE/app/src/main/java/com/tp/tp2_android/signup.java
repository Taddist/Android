package com.tp.tp2_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private Button button3 ;
    private Button button;
    DbHandler db;
    public void Enregistrer (View view)
    {
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {
                                           EditText n =(EditText)findViewById(R.id.login) ;
                                           String name = n.getText().toString();
                                           EditText p =(EditText)findViewById(R.id.mp) ;
                                           String password = p.getText().toString();
                                           EditText cp =(EditText)findViewById(R.id.cmp) ;
                                           String cpassword = cp.getText().toString();
                                           int id= checkUser(new User(name,password));
                                           if(password.equals(cpassword)==true)
                                           {
                                               if(id==-1)
                                               {
                                                   db.addUser(new User(name, password));
                                                   Toast.makeText(signup.this,"Account Created",Toast.LENGTH_SHORT).show();

                                               }
                                               else
                                               {
                                                   Toast.makeText(signup.this,"User Exist "+name,Toast.LENGTH_SHORT).show();

                                               }

                                           }
                                           else
                                           {
                                               Toast.makeText(signup.this,"Password doesn't match  ",Toast.LENGTH_SHORT).show();
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
                                          Intent st = new Intent(signup.this,Login.class);
                                          startActivity(st);
                                      }
                                  }
        );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db=new DbHandler(signup.this);
    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}
