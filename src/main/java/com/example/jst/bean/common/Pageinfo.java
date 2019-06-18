package com.example.jst.bean.common;

import java.util.List;

public class Pageinfo<T> {
    private int total;
    private int currentPage;
    private List<T> data;
    private int page;
    private int size;

    public Pageinfo() {
    }

    public Pageinfo(int total, int currentPage, List<T> data, int page, int size) {
        this.total = total;
        this.currentPage = currentPage;
        this.data = data;
        this.page = page;
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
