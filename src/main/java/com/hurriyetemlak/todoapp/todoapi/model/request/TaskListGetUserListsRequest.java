package com.hurriyetemlak.todoapp.todoapi.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListGetUserListsRequest {
    private Long userId;
}
