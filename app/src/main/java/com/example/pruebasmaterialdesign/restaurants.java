package com.example.pruebasmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;

public class restaurants extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    CardView clothingCard, b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ImageButton arrowback, ubi1, num1, ubi2, num2, ubi3, num3;

        arrowback = findViewById(R.id.arrowback);

        ImageView atarasii, macdo, elitaliano;

        arrowback = findViewById(R.id.arrowback);
        atarasii = findViewById(R.id.atarasii);
        macdo = findViewById(R.id.macdo);
        elitaliano = findViewById(R.id.ElItaliano);

        ubi1 = findViewById(R.id.ubi1);
        ubi1.setOnClickListener(this);
        num1 = findViewById(R.id.num1);
        num1.setOnClickListener(this);

        ubi2 = findViewById(R.id.ubi2);
        ubi2.setOnClickListener(this);
        num2 = findViewById(R.id.num2);
        num2.setOnClickListener(this);

        ubi3 = findViewById(R.id.ubi3);
        ubi3.setOnClickListener(this);
        num3 = findViewById(R.id.num3);
        num3.setOnClickListener(this);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"http://www.atarasiisushi.es/");
                startActivity(intent);
            }

        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"https://mcdonalds.es/");
                startActivity(intent);
            }

        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"https://media-cdn.tripadvisor.com/media/photo-s/0c/f3/fb/15/el-italiano-de-granollers.jpg");
                startActivity(intent);
            }

        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.restaurants, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        arrowback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(restaurants.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String opcionSeleccionada = parent.getItemAtPosition(position).toString();

        if (opcionSeleccionada.equals("Sushi")) {
            Intent intent = new Intent(restaurants.this, sushi.class);
            startActivity(intent);
        } else if (opcionSeleccionada.equals("Italià")) {
            Intent intent = new Intent(restaurants.this, italia.class);
            startActivity(intent);
        } else if (opcionSeleccionada.equals("Menjar Ràpid")) {
            Intent intent = new Intent(restaurants.this, menjaRapid.class);
            startActivity(intent);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}