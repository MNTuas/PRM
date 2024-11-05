package com.example.fap.ui.notification;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationViewModel extends ViewModel {
    private final MutableLiveData<List<Notification>> notifications = new MutableLiveData<>();
    private final MutableLiveData<List<Notification>> searchResults = new MutableLiveData<>();

    public NotificationViewModel() {
        // Initialize with some dummy data
        List<Notification> dummyData = new ArrayList<>();
        dummyData.add(new Notification("[Khóa thí] Kết quả môn học kì FA24", "7/10/2024", "Description 1"));
        dummyData.add(new Notification("THÔNG BÁO LỊCH ĐÀO TẠO NĂM HỌC 2025 CỦA KHỐI ĐẠI HỌC", "7/10/2024", "Phòng TC&QL Đào tạo thông báo đến sinh viên lịch đào tạo năm học 2025\n\nBan hành kèm theo Quyết định số 1097/QĐ-ĐHFPT ngày 02 tháng 10 năm 2024 của Hiệu trưởng Trường Đại học FPT."));
        notifications.setValue(dummyData);
        searchResults.setValue(dummyData);
    }

    public LiveData<List<Notification>> getSearchResults() {
        return searchResults;
    }

    public void searchNotifications(String query) {
        if (query.isEmpty()) {
            searchResults.setValue(notifications.getValue());
        } else {
            List<Notification> filteredList = notifications.getValue().stream()
                    .filter(notification -> notification.getTitle().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());
            searchResults.setValue(filteredList);
        }
    }
}