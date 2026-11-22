package com.sardorthekadirov.tracker;

import java.util.Objects;

public class Task extends BaseEntity{

    private String title;
    private String description;
    private TaskStatus status;
    private  TaskPriority priority;

    public Task(Long id,String title,String description,TaskStatus status,TaskPriority priority) {
        super(id);
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }


    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getId(), task.getId()) && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),title);
    }

    @Override
    public String toString() {
        return new StringBuilder( "id=").append(getId())
                .append(", title='").append(title).append('\'')
                .append(", status=").append(status)
                .append(", priority=").append(priority)
                .append(", description='").append(description).append('\'')
                .append(", createAT=").append(getCreatedAt())
                .append('}')
                .toString();
    }
}
