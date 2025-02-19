package me.paulbaur.taskman.service;

import me.paulbaur.taskman.exception.ResourceNotFoundException;
import me.paulbaur.taskman.model.Task;
import me.paulbaur.taskman.model.Status;
import me.paulbaur.taskman.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        // Set the task status to OPEN by default
        task.setStatus(Status.OPEN);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());
            return taskRepository.save(updatedTask);
        } else {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
    }

    @Override
    public boolean deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        } else {
            taskRepository.deleteById(id);
            return true;
        }
    }
}
