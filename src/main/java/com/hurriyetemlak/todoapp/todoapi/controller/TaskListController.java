package com.hurriyetemlak.todoapp.todoapi.controller;

import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListGetUserListsRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.todoapi.service.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addToList(@RequestBody TaskListAddRequest taskListAddRequest) {
        taskListService.addToList(taskListAddRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateToList(@RequestBody TaskListUpdateRequest taskListUpdateRequest) {
        taskListService.updateToList(taskListUpdateRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteFromList(@RequestBody TaskListDeleteItemRequest taskListDeleteItemRequest) {
        taskListService.deleteFromList(taskListDeleteItemRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskListGetUserListsResponse> getTaskLists(@RequestBody TaskListGetUserListsRequest taskListGetUserListsRequest)
    {
        return taskListService.getTaskLists(taskListGetUserListsRequest);
    }


}
