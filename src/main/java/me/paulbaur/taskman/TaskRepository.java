package me.paulbaur.taskman;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByTitle(String title);

    Task findById(long id);
}
