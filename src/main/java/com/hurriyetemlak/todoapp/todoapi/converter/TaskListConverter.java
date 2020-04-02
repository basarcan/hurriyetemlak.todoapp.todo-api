package com.hurriyetemlak.todoapp.todoapi.converter;

import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListGetUserListsRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskListConverter {

    public TaskListDomain convertAddRequest(TaskListAddRequest taskListAddRequest) {
        TaskListDomain taskListDomain = new TaskListDomain();

        taskListDomain.setUserId(taskListAddRequest.getUserId());
        taskListDomain.setTaskTitle(taskListAddRequest.getTaskTitle());
        taskListDomain.setTaskSubject(taskListAddRequest.getTaskSubject());
        taskListDomain.setTaskContent(taskListAddRequest.getTaskContent());
        taskListDomain.setTaskType(taskListAddRequest.getTaskType());
        taskListDomain.setTaskPriority(taskListAddRequest.getTaskPriority());
        taskListDomain.setTaskFavorite(taskListAddRequest.getTaskFavorite());
        taskListDomain.setCreatedDate(new Date());
        return taskListDomain;
    }

    public TaskListDomain convertUpdateRequest(TaskListUpdateRequest taskListUpdateRequest) {
        TaskListDomain taskListDomain = new TaskListDomain();
        taskListDomain.setId(taskListUpdateRequest.getId());
        taskListDomain.setUserId(taskListUpdateRequest.getUserId());
        taskListDomain.setTaskTitle(taskListUpdateRequest.getTaskTitle());
        taskListDomain.setTaskSubject(taskListUpdateRequest.getTaskSubject());
        taskListDomain.setTaskContent(taskListUpdateRequest.getTaskContent());
        taskListDomain.setTaskType(taskListUpdateRequest.getTaskType());
        taskListDomain.setTaskPriority(taskListUpdateRequest.getTaskPriority());
        taskListDomain.setTaskFavorite(taskListUpdateRequest.getTaskFavorite());
        taskListDomain.setUpdatedDate(new Date());
        return taskListDomain;
    }

    public TaskListDomain convertDeleteRequest(TaskListDeleteItemRequest taskListDeleteItemRequest)
    {
        TaskListDomain taskListDomain = new TaskListDomain();
        taskListDomain.setId(taskListDeleteItemRequest.getId());
        return taskListDomain;
    }

    public List<TaskListGetUserListsResponse> convertUserListToModelList(List<TaskListDomain> taskListUserListsDomain)
    {
        return taskListUserListsDomain.stream().map(x -> {
            TaskListGetUserListsResponse taskListGetUserListsResponse = new TaskListGetUserListsResponse();
            taskListGetUserListsResponse.setTaskFavorite(x.getTaskFavorite());
            taskListGetUserListsResponse.setTaskId(x.getId());
            taskListGetUserListsResponse.setTaskTitle(x.getTaskTitle());
            return taskListGetUserListsResponse;
        }).collect(Collectors.toList());
    }
}
