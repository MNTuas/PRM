package com.example.fap.ui.mark;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fap.databinding.FragmentMarkDetailBinding;

public class MarkDetailFragment extends Fragment {
    private FragmentMarkDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMarkDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadArgumentData();
        setupGradeTable();
    }



    private void loadArgumentData() {
        Bundle args = getArguments();
        if (args != null) {
            String courseCode = args.getString("courseCode", "");
            String courseName = args.getString("courseName", "");
            String className = args.getString("className", "");
            float average = args.getFloat("average", 0);

            binding.courseTitle.setText(courseCode + " - " + courseName);
            binding.className.setText("Class name: " + className);
            binding.averageGrade.setText("Average: " + average);
        }
    }

    private void setupGradeTable() {
        TableLayout table = binding.gradeTable;

        // Add grade rows
        addGradeRow(table, "Participation", "Participation", "10%", "10");
        addTotalRow(table, "Total", "10%", "10");

        addGradeRow(table, "Assignment", "Assignment", "30%", "9");
        addTotalRow(table, "Total", "30%", "9");

        addGradeRow(table, "Progress Test", "Progress Test", "30%", "9");
        addTotalRow(table, "Total", "30%", "9");

        addGradeRow(table, "Final Exam", "Final Exam", "30%", "9");
        addTotalRow(table, "Total", "30%", "9");
    }

    private void addGradeRow(TableLayout table, String category1, String category2, String weight, String value) {
        TableRow row = new TableRow(requireContext());
        row.setPadding(8, 8, 8, 8);

        TextView cat1 = createTableCell(category1, 2);
        TextView cat2 = createTableCell(category2, 2);
        TextView weightView = createTableCell(weight, 1);
        TextView valueView = createTableCell(value, 1);

        row.addView(cat1);
        row.addView(cat2);
        row.addView(weightView);
        row.addView(valueView);

        table.addView(row);
    }

    private void addTotalRow(TableLayout table, String total, String weight, String value) {
        TableRow row = new TableRow(requireContext());
        row.setPadding(8, 8, 8, 8);
        row.setBackgroundColor(Color.parseColor("#F5F5F5"));

        TextView totalView = createTableCell(total, 2);
        TextView emptyView = createTableCell("", 2);
        TextView weightView = createTableCell(weight, 1);
        TextView valueView = createTableCell(value, 1);

        totalView.setTextColor(Color.parseColor("#1976D2"));
        weightView.setTextColor(Color.parseColor("#1976D2"));
        valueView.setTextColor(Color.parseColor("#1976D2"));

        row.addView(totalView);
        row.addView(emptyView);
        row.addView(weightView);
        row.addView(valueView);

        table.addView(row);
    }

    private TextView createTableCell(String text, int weight) {
        TextView textView = new TextView(requireContext());
        TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weight);
        textView.setLayoutParams(params);
        textView.setText(text);
        return textView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
