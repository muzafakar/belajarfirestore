package com.example.zulfakar.firesttore.model;

/**
 * Created by zulfakar on 26/07/18.
 * For educational purposes
 */
public class Payment {
    private String id;
    private int count;
    private int month;

    public Payment() {
    }

    public Payment(String id, int count, int month) {
        this.id = id;
        this.count = count;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public int getMonth() {
        return month;
    }
}
