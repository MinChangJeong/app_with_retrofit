package com.frontend.cj_app.user.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.api.RetrofitAPI;
import com.frontend.cj_app.common.payload.User_login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button LoginButton = findViewById(R.id.btn_login);
        EditText editText_id = findViewById(R.id.edittext_id);
        EditText editText_password = findViewById(R.id.edittext_password);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.254.2.21:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            @Override
            public void onClick(View view) {

                String loginId = editText_id.getText().toString();
                String loginPW = editText_password.getText().toString();
                RetrofitAPI loginService = retrofit.create(RetrofitAPI.class);
                User_login data = new User_login(loginId,loginPW);
                loginService.LoginUser(data).enqueue(new Callback<User_login>() {
                    @Override
                    public void onResponse(Call<User_login> call, Response<User_login> response) {
                        Log.i("ted",String.valueOf(response));
                        User_login login = response.body(); //데이터받기
                        Log.i("ted",String.valueOf(login));
                        if (login != null){
                            Intent intent = new Intent(getApplicationContext(), permissionset.class);
                            Toast.makeText(getApplicationContext(),"로그인하셨습니다.",Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }else
                            Toast.makeText(getApplicationContext(),"회원가입을 해주세요",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User_login> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"로그인실패",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        /*Button FindIDButton = findViewById(R.id.btn_findid);
        FindIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindID.class);
                startActivity(intent);
            }
        });

        Button FindPasswordButton = findViewById(R.id.btn_findpw);
        FindPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindPassword.class);
                startActivity(intent);
            }
        });
        Button GoJoinButton = findViewById(R.id.btn_ToJoin_2);
        GoJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Join_Main.class);
                startActivity(intent);
            }
        });*/
    }
}