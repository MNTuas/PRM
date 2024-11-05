package com.example.fap.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fap.R;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    private List<AttendanceItem> items;

    public AttendanceAdapter(List<AttendanceItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, false);
        ViewHolder holder = new ViewHolder(view);

        holder.itemView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                AttendanceItem item = items.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("courseTitle", item.getTitle());
                bundle.putString("className", item.getClassName());
                bundle.putString("startDate", item.getStartDate());
                bundle.putString("endDate", item.getEndDate());
                bundle.putInt("percentage", item.getPercentage());
                Navigation.findNavController(v)
                        .navigate(R.id.action_attendance_to_detail, bundle);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceItem item = items.get(position);
        holder.titleText.setText(item.getTitle());
        holder.classNameText.setText("Class name: " + item.getClassName());
        holder.startDateText.setText("Start date: " + item.getStartDate());
        holder.endDateText.setText("End date: " + item.getEndDate());
        holder.percentageText.setText(item.getPercentage() + "%");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateData(List<AttendanceItem> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, classNameText, startDateText, endDateText, percentageText;

        ViewHolder(View view) {
            super(view);
            titleText = view.findViewById(R.id.text_title);
            classNameText = view.findViewById(R.id.text_class_name);
            startDateText = view.findViewById(R.id.text_start_date);
            endDateText = view.findViewById(R.id.text_end_date);
            percentageText = view.findViewById(R.id.text_percentage);
        }
    }


}