package com.geektech.homeworks.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.homeworks.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    public BookAdapter(List<BooksModels> list) {
        this.list = list;
    }

    private List<BooksModels>list;


    public void setBookClickListener(BookClickListener bookClickListener) {
        this.bookClickListener = bookClickListener;
    }

    private BookClickListener bookClickListener;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listholder,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
     private TextView mtextview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bookClickListener.onItemClick(getAdapterPosition());
                }
            });

            mtextview = itemView.findViewById(R.id.textview);
        }

        public void bind(BooksModels models) {
            mtextview.setText(models.getBookName());

        }
    }
}


