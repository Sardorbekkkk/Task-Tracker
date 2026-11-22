package com.sardorthekadirov.tracker;

import java.util.List;

public interface TaskManager {

    void addTask(Task task);
    Task getTaskById(Long id);
    void updateTask(Task task);
    void deleteTask(long id);
    List<Task> getAllTasks();
}
