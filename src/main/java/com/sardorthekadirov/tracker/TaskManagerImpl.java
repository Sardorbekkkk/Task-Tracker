package com.sardorthekadirov.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerImpl implements TaskManager{

    private Map<Long, Task> tasks = new HashMap<>();


    @Override
    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public Task getTaskById(Long id) {
        Task task = tasks.get(id);
        if(task == null){
            throw new TaskNotFoundException("Задача с ID" + id + " Не найдена!!!");
        }
        return task;
    }

    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(),task);
    }

    @Override
    public void deleteTask(long id) {
        Task task = tasks.get(id);
        if (task == null){
            throw new TaskNotFoundException("Задача с ID" + id + " Не найдена!!!");
        }
        tasks.remove(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}
