package com.hanabi.thithu.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Message {

    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private int idUserName;
    @SerializedName("message")
    private String message;
    @SerializedName("pub_date")
    private String createAt;

    public Message() {
    }

    public Message(int id, int idUserName, String message) {
        this.id = id;
        this.idUserName = idUserName;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserName() {
        return idUserName;
    }

    public void setIdUserName(int idUserName) {
        this.idUserName = idUserName;
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
