package com.example.eliseo.separarvocalesconsonantes;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner combo;
    EditText frase, resultado;
    TextView tvSeleccion;
    private final static String[] separarPor = {"Vocales", "Consonantes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        combo = (Spinner) findViewById(R.id.combo);
        resultado = (EditText) findViewById(R.id.resultado);
        frase = (EditText) findViewById(R.id.frase);

        tvSeleccion = (TextView) findViewById(R.id.tvSeleccion);


        //Creamos el adaptador usando recursos arrays.xml
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);

        //usando codigo java
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, separarPor);


        combo.setAdapter(adapter);


//// dandole eventos onchange al spinner
        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvSeleccion.setText(separarPor[i]);
                //proceso();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


    }


    public void btnOk(View v) {
        proceso();

    }

    public void proceso() {
        String seleccion = combo.getSelectedItem().toString();
        String stringFrase = frase.getText().toString().toUpperCase();
        String cadenaVocales = "", cadenaConsonantes = "";

        for (int i = 0; i < stringFrase.length(); i++) {
            if (stringFrase.charAt(i) == 'A' ||
                    stringFrase.charAt(i) == 'E' ||
                    stringFrase.charAt(i) == 'I' ||
                    stringFrase.charAt(i) == 'O' ||
                    stringFrase.charAt(i) == 'U') {
                cadenaVocales += stringFrase.charAt(i) + "-";

            } else {
                cadenaConsonantes += stringFrase.charAt(i) + "-";
            }
        }
        if (seleccion.equals("Vocales")) {
            resultado.setText(cadenaVocales);

        }
        if (seleccion.equals("Consonantes")) {
            resultado.setText(cadenaConsonantes);

        }

        tvSeleccion.setText(seleccion);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
