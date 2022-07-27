package com.frontend.cj_app.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.frontend.cj_app.R;
import com.frontend.cj_app.common.model.TASK_PARENT_LIST;

import java.util.ArrayList;

public class ParentListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<TASK_PARENT_LIST> task_parent;

    public ParentListAdapter(Context context, ArrayList<TASK_PARENT_LIST> data) {
        mContext = context;
        task_parent = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return task_parent.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public TASK_PARENT_LIST getItem(int position) {
        return task_parent.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.task_requset_parent_list, null);

        TextView date = (TextView)view.findViewById(R.id.date);
        date.setText(task_parent.get(position).getDate());

        return view;
    }
}
