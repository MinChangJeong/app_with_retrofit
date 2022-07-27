package com.frontend.cj_app.dsla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;

public class dsla_check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsla_check);

        Button agreebutton3 = findViewById(R.id.agreebutton3);
        agreebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), dsla_agreement.class);
                startActivity(intent);
            }
        });

    }
}