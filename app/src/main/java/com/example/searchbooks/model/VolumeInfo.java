package com.example.searchbooks.model;

import java.io.Serializable;

public class VolumeInfo implements Serializable {
    private String title;

    public VolumeInfo() {
    }

    public VolumeInfo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
