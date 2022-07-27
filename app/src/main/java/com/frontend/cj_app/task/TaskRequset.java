package com.frontend.cj_app.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.api.RetrofitAPI;
import com.frontend.cj_app.common.model.AssingMentList;
import com.frontend.cj_app.common.payload.Assignment_Request;
import com.frontend.cj_app.common.payload.Assignment_Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskRequset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_requset);

        Intent intent = getIntent();
        String area = intent.getStringExtra("area");
        String dateTime = intent.getStringExtra("dateTime");
        String timeState = intent.getStringExtra("timeState");

        TextView requestTitle = findViewById(R.id.requestTitle);
        requestTitle.setText(dateTime);
        TextView requestArea = findViewById(R.id.requestArea);
        requestArea.setText(area);
        TextView requestDateTime = findViewById(R.id.requestDateTime);
        requestDateTime.setText(dateTime);
        TextView requestWorkTime = findViewById(R.id.requestWorkTime);
        requestWorkTime.setText(timeState);

        Button cntBtn1 = findViewById(R.id.cntBtn1);
        Button cntBtn2 = findViewById(R.id.cntBtn2);
        Button cntBtn3 = findViewById(R.id.cntBtn3);
        Button cntBtn4 = findViewById(R.id.cntBtn4);

        final int[] count = {0};
        cntBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntBtn1.setBackground(getDrawable(R.drawable.border_button3));
                cntBtn1.setTextColor(Integer.parseInt("#029aff"));
                count[0] = 30;
            }
        });
        cntBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntBtn2.setBackground(getDrawable(R.drawable.border_button3));
                cntBtn2.setTextColor(Integer.parseInt("#029aff"));
                count[0] = 50;
            }
        });
        cntBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntBtn3.setBackground(getDrawable(R.drawable.border_button3));
                cntBtn3.setTextColor(Integer.parseInt("#029aff"));
                count[0] = 70;
            }
        });
        cntBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cntBtn4.setBackground(getDrawable(R.drawable.border_button3));
                cntBtn4.setTextColor(Integer.parseInt("#029aff"));
                count[0] = 100;
            }
        });

        Button stateBtn1 = findViewById(R.id.stateBtn1);
        Button stateBtn2 = findViewById(R.id.stateBtn2);
        Button stateBtn3 = findViewById(R.id.stateBtn3);

        final String[] priority = {""};
        stateBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priority[0] = "WEIGHT";
            }
        });

        stateBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priority[0] = "SIZE";
            }
        });

        stateBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priority[0] = "TRAFFIC";
            }
        });

        Button btn_next8 = findViewById(R.id.gotaskconfirm);
        btn_next8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoAssignmentCoury(new Assignment_Request(area, priority[0], count[0], timeState));
            }
        });
    }
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.254.2.21:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private void autoAssignmentCoury(Assignment_Request data) {
        RetrofitAPI serviceApi = retrofit.create(RetrofitAPI.class);
        serviceApi.autoAssignmentCoury(data).enqueue(new Callback<Assignment_Response>() {
            @Override
            public void onResponse(Call<Assignment_Response> call, Response<Assignment_Response> response) {
                Assignment_Response result = response.body();

                AssingMentList first = result.getFirst();
                AssingMentList mid = result.getMid();
                AssingMentList end = result.getEnd();

                Intent intent = new Intent(getApplicationContext(), TaskConfirm.class);
                intent.putExtra("first", (Parcelable) first);
                intent.putExtra("mid", (Parcelable) mid);
                intent.putExtra("end", (Parcelable) end);
                intent.putExtra("request",(Parcelable) data);
                startActivity(intent);
            }
            @Override
            public void onFailure(Call<Assignment_Response> call, Throwable t) {

            }
        });
    }
}