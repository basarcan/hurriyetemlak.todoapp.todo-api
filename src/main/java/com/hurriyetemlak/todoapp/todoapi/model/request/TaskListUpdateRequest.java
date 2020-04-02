package com.hurriyetemlak.todoapp.todoapi.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskListUpdateRequest {
    private Long id;
    private Long userId;
    private String taskTitle;
    private String taskSubject;
    private String taskContent;
    private byte taskPriority;
    private String taskType;
    private Boolean taskFavorite;
}
