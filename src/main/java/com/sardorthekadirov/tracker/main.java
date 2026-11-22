package com.sardorthekadirov.tracker;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManagerImpl();
        String numTasks = "";
        while (numTasks != "0"){
            System.out.println("1.Добавить задачу");
            System.out.println("2. Показать все");
            System.out.println("3. Найти по ID");
            System.out.println("4. Изменить статус");
            System.out.println("5. Удалить");
            System.out.println("0. Выход");
            numTasks = scanner.nextLine();
            switch (numTasks){
                case "1":
                    System.out.println("Введите название:");
                    String title = scanner.nextLine();
                    System.out.println("Введите описание:");
                    String description = scanner.nextLine();
                    System.out.println("Введите приоритет(LOW,MEDIUM,HIGH;):");
                    String priorityStr = scanner.nextLine();
                    TaskPriority priority = TaskPriority.valueOf(priorityStr.toUpperCase());
                    Long nextId = 1l;
                    Task task = new Task(nextId++,title,description,TaskStatus.NEW , priority);
                    taskManager.addTask(task);
                    System.out.println("Задача добавлена !");
                    System.out.println();
                    break;
                case "2":
                    taskManager.getAllTasks().forEach(System.out::println);
                    System.out.println();
                    break;
                case "3":
                    try {
                        System.out.println("Введите ID Задачи:");
                        String idStr = scanner.nextLine();
                        try {
                            Long id = Long.parseLong(idStr);
                            Task task1 = taskManager.getTaskById(id);
                            System.out.println(task1);
                            System.out.println();
                        }catch (NumberFormatException e) {
                            System.out.println("Ошибка: Id должен состоять из цифр!");
                            System.out.println();
                        }
                    }catch (TaskNotFoundException e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case "4":
                    try {
                        System.out.println("Ввежите id задачи:");
                        String idStr = scanner.nextLine();
                        try {


                            Long id = Long.parseLong(idStr);
                            Task task1 = taskManager.getTaskById(id);
                            System.out.println("Введите новый статус (NEW, IN_PROGRESS, DONE):");
                            String statusStr = scanner.nextLine();
                            TaskStatus status = TaskStatus.valueOf(statusStr.toUpperCase());
                            task1.setStatus(status);
                            taskManager.updateTask(task1);
                            System.out.println("Статус успешно изменен!");
                            System.out.println();
                        }catch (NumberFormatException  e) {
                            System.out.println("Ошибка: Id должен состоять из цифр!");
                            System.out.println();
                        }
                    }catch (TaskNotFoundException e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case "5":
                    try {
                        System.out.println("ВВедите ID:");
                        String idStr = scanner.nextLine();
                        try {


                            Long id = Long.parseLong(idStr);
                            taskManager.deleteTask(id);
                            System.out.println("Задача удалена");
                            System.out.println();
                        }catch (NumberFormatException  e) {
                            System.out.println("Ошибка: Id должен состоять из цифр!");
                            System.out.println();
                        }
                    }catch (TaskNotFoundException e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }break;

                case "0":
                    System.out.println("До свидания!");
                    System.exit(0);
                default:
                    System.out.println("Ошибка! Такого пункта нет. Введите цифру от 0 до 5.");
                    System.out.println();
                    break;
            }

        }
    }
}
