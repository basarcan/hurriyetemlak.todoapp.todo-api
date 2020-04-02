package com.hurriyetemlak.todoapp.todoapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskListDomain {
    private Long id;
    private Long userId;
    private Date createdDate;
    private Date updatedDate;
    public String taskTitle;
    public String taskSubject;
    public String taskContent;
    public byte taskPriority;
    public String taskType;
    public Boolean taskFavorite;
}
