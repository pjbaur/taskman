package me.paulbaur.taskman.service;

import me.paulbaur.taskman.model.Task;

import java.util.List;
import java.util.Optional;

/*
The TaskService layer acts as an intermediary between your controllers and repositories, encapsulating business logic
and making your code modular and testable.

Responsibilities the TaskService should have:
<ul>
<li>
Business Logic: Implements the core functionality, processing data before it reaches the controller or after it comes
from the repository.
</li>
<li>
Data Validation: Ensures that incoming data meets the necessary criteria before it's processed or stored.
</li>
<li>
Abstraction: Hides the complexity of data access from the controllers, promoting separation of concerns.
</li>
<li>
Error Handling: Manages exceptions and provides meaningful feedback to the controller layer.
</li>
</ul>
 */
public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    boolean deleteTask(Long id);
}
