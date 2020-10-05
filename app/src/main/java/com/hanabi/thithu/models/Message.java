package com.hanabi.thithu.models;

import java.util.Date;

public class Message {

    private int id;
    private int idUserName;
    private String message;
    private Date createAt;

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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
