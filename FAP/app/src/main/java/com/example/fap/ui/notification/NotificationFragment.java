package com.example.fap.ui.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.fap.R;
import com.example.fap.databinding.FragmentNotificationBinding;
import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {
    private FragmentNotificationBinding binding;
    private NotificationAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(inflater, container, false);
        setupRecyclerView();
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        adapter = new NotificationAdapter(notification -> {
            Bundle args = new Bundle();
            args.putString("title", notification.getTitle());
            args.putString("date", notification.getDate());
            args.putString("content", notification.getContent());
            Navigation.findNavController(binding.getRoot())
                    .navigate(R.id.action_notification_to_detail, args);
        });
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);

        // Add some dummy data
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification(
                "[Khóa thí] Kết quả môn học kì FA24",
                "7/10/2024",
                "Chi tiết kết quả môn học..."
        ));
        notifications.add(new Notification(
                "THÔNG BÁO LỊCH ĐÀO TẠO NĂM HỌC 2025 CỦA KHỐI ĐẠI HỌC",
                "7/10/2024",
                "Phòng TC&QL Đào tạo thông báo đến sinh viên lịch đào tạo năm học 2025\n\nBan hành kèm theo Quyết định số 1097/QĐ-ĐHFPT ngày 02 tháng 10 năm 2024 của Hiệu trưởng Trường Đại học FPT."
        ));
        adapter.submitList(notifications);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}