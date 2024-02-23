package com.example.searchbooks.model;

import java.io.Serializable;
import java.util.List;

public class Books implements Serializable {
    private String kind;
    private List<Items> items;

    public Books() {

    }

    public Books(String kind, List<Items> items) {
        this.kind = kind;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
