package me.paulbaur.taskman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskmanApplication {

	private static final Logger log = LoggerFactory.getLogger(TaskmanApplication.class);

	@Autowired
	TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			// Create a few tasks
			repository.save(new Task("Task 1", "This is the first task", "OPEN", LocalDateTime.now()));
			repository.save(new Task("Task 2", "This is the second task", "IN_PROGRESS", LocalDateTime.now()));
			repository.save(new Task("Task 3", "This is the third task", "DONE", LocalDateTime.now()));
			repository.save(new Task("Task 4", "This is the fourth task", "OPEN", LocalDateTime.now()));
			repository.save(new Task("Task 5", "This is the fifth task", "IN_PROGRESS", LocalDateTime.now()));

			// fetch all tasks
			log.info("Tasks found with findAll():");
			log.info("-------------------------------");
			for (Task task : repository.findAll()) {
				log.info(task.toString());
			};
			log.info("");

			// fetch an individual task by ID
			Task task = repository.findById(1L);
			log.info("Task found with findById(1L):");
			log.info("--------------------------------");
			log.info(task.toString());
			log.info("");

			// fetch tasks by status
//			log.info("Tasks found with findByStatus('OPEN'):");
//			log.info("---------------------------------------");
//			repository.findByStatus("OPEN").forEach(openTask -> {
//				log.info(openTask.toString());
//			});

		};
	}
}
