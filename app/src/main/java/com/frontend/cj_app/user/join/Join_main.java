package com.frontend.cj_app.user.join;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;

public class Join_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_main);
        EditText et_join_name = findViewById(R.id.et_join_name);
        EditText et_join_id = findViewById(R.id.et_join_id);
        EditText et_join_pw = findViewById(R.id.et_join_pw);
        EditText et_join_phonenum = findViewById(R.id.et_join_phonenum);
        Button button = findViewById(R.id.btn_next1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join_account.class);

                String user_name = et_join_name.getText().toString();
                String user_id = et_join_id.getText().toString();
                String user_pw = et_join_pw.getText().toString();
                String user_phonenum = et_join_phonenum.getText().toString();

                intent.putExtra("USER_NAME",user_name);
                intent.putExtra("USER_ID", user_id);
                intent.putExtra("USER_PW", user_pw);
                intent.putExtra("USER_PHONENUM", user_phonenum);

                startActivity(intent);
            }
        });
    }
}