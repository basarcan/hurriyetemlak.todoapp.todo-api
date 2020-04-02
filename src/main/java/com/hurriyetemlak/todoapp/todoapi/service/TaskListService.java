package com.hurriyetemlak.todoapp.todoapi.service;

import com.hurriyetemlak.todoapp.todoapi.converter.TaskListConverter;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.todoapi.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {
    private final TaskListConverter taskListConverter;
    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListConverter taskListConverter, TaskListRepository taskListRepository) {
        this.taskListConverter = taskListConverter;
        this.taskListRepository = taskListRepository;
    }

    public void addToList(TaskListAddRequest taskListAddRequest)
    {
        TaskListDomain taskListDomain = taskListConverter.convertAddRequest(taskListAddRequest);
        taskListRepository.save(taskListDomain);
    }

    public void updateToList(TaskListUpdateRequest taskListUpdateRequest) {
        TaskListDomain taskListDomain = taskListConverter.convertUpdateRequest(taskListUpdateRequest);
        taskListRepository.update(taskListDomain);

    }

    public void deleteFromList(TaskListDeleteItemRequest tasklistDeleteItemRequest) {
        TaskListDomain taskListDomain = taskListConverter.convertDeleteRequest(tasklistDeleteItemRequest);
        taskListRepository.delete(taskListDomain);
    }

    public List<TaskListGetUserListsResponse> getTaskLists(String userId) {
        List<TaskListDomain> taskListUserListsDomain = taskListRepository.getUserTaskLists(userId);
        return taskListConverter.convertUserListToModelList(taskListUserListsDomain);
    }
}
