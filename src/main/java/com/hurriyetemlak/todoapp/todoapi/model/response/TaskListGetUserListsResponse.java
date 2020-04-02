package com.hurriyetemlak.todoapp.todoapi.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListGetUserListsResponse {
    private Long taskId;
    private String taskTitle;
    private Boolean taskFavorite;
}
