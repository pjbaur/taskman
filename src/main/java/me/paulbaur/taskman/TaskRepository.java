package me.paulbaur.taskman;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByStatus(String status);

    Task findById(long id);
}
