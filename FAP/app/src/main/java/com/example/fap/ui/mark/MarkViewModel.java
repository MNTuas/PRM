package com.example.fap.ui.mark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MarkViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MarkViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Mark fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}