package com.hurriyetemlak.todoapp.todoapi.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListUserListsDomain {
    private Long taskId;
    private String taskTitle;
    private Boolean taskFavorite;
}
