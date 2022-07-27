package com.frontend.cj_app.user.join;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.api.RetrofitAPI;
import com.frontend.cj_app.common.payload.User_Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Join_carinform extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_carinform);
        Button button = findViewById(R.id.btn_next4);
        Spinner spinnercarcolor = findViewById(R.id.spinnercarcolor);
        EditText et_cartype = findViewById(R.id.et_carkind);
        EditText et_carnum = findViewById(R.id.et_carnum);
        Intent intent = getIntent();
        String USER_ID = intent.getStringExtra("USER_ID");
        String USER_NAME = intent.getStringExtra("USER_NAME");
        String USER_PW = intent.getStringExtra("USER_PW");
        String USER_PHONENUM = intent.getStringExtra("USER_PHONENUM");
        String USER_BANKNAME = intent.getStringExtra("USER_BANKNAME");
        Integer USER_ACCOUNT = intent.getIntExtra("USER_ACCOUNT",1);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join_area.class);
                String user_carnumcolor = spinnercarcolor.getSelectedItem().toString();
                String user_cartype = et_cartype.getText().toString();
                String user_carnum = et_carnum.getText().toString();
                intent.putExtra("USER_CARTYPE", user_cartype);
                intent.putExtra("USER_CARNUM", user_carnum);
                intent.putExtra("USER_CARNUMCOLOR",user_carnumcolor);
                intent.putExtra("USER_BANKNAME",  USER_BANKNAME);
                intent.putExtra("USER_ACCOUNT", USER_ACCOUNT);
                intent.putExtra("USER_ID",USER_ID);
                intent.putExtra("USER_NAME",USER_NAME);
                intent.putExtra("USER_PW",USER_PW);
                intent.putExtra("USER_PHONENUM",USER_PHONENUM);

                startActivity(intent);
            }
        });
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.254.2.21:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    // 회원 조회 예시
    private void registerUser(User_Request data) {
        RetrofitAPI serviceApi = retrofit.create(RetrofitAPI.class);
        serviceApi.registerUser(data).enqueue(new Callback<User_Request>() {
            @Override
            public void onResponse(Call<User_Request> call, Response<User_Request> response) {
                User_Request result = response.body();
            }
            @Override
            public void onFailure(Call<User_Request> call, Throwable t) {
                Log.e("get user up Error", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}