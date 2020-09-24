package com.geektech.homeworks.model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.homeworks.R;

import java.util.ArrayList;
import java.util.List;

public class BookroomFragment extends Fragment {
    private BooksModels models;
    private ArrayList<BooksModels> booksList = new ArrayList<>();
    private TextView bookName, bookDesk;

    public BookroomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("ololo","Fragment onCreateView");
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = (int) bundle.get("position");
            models = BookRepository.getbook(position);
            booksList.add(models);
        }
        return inflater.inflate(R.layout.fragment_bookroom, container, false);
    }
        @Override
        public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
            Log.e("ololo","Fragment onViewCreated");
            super.onViewCreated(view, savedInstanceState);
            bookName = view.findViewById(R.id.bookname);
            bookDesk = view.findViewById(R.id.bookdesc);
            if (models != null) {
                bookName.setText(models.getBookName());
                bookDesk.setText(models.getBookDesc());
            }
        }

}