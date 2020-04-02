package com.hurriyetemlak.todoapp.todoapi.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.Date;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskListDomain {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = "__")
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
