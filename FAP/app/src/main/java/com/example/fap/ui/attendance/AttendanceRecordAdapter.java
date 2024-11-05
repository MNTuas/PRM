package com.example.fap.ui.attendance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fap.databinding.ItemAttendanceRecordBinding;

public class AttendanceRecordAdapter extends ListAdapter<AttendanceRecord, AttendanceRecordAdapter.ViewHolder> {

    protected AttendanceRecordAdapter() {
        super(new DiffUtil.ItemCallback<AttendanceRecord>() {
            @Override
            public boolean areItemsTheSame(@NonNull AttendanceRecord oldItem, @NonNull AttendanceRecord newItem) {
                return oldItem.getDate().equals(newItem.getDate());
            }

            @Override
            public boolean areContentsTheSame(@NonNull AttendanceRecord oldItem, @NonNull AttendanceRecord newItem) {
                return oldItem.getDate().equals(newItem.getDate()) &&
                        oldItem.getLecturer().equals(newItem.getLecturer()) &&
                        oldItem.isPresent() == newItem.isPresent();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemAttendanceRecordBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceRecord record = getItem(position);
        holder.binding.textDate.setText(record.getDate());
        holder.binding.textLecturer.setText(record.getLecturer());
        holder.binding.imageStatus.setVisibility(record.isPresent() ? View.VISIBLE : View.GONE);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemAttendanceRecordBinding binding;

        ViewHolder(ItemAttendanceRecordBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}