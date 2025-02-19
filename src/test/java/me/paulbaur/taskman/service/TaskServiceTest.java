package me.paulbaur.taskman.service;

import me.paulbaur.taskman.model.Task;
import me.paulbaur.taskman.repository.TaskRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskRepository taskRepository = mock(TaskRepository.class);
    private TaskService taskService = new TaskServiceImpl(taskRepository);

    @Test
    public void testGetAllTasks() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void testCreateTask() {
        Task task = new Task("Test Task", "Description 1");

        when(taskRepository.save(task)).thenReturn(task);

        Task createdTask = taskService.createTask(task);

        assertNotNull(createdTask);
        assertEquals("Test Task", createdTask.getTitle());
        verify(taskRepository, times(1)).save(task);
    }
}
