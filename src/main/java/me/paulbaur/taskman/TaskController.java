package me.paulbaur.taskman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = (List<Task>) taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

     @PostMapping("/tasks")
     public ResponseEntity<Task> createTask(@RequestBody Task task) {
         Task createdTask = taskService.createTask(task);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
     }

     @PutMapping("/{id}")
     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
         Task updatedTask = taskService.updateTask(id, task);
         return ResponseEntity.ok(updatedTask);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
         taskService.deleteTask(id);
         return ResponseEntity.noContent().build();
     }

     @GetMapping("/{id}")
     public ResponseEntity<Task> getTask(@PathVariable Long id) {
         Task task = taskService.getTask(id);
         return ResponseEntity.ok(task);
     }

    // ...
    // @GetMapping("/search")
    // public ResponseEntity<List<Task>> searchTasks(@RequestParam String query) {
    //     List<Task> tasks = taskService.searchTasks(query);
    //     return ResponseEntity.ok(tasks);
    // }
    // ...
    // @GetMapping("/filter")
    // public ResponseEntity<List<Task>> filterTasks(@RequestParam String status) {
    //     List<Task> tasks = taskService.filterTasks(status);
    //     return ResponseEntity.ok(tasks);
    // }
    // ...
    // @GetMapping("/sort")
    // public ResponseEntity<List<Task>> sortTasks(@RequestParam String by) {
    //     List<Task> tasks = taskService.sortTasks(by);
    //     return ResponseEntity.ok(tasks);
    // }
    // ...
    // @GetMapping("/paginate")
    // public ResponseEntity<List<Task>> paginateTasks(@RequestParam int page, @RequestParam int size) {
    //     List<Task> tasks = taskService.paginateTasks(page, size);
    //     return ResponseEntity.ok(tasks);
    // }
    // ...
    // @GetMapping("/count")
    // public ResponseEntity<Long> countTasks() {
    //     Long count = taskService.countTasks();
    //     return ResponseEntity.ok(count);
    // }
    // ...
}
