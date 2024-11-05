package com.example.fap.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.fap.databinding.FragmentNotificationDetailBinding;

public class NotificationDetailFragment extends Fragment {
    private FragmentNotificationDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationDetailBinding.inflate(inflater, container, false);

        if (getArguments() != null) {
            binding.titleText.setText(getArguments().getString("title"));
            binding.dateText.setText("Date: " + getArguments().getString("date"));
            binding.contentText.setText(getArguments().getString("content"));
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}