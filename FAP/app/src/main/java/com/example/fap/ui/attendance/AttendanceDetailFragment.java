package com.example.fap.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.fap.databinding.FragmentAttendanceDetailBinding;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDetailFragment extends Fragment {
    private FragmentAttendanceDetailBinding binding;
    private AttendanceRecordAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAttendanceDetailBinding.inflate(inflater, container, false);

        setupViews();
        loadAttendanceData();

        return binding.getRoot();
    }

    private void setupViews() {
        Bundle args = getArguments();
        if (args != null) {
            String courseTitle = args.getString("courseTitle", "");
            String className = args.getString("className", "");
            String startDate = args.getString("startDate", "");
            String endDate = args.getString("endDate", "");
            int percentage = args.getInt("percentage", 0);

            binding.textCourseTitle.setText(courseTitle);
            binding.textClassName.setText("Class name: " + className);

            int totalClasses = 15; // Assuming 15 total classes
            int attendedClasses = (int) Math.round(totalClasses * (percentage / 100.0));
            binding.textAttended.setText("Attended: " + attendedClasses + "/" + totalClasses);

            binding.textPresent.setText(String.valueOf(attendedClasses));
            binding.textAbsent.setText(String.valueOf(totalClasses - attendedClasses));
            binding.textFuture.setText("10");
        }

        adapter = new AttendanceRecordAdapter();
        binding.recyclerAttendanceRecords.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerAttendanceRecords.setAdapter(adapter);
    }

    private void loadAttendanceData() {
        Bundle args = getArguments();
        if (args != null) {
            String lecturer = "huynlt2"; // Default lecturer
            List<AttendanceRecord> records = new ArrayList<>();

            int totalClasses = 15;
            int attendedClasses = (int) Math.round(totalClasses * (args.getInt("percentage", 0) / 100.0));

            for (int i = 0; i < attendedClasses; i++) {
                records.add(new AttendanceRecord(
                        "22/09/2024 - Slot 4",
                        "Lecturer: " + lecturer,
                        true
                ));
            }
            adapter.submitList(records);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}