package com.frontend.cj_app.delivery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.api.RetrofitAPI;
import com.frontend.cj_app.common.model.Coury;
import com.frontend.cj_app.common.payload.Assignmented_Request;
import com.frontend.cj_app.common.payload.Assignmented_Response;
import com.frontend.cj_app.common.payload.Confirm_Request;
import com.frontend.cj_app.common.payload.Confirm_Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class delivery_status extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_status);

        Button ic_scan = findViewById(R.id.ic_scan);
        ic_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Bacode.class);
                startActivity(intent);
            }
        });

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.254.2.21:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private void getAssignmetedCouryList(Assignmented_Request request) {
        RetrofitAPI serviceApi = retrofit.create(RetrofitAPI.class);
        serviceApi.getAssignmetedCouryList(request).enqueue(new Callback<Assignmented_Response>() {
            @Override
            public void onResponse(Call<Assignmented_Response> call, Response<Assignmented_Response> response) {
                Assignmented_Response result = response.body();
                List<Coury> couryList = result.getCourList();

                // listView를 만들어야함.
            }
            @Override
            public void onFailure(Call<Assignmented_Response> call, Throwable t) {

            }
        });
    }
}