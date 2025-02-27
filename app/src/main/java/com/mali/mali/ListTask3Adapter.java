package com.mali.mali;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListTask3Adapter extends ArrayAdapter<File> {
    private Activity activity;
    private List<File> taskList;

    public ListTask3Adapter(Activity a, List<File> taskList) {
        super(a, R.layout.file_list, taskList);
        this.activity = a;
        this.taskList=taskList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListTask2ViewHolder holder = null;
        if (convertView == null) {
            holder = new ListTask2ViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.file_list, parent, false);
            holder.task_name = (TextView) convertView.findViewById(R.id.task_name3);
            holder.share_task = (ImageView) convertView.findViewById(R.id.task_fileImg);
            convertView.setTag(holder);
        } else {
            holder = (ListTask2ViewHolder) convertView.getTag();
        }

        holder.task_name.setId(position);
        //holder.task_time.setId(position);
        holder.share_task.setId(position);

        final File task = taskList.get(position);

        try{
            holder.task_name.setText(task.getName());
            //holder.task_time.setText(task.getPhoneNum());

        }catch(Exception e) {}
        return convertView;
    }
}

class ListTask3ViewHolder {
    TextView task_name,task_time;
    ImageView share_task;
}
