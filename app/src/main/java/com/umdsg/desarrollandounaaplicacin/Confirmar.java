package com.umdsg.desarrollandounaaplicacin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Confirmar extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle parameters = getIntent().getExtras();
        final String name = parameters.getString(getResources().getString(R.string.keyCodeNombre));
        String Date = parameters.getString(getResources().getString(R.string.keyCodeFecha));
        final String phone = parameters.getString(getResources().getString(R.string.keyCodeTelefono));
        final String email = parameters.getString(getResources().getString(R.string.keyCodeEmail));
        final String description = parameters.getString(getResources().getString(R.string.keyCodeDescripcion));

        TextView textViewName = (TextView) findViewById(R.id.textViewNombre);
        TextView textViewDate = (TextView) findViewById(R.id.textViewFecha);
        TextView textViewPhone = (TextView) findViewById(R.id.textViewTel);
        TextView textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView textViewDescription = (TextView) findViewById(R.id.textViewDescripcion);

        textViewName.setText(name);
        textViewDate.setText(Date);
        textViewPhone.setText(phone);
        textViewEmail.setText(email);
        textViewDescription.setText(description);

        Button btnEditorDates = (Button) findViewById(R.id.buttonEditar);
        btnEditorDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Confirmar.this, MainActivity.class);
                                startActivity(intent);
                finish();

            }
        });









    }
}