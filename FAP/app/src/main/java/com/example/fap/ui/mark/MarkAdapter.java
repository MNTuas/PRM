package com.example.fap.ui.mark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fap.R;

import java.util.List;

public class MarkAdapter extends RecyclerView.Adapter<MarkAdapter.MarkViewHolder> {
    private List<Mark> marks;
    private OnMarkClickListener listener;

    public interface OnMarkClickListener {
        void onMarkClick(Mark mark);
    }

    public MarkAdapter(List<Mark> marks, OnMarkClickListener listener) {
        this.marks = marks;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course_mark, parent, false);
        return new MarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarkViewHolder holder, int position) {
        Mark mark = marks.get(position);
        holder.courseTitle.setText(mark.getCourseCode() + " - " + mark.getCourseName());
        holder.className.setText("Class name: " + mark.getClassName());
        holder.average.setText("Average: " + mark.getAverage());
        holder.presentIndicator.setVisibility(mark.isPresent() ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMarkClick(mark);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marks.size();
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
        notifyDataSetChanged();
    }

    static class MarkViewHolder extends RecyclerView.ViewHolder {
        TextView courseTitle, className, average, presentIndicator;

        MarkViewHolder(View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            className =   itemView.findViewById(R.id.className);
            average = itemView.findViewById(R.id.average);
            presentIndicator = itemView.findViewById(R.id.presentIndicator);
        }
    }
}
