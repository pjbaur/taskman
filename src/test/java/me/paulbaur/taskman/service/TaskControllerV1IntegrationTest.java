package me.paulbaur.taskman.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.paulbaur.taskman.model.Status;
import me.paulbaur.taskman.model.Task;
import me.paulbaur.taskman.repository.TaskRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskControllerV1IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private static Long taskId;

    @Test
    @Order(1)
    public void testCreateTask() throws Exception {
        Task task = new Task(null, "Integration Task", "Integration Description", Status.IN_PROGRESS);

        String response = mockMvc.perform(post("/api/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Task"))
                .andReturn().getResponse().getContentAsString();

        Task savedTask = objectMapper.readValue(response, Task.class);
        taskId = savedTask.getId();
    }

    @Test
    @Order(2)
    public void testGetTaskById() throws Exception {
        mockMvc.perform(get("/api/v1/tasks/" + taskId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Task"));
    }

    @Test
    @Order(3)
    public void testUpdateTask() throws Exception {
        Task updatedTask = new Task(taskId, "Updated Integration Task", "Updated Description", Status.COMPLETED);

        mockMvc.perform(put("/api/v1/tasks/" + taskId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Integration Task"));
    }

    @Test
    @Order(4)
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/v1/tasks/" + taskId))
                .andExpect(status().isOk());

        Optional<Task> deletedTask = taskRepository.findById(taskId);
        assertFalse(deletedTask.isPresent());
    }
}
