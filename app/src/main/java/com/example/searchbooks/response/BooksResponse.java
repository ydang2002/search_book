package com.example.searchbooks.response;

import java.util.List;

public class BooksResponse<T> {
    private String kind;
    private List<T> items;

    public BooksResponse(String kind, List<T> items) {
        this.kind = kind;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
