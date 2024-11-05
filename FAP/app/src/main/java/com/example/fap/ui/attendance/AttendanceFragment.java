package com.example.fap.ui.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.fap.databinding.FragmentAttendanceBinding;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {
    private FragmentAttendanceBinding binding;
    private AttendanceAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAttendanceBinding.inflate(inflater, container, false);

        setupRecyclerView();
        setupTabs();
        loadSpring2024Data(); // Load initial data

        return binding.getRoot();
    }

    private void setupRecyclerView() {
        adapter = new AttendanceAdapter(new ArrayList<>());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    private void setupTabs() {
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    loadSpring2024Data();
                } else {
                    loadFall2024Data();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void loadSpring2024Data() {
        List<AttendanceItem> items = new ArrayList<>();
        items.add(new AttendanceItem(
                "EXE201 - Experiential Entrepreneurship 2",
                "SE1714",
                "8/9/2024",
                "04/11/2024",
                100
        ));
        items.add(new AttendanceItem(
                "SWP391 - Software Development Project",
                "SE1722",
                "8/9/2024",
                "04/11/2024",
                85
        ));
        items.add(new AttendanceItem(
                "SWR302 - Software Requirement",
                "SE1724",
                "8/9/2024",
                "04/11/2024",
                90
        ));
        items.add(new AttendanceItem(
                "SWT301 - Software Testing",
                "SE1725",
                "8/9/2024",
                "04/11/2024",
                95
        ));
        items.add(new AttendanceItem(
                "SWP391 - Software Development Project",
                "SE1722",
                "8/9/2024",
                "04/11/2024",
                85
        ));
        items.add(new AttendanceItem(
                "SWR302 - Software Requirement",
                "SE1724",
                "8/9/2024",
                "04/11/2024",
                90
        ));
        items.add(new AttendanceItem(
                "SWT301 - Software Testing",
                "SE1725",
                "8/9/2024",
                "04/11/2024",
                95
        ));
        adapter.updateData(items);
    }

    private void loadFall2024Data() {
        List<AttendanceItem> items = new ArrayList<>();
        items.add(new AttendanceItem(
                "PRN231 - Advanced Cross-Platform Application Programming",
                "SE1722",
                "9/15/2024",
                "12/20/2024",
                95
        ));
        items.add(new AttendanceItem(
                "PRM392 - Mobile Programming",
                "SE1723",
                "9/15/2024",
                "12/20/2024",
                88
        ));
        items.add(new AttendanceItem(
                "SWD392 - Software Architecture and Design",
                "SE1724",
                "9/15/2024",
                "12/20/2024",
                92
        ));
        items.add(new AttendanceItem(
                "PRJ301 - Java Web Application Development",
                "SE1725",
                "9/15/2024",
                "12/20/2024",
                87
        ));
        items.add(new AttendanceItem(
                "PRM392 - Mobile Programming",
                "SE1723",
                "9/15/2024",
                "12/20/2024",
                88
        ));
        items.add(new AttendanceItem(
                "SWD392 - Software Architecture and Design",
                "SE1724",
                "9/15/2024",
                "12/20/2024",
                92
        ));
        items.add(new AttendanceItem(
                "PRJ301 - Java Web Application Development",
                "SE1725",
                "9/15/2024",
                "12/20/2024",
                87
        ));
        adapter.updateData(items);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}