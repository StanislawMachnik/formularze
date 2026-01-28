<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:layout_margin="12.5dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Samochody"
        android:textSize="35sp"
        android:layout_marginBottom="50dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="25dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Cena : "
            android:textSize="25sp" />

        <EditText
            android:id="@+id/cena"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:inputType="number" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="25dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Marki : "
            android:textSize="25sp" />

        <Spinner
            android:id="@+id/marki"
            android:layout_width="250dp"
            android:layout_height="wrap_content" />
    </LinearLayout>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Model :"
        android:textSize="25sp" />

    <ListView
        android:id="@+id/lista"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:layout_marginBottom="25dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="10dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Rocznik : "
            android:textSize="25sp" />

        <TextView
            android:id="@+id/rokTekst"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="2000"
            android:textSize="18sp" />
    </LinearLayout>

    <SeekBar
        android:id="@+id/rok"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <CheckBox
        android:id="@+id/wlascicel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Czy pierwszy właściciel" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="25dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Historia "
            android:textSize="25sp" />

        <RadioGroup
            android:id="@+id/radioGroup"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">

            <RadioButton
                android:id="@+id/radio1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="bezwypadkowy" />

            <RadioButton
                android:id="@+id/radio2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="po wypadku" />

            <RadioButton
                android:id="@+id/radio3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="do kasacji" />
        </RadioGroup>
    </LinearLayout>

    <Button
        android:id="@+id/dodaj"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Dodaj"
        android:layout_gravity="center" />

    <TextView
        android:id="@+id/all"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp" />

</LinearLayout>


<resources>
    <string name="app_name">Lekcja</string>
    <string-array name="marki_lista">
        <item>Toyota</item>
        <item>Ford</item>
        <item>Honda</item>
        <item>Opel</item>
        <item>Renault</item>
    </string-array>
</resources>


package com.example.zadanie3;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ListView lista;
    private EditText cenaPole;
    private SeekBar rok;
    private CheckBox wlasciciel;
    private TextView all;
    private RadioGroup radioGroup;
    private RadioButton radio;
    private Button dodaj;
    private TextView rokTekst;
    private ArrayList<String> modelLista;
    private ArrayAdapter<String> arrayAdapter;

    private String marka;
    private String model;
    private int rocznik;
    private double cena;
    private boolean czyWlasciciel;
    private String historia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        marka = "";
        model = "";
        rocznik = 0;
        cena = 0;
        czyWlasciciel = false;
        historia = "";

        all = findViewById(R.id.all);
        lista = findViewById(R.id.lista);
        spinner = findViewById(R.id.marki);
        rok = findViewById(R.id.rok);
        rokTekst = findViewById(R.id.rokTekst);
        wlasciciel = findViewById(R.id.wlascicel);
        dodaj = findViewById(R.id.dodaj);
        radioGroup = findViewById(R.id.radioGroup);
        cenaPole = findViewById(R.id.cena);

        String[][] tablica = {
                {"Yaris", "Corolla", "RAV4"},
                {"Focus", "Mustang", "Fiesta", "Explorer"},
                {"Civic", "Accord"},
                {"Astra", "Corsa", "Insignia", "Mokka", "Adam"},
                {"Clio"}
        };

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.marki_lista,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        modelLista = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, modelLista);
        lista.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                modelLista.clear();
                for (String s : tablica[position]) {
                    modelLista.add(s);
                }
                arrayAdapter.notifyDataSetChanged();
                marka = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        lista.setOnItemClickListener((parent, view, position, id) ->
                model = (String) lista.getItemAtPosition(position)
        );

        int minRok = 2000;
        int maxRok = 2026;

        rok.setMax(maxRok - minRok);
        rok.setProgress(0);
        rocznik = minRok;
        rokTekst.setText(String.valueOf(rocznik));

        rok.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rocznik = minRok + progress;
                rokTekst.setText(String.valueOf(rocznik));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == -1) {
                historia = "";
                return;
            }
            radio = findViewById(checkedId);
            historia = radio.getText().toString();
        });

        dodaj.setOnClickListener(view -> {
            if (marka.isEmpty() || model.isEmpty() || historia.isEmpty()) {
                Toast.makeText(this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                cena = Double.parseDouble(cenaPole.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, "Nieprawidłowa cena", Toast.LENGTH_SHORT).show();
                return;
            }

            czyWlasciciel = wlasciciel.isChecked();

            String wynik =
                    "Marka: " + marka + "\n" +
                            "Model: " + model + "\n" +
                            "Rocznik: " + rocznik + "\n" +
                            "Cena: " + cena + " zł\n" +
                            "Pierwszy właściciel: " + (czyWlasciciel ? "Tak" : "Nie") + "\n" +
                            "Historia: " + historia + "\n\n";

            all.setText(wynik);

            cenaPole.setText("");
            wlasciciel.setChecked(false);
            radioGroup.clearCheck();
            rok.setProgress(0);
            rocznik = minRok;
            rokTekst.setText(String.valueOf(rocznik));
            model = "";
            historia = "";
        });
    }
}
