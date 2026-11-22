package com.sardorthekadirov.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sardorthekadirov.tracker.TaskStatus.DONE;

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



    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {

        return new ArrayList<>(tasks.values()).stream()
                .filter(task1 -> task1.getStatus() == status)
                .collect(Collectors.toList());


    }

    @Override
    public List<Task> getTasksSortedByPriority() {
        return tasks.values().stream()
                .sorted((t1 , t2 )-> Integer.compare(t2.getPriority().ordinal(),t1.getPriority().ordinal()))
                .collect(Collectors.toList());

    }

    @Override
    public Long countTaskWithPriority(TaskPriority priority) {
        return tasks.values().stream()
                .filter(task1 -> task1.getPriority() == priority)
                .count();
    }

    @Override
    public List<String> getTitlesForReport() {
        return tasks.values().stream()
                .filter(task -> task.getStatus() == DONE)
                .map(Task::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }
}
