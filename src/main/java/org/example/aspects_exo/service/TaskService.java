package org.example.aspects_exo.service;

import org.example.aspects_exo.annotation.LogAnnotation;
import org.example.aspects_exo.annotation.PerformanceAnnotation;
import org.example.aspects_exo.model.Task;
import org.example.aspects_exo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @LogAnnotation
    @PerformanceAnnotation
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @LogAnnotation
    @PerformanceAnnotation
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @LogAnnotation
    @PerformanceAnnotation
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @LogAnnotation
    @PerformanceAnnotation
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found with id " + id);
        }
    }

    @LogAnnotation
    @PerformanceAnnotation
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}