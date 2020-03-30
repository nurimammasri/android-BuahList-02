package com.dicoding.buahlist.Model;

public class Fruit {
    private String namaBuah;
    private String detail;
    private int photo;
    private String moreDetailBuah;
    private String rating;

    public String getNamaBuah() {
        return namaBuah;
    }

    void setNamaBuah(String namaBuah) {
        this.namaBuah = namaBuah;
    }

    public String getDetail() {
        return detail;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getMoreDetailBuah() {
        return moreDetailBuah;
    }

    void setMoreDetail(String moreDetailBuah) {
        this.moreDetailBuah = moreDetailBuah;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
