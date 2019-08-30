package com.example.fizculture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Student> students;

    DataAdapter(Context context, List<Student> studentes) {
        this.students = studentes;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.student_object, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Student phone = students.get(position);
        holder.nameView.setText(phone.getName());
        holder.standardView.setText(phone.getStandard());
        holder.visit_firstView.setChecked(phone.isVisit_first());
        holder.visit_secondView.setChecked(phone.isVisit_second());
        //holder.line.s
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, standardView;
        final CheckBox visit_firstView,visit_secondView;
        final ImageView line;
        ViewHolder(View view){
            super(view);
            nameView =  view.findViewById(R.id.name);
            standardView =  view.findViewById(R.id.company);
            visit_firstView=view.findViewById(R.id.visit_first);
            visit_secondView=view.findViewById(R.id.visit_second);
            line=view.findViewById(R.id.imageView);
        }
    }
}
