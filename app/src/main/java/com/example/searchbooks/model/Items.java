package com.example.searchbooks.model;

import java.io.Serializable;

public class Items implements Serializable {
   private String id;
   private VolumeInfo volumeInfo;

   public Items() {
   }

   public Items(String id, VolumeInfo volumeInfo) {
      this.id = id;
      this.volumeInfo = volumeInfo;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public VolumeInfo getVolumeInfo() {
      return volumeInfo;
   }

   public void setVolumeInfo(VolumeInfo volumeInfo) {
      this.volumeInfo = volumeInfo;
   }
}
