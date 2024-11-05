package com.umdsg.desarrollandounaaplicacin;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText name;
    private DatePicker date;
    private TextInputEditText phone;
    private TextInputEditText email;
    private TextInputEditText description;

    private String n;
    private String f;
    private String t;
    private String e;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = (TextInputEditText) findViewById(R.id.textInputNombre);
        phone = (TextInputEditText) findViewById(R.id.textInputTelefono);
        date = (DatePicker) findViewById(R.id.datePicker);
        email = (TextInputEditText) findViewById(R.id.textInputEmail);
        description = (TextInputEditText) findViewById(R.id.textInputDescripcion);

        Button BtnSigue = (Button) findViewById(R.id.buttonSiguiente);
        BtnSigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = Objects.requireNonNull(name.getText()).toString();
                t = Objects.requireNonNull(phone.getText()).toString();
                f = getDate();
                e = Objects.requireNonNull(email.getText()).toString();
                d = Objects.requireNonNull(description.getText()).toString();

                Intent intent = new Intent(MainActivity.this, Confirmar.class);
                intent.putExtra(getResources().getString(R.string.keyCodeNombre), n);
                intent.putExtra(getResources().getString(R.string.keyCodeFecha), f);
                intent.putExtra(getResources().getString(R.string.keyCodeTelefono), t);
                intent.putExtra(getResources().getString(R.string.keyCodeEmail), e);
                intent.putExtra(getResources().getString(R.string.keyCodeDescripcion), d);
                startActivity(intent);
                finish();

            }
        });
    }
    public String getDate() {
        return "Fecha Nacimiento: " + date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear();
    }
}