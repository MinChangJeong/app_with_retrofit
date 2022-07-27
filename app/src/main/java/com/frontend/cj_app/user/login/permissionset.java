package com.frontend.cj_app.user.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;
import com.frontend.cj_app.task.TaskRequsetMain;

public class permissionset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_set);
        Button NextButton3 = findViewById(R.id.btn_next7);
        NextButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TaskRequsetMain.class);
                startActivity(intent);
            }
        });

    }
}