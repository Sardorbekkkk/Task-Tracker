package com.sardorthekadirov.tracker.api.model;

import com.google.gson.annotations.SerializedName;

public class RemoteTask {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public RemoteTask() {
    }

    public RemoteTask(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return new StringBuilder ("{")
                .append("userId=").append(getUserId())
                .append(", id=").append(id)
                .append("title=").append(title)
                .append(", completed=").append(completed)
                .append('}')
                .toString();
    }
}
