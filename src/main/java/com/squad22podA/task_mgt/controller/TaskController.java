package com.squad22podA.task_mgt.controller;


import com.squad22podA.task_mgt.entity.enums.Status;
import com.squad22podA.task_mgt.entity.model.Task;
import com.squad22podA.task_mgt.payload.request.TaskRequest;
import com.squad22podA.task_mgt.payload.response.TaskResponseDto;
import com.squad22podA.task_mgt.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/new-task")
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return ResponseEntity.ok(taskService.createTask(email, taskRequest));

    }

    // edit the task
    @PutMapping("/edit-task/{id}")
    public ResponseEntity<TaskResponseDto> editTask(@Valid @RequestBody TaskRequest taskRequest, @PathVariable Long id) {

        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        return ResponseEntity.ok(taskService.editTask(email, id, taskRequest));

    }


    // view all task by status
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return taskService.getTasksByStatus(status);
    }

    //task status of a given user
    @GetMapping("/status/{status}/user/{userId}")
    public ResponseEntity<?> getTasksByStatusAndUserId(@PathVariable Status status, @PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByStatusAndUserId(status, userId);
        if (tasks.isEmpty()) {
            String message = String.format("No %s tasks available now. Check later.", status.name().toLowerCase());
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.ok(tasks);
    }

    // get all task for a single user
    @GetMapping("/get-all-task")
    public ResponseEntity<List<TaskResponseDto>> getAllTask() {
        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return ResponseEntity.ok(taskService.getAllTask(email));
    }

    // get task by task-id
    @GetMapping("/get-task/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Long id) {

        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return ResponseEntity.ok(taskService.getTask(email, id));

    }

    // get by completed task
    @GetMapping("/completed-task")
    public ResponseEntity<List<TaskResponseDto>> getCompletedTask() {
        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return ResponseEntity.ok(taskService.getCompletedTask(email));
    }

    // delete a task

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<TaskResponseDto> deleteTask(@PathVariable Long id) {

        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        return ResponseEntity.ok(taskService.deleteTask(email, id));


    }


}
