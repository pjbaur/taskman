package me.paulbaur.taskman.repository;

import me.paulbaur.taskman.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);

    Task findById(long id);

    boolean deleteById(long id);
}
