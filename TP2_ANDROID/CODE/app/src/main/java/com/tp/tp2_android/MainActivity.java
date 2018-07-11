package com.tp.tp2_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;


    Integer[] imgid={
            R.drawable.ensias,
            R.drawable.ensem,
            R.drawable.ehtp,
            R.drawable.emi,
            R.drawable.inpt,
            R.drawable.insea,
            R.drawable.esith
    };
    String[] itemname ={
            "ENSIAS",
            "ENSEM",
            "EHTP",
            "EMI",
            "INPT",
            "INSEA",
            "ESITH  "
    };
    String[] itemdesc ={
            "Ecole Nationale Supérieure d'Informatique et d'Analyse des Systèmes",
            "Ecole Nationale Supérieure d'Electricité et de Mécanique",
            "Ecole Hassania des Travaux Publics",
            "Ecole Mohammadia d'ingénieurs",
            "Institut National des Postes et Télécommunications",
            "Institut national de statistique et d'économie appliquée",
            "Ecole Supérieure des Industries du Textile et de l'Habillement"

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomListAdapter adapter=new CustomListAdapter(this, itemname,itemdesc, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.action_add: Toast.makeText(this, "Ajout Etablissement", Toast.LENGTH_SHORT).show();
            case  R.id.action_delete: Toast.makeText(this, "Suppression Etablissement", Toast.LENGTH_SHORT).show();
            case  R.id.action_settings: Toast.makeText(this, "A propos de l'Etablissement", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
