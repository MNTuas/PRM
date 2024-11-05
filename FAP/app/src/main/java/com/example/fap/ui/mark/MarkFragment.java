package com.example.fap.ui.mark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fap.R;
import com.example.fap.databinding.FragmentMarkBinding;

import java.util.ArrayList;
import java.util.List;

public class MarkFragment extends Fragment implements MarkAdapter.OnMarkClickListener {
    private FragmentMarkBinding binding;
    private MarkAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMarkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupRecyclerView();
        loadSampleData();
    }

    private void setupRecyclerView() {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new MarkAdapter(new ArrayList<>(), this);
        binding.recyclerView.setAdapter(adapter);
    }

    private void loadSampleData() {
        List<Mark> marks = new ArrayList<>();
        marks.add(new Mark("EXE201", "Experiential Entrepreneurship 2", "SE1714", 9.2, true));
        marks.add(new Mark("PRM392", "Mobile Programming", "SE1714", 9.0, true));
        adapter.setMarks(marks);
    }

    @Override
    public void onMarkClick(Mark mark) {
        Bundle bundle = new Bundle();
        bundle.putString("courseCode", mark.getCourseCode());
        bundle.putString("courseName", mark.getCourseName());
        bundle.putString("className", mark.getClassName());
        bundle.putFloat("average", (float) mark.getAverage());

        NavController navController = Navigation.findNavController(requireView());
        navController.navigate(R.id.action_markFragment_to_markDetailFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}