package com.frontend.cj_app.delivery;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.api.RetrofitAPI;
import com.frontend.cj_app.common.payload.Complete_Request;
import com.frontend.cj_app.common.payload.Complete_Response;
import com.frontend.cj_app.common.payload.Confirm_Request;
import com.frontend.cj_app.common.payload.Confirm_Response;
import com.frontend.cj_app.task.TaskList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class delivery_check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_check);

        final Button btn_lock = (Button) findViewById(R.id.btn_lock);
        btn_lock.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(delivery_check.this);
                dlg.setTitle("비밀번호"); //제목
                dlg.setMessage("#1219 7676#"); //내용
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dlg.show();
            }
        });

        final Button btn_lost = (Button) findViewById(R.id.btn_lost);
        btn_lost.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(delivery_check.this);
                dlg.setTitle("분실/파손"); //제목
                dlg.setMessage("지원팀에 접수해주세요.(1588-1255)"); //내용
                dlg.setPositiveButton("연결", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        completedCoury(new Complete_Request("분실/파손"));
                    }
                });
                dlg.show();
            }

    });
        final Button btn_wrong = (Button) findViewById(R.id.btn_wrong);
        btn_wrong.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(delivery_check.this);
                dlg.setTitle("오배송"); //제목
                dlg.setMessage("지원팀에 접수해주세요.(1588-1255)"); //내용
                dlg.setPositiveButton("연결", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        completedCoury(new Complete_Request("오배송"));
                    }
                });
                dlg.show();
            }
        });
        Button btn_completion = findViewById(R.id.btn_completion);
        btn_completion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                completedCoury(new Complete_Request("배송완료"));
            }
        });

        Button btn_call = (Button) findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01088156785"));
                startActivity(intent);
            }

        });

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.254.2.21:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private void completedCoury(Complete_Request request) {
        RetrofitAPI serviceApi = retrofit.create(RetrofitAPI.class);
        serviceApi.updateCompletedCoury(request).enqueue(new Callback<Complete_Response>() {
            @Override
            public void onResponse(Call<Complete_Response> call, Response<Complete_Response> response) {
                Complete_Response result = response.body();
                Intent intent = new Intent(getApplicationContext(), delivery_check_detail.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Complete_Response> call, Throwable t) {

            }
        });

    }
}