package com.geektech.homeworks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.geektech.homeworks.model.BookAdapter;
import com.geektech.homeworks.model.BookClickListener;
import com.geektech.homeworks.model.BookRepository;
import com.geektech.homeworks.model.BookroomFragment;
import com.geektech.homeworks.model.BooksModels;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    BookAdapter adapter;
    private List<BooksModels> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        list = BookRepository.getBooklist();
        adapter = new BookAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setBookClickListener(new BookClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("ololo","mainActyvityOnClick");
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                BookroomFragment fragment = new BookroomFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fr_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}