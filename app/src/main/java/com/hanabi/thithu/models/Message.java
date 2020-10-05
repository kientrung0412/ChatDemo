package com.hanabi.thithu.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message {

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("message")
    private String message;
    @SerializedName("pub_date")
    private String createAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
