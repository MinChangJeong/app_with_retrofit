package com.frontend.cj_app.task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.adapter.ChildListAdapter;
import com.frontend.cj_app.common.adapter.ParentListAdapter;
import com.frontend.cj_app.common.model.TASK_CHILD_LIST;
import com.frontend.cj_app.common.model.TASK_PARENT_LIST;

import java.util.ArrayList;

public class TaskRequsetMain extends AppCompatActivity {

    ArrayList<TASK_PARENT_LIST> task_parent_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_requset_main);

        this.InitializeParentListView();

        ListView listView = (ListView) findViewById(R.id.listView);
            final ParentListAdapter parentAdapter = new ParentListAdapter(this,task_parent_list);
            listView.setAdapter(parentAdapter);
        }
        public void InitializeParentListView()
        {
            String date[] = {"05.04 화", "05.04 수", "05.05 목"};
            task_parent_list = new ArrayList<TASK_PARENT_LIST>();

            for(int i=0; i<date.length; i++) {
                task_parent_list.add(new TASK_PARENT_LIST(date[i]));

                ArrayList<TASK_CHILD_LIST> task_child_list = new ArrayList<TASK_CHILD_LIST>();
                task_child_list.add(new TASK_CHILD_LIST("마포구", date[i] +" 07:00 ~ 17:00", "주간"));
            task_child_list.add(new TASK_CHILD_LIST("마포구", date[i] + " 00:00 ~ 07:00", "새벽"));
            task_child_list.add(new TASK_CHILD_LIST("마포구", date[i] + " 07:00 ~ 17:00", "잔여물량"));

            ListView childListView = (ListView)findViewById(R.id.childListView);
            final ChildListAdapter childAdapter = new ChildListAdapter(getApplicationContext(), task_child_list);
            childListView.setAdapter(childAdapter);

            childListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView parent, View v, int position, long id){
                    Log.i("area : ", childAdapter.getItem(position).getArea());

                    Intent intent = new Intent(getApplicationContext(), TaskRequset.class);
                    intent.putExtra("area", childAdapter.getItem(position).getArea());
                    intent.putExtra("dateTime", childAdapter.getItem(position).getDatetime());
                    intent.putExtra("timeState", childAdapter.getItem(position).getTimeState());
                    startActivity(intent);
                }
            });
        }
    }
}