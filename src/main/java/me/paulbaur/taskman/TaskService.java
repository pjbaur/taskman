package me.paulbaur.taskman;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
