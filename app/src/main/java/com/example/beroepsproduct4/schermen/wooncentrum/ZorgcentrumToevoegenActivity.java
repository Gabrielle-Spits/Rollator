package com.example.beroepsproduct4.schermen.wooncentrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.beroepsproduct4.MainActivity;
import com.example.beroepsproduct4.R;
import com.example.beroepsproduct4.database.DataDBHelper;
import com.example.beroepsproduct4.model.Zorgcentrum;

public class ZorgcentrumToevoegenActivity extends AppCompatActivity {
    private final DataDBHelper dbHelper = new DataDBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zorgcentrum_toevoegen);

        EditText edttxtAfdeling = findViewById(R.id.edttxtAfdeling);
        EditText edttxtZorgcenturm = findViewById(R.id.edttxtZorgcenturm);
        Button btnZorgcentrumToevoegen = findViewById(R.id.btnZorgcentrumToevoegen);
        btnZorgcentrumToevoegen.setOnClickListener(v->{
            String afdeling = edttxtAfdeling.getText().toString();
            String zorcentrum = edttxtZorgcenturm.getText().toString();

            if(afdeling.isEmpty() || zorcentrum.isEmpty()){

            } else {
                Zorgcentrum zorgcentrum = new Zorgcentrum(afdeling,zorcentrum);
                long result = dbHelper.insertZorcentrum(zorgcentrum);
                if (result == -1 || result == 0){

                }else {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}