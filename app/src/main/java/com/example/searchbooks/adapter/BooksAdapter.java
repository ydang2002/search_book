package com.example.searchbooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchbooks.R;
import com.example.searchbooks.model.Books;
import com.example.searchbooks.model.Items;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private final List<Items> mListItems;

    public BooksAdapter(List<Items> mListItems) {
        this.mListItems = mListItems;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name_books, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        Items items = mListItems.get(position);
        if (items == null) {
            return;
        }
        holder.tvNameBook.setText(items.getVolumeInfo().getTitle());
    }

    @Override
    public int getItemCount() {
        if (mListItems != null) {
            return mListItems.size();
        }
        return 0;
    }

    public static class BooksViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvNameBook;
        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameBook = itemView.findViewById(R.id.tv_name_book);
        }
    }
}
