package com.frontend.cj_app.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.frontend.cj_app.R;

public class TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        Bundle data = getIntent().getExtras();
        String area = data.getString("area");
        String worktime = data.getString("workTime");
        String datetime = data.getString("datetime");
        int count = data.getInt("count");
        String packageName = data.getString("packageName");

        TextView confirmArea = findViewById(R.id.confirmArea);
        confirmArea.setText(area);
        TextView confirmWorktime = findViewById(R.id.confirmWorkTime);
        confirmWorktime.setText(worktime);
        TextView confirmCount = findViewById(R.id.confirmCount);
        confirmCount.setText(count);
        TextView confirmPackageName = findViewById(R.id.confirmPackageName);
        confirmPackageName.setText(packageName);
    }
}