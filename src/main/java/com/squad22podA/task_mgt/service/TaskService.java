package com.squad22podA.task_mgt.service;

import com.squad22podA.task_mgt.entity.model.Task;

public interface TaskService {

    Task createTask(String email, Task task);
}
