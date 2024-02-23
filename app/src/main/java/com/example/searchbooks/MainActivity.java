package com.example.searchbooks;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.searchbooks.adapter.BooksAdapter;
import com.example.searchbooks.api.ApiServices;
import com.example.searchbooks.api.BookApiClient;
import com.example.searchbooks.model.Items;
import com.example.searchbooks.response.BooksResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private BooksResponse booksResponse;
    private Button btnSearchBooks;
    private EditText edtInputBook;
    private RecyclerView recyclerView;
    private List<Items> mListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearchBooks = findViewById(R.id.searchButton);
        edtInputBook = findViewById(R.id.bookInput);
        recyclerView = findViewById(R.id.recyclerview_item_books);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        mListItems = new ArrayList<>();

        btnSearchBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = edtInputBook.getText().toString();
                searchBooks(query);
            }
        });
    }

    private void searchBooks(String query) {
        ApiServices bookApiService = BookApiClient.getService();

        Call<BooksResponse<Items>> call = bookApiService.searchBooks(query, 10, "books");

        call.enqueue(new Callback<BooksResponse<Items>>() {

            @Override
            public void onResponse(Call<BooksResponse<Items>> call, Response<BooksResponse<Items>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "getData successfully", Toast.LENGTH_SHORT).show();
                    booksResponse = response.body();
                    mListItems = booksResponse.getItems();
                    BooksAdapter booksAdapter = new BooksAdapter(mListItems);
                    recyclerView.setAdapter(booksAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "get data not correct", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BooksResponse<Items>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}