package com.hurriyetemlak.todoapp.todoapi.repository;

import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListGetUserListsDomain;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListUserListsDomain;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class TaskListRepository {

    public void save(TaskListDomain taskListDomain) {

    }

    public void delete(TaskListDomain taskListDomain) {

    }

    public void update(TaskListDomain taskListDomain) {

    }

    public List<TaskListUserListsDomain> getUserTaskLists(TaskListGetUserListsDomain taskListGetUserListsDomain) {
        TaskListUserListsDomain taskListUserListsDomain = new TaskListUserListsDomain();
        taskListUserListsDomain.setTaskFavorite(true);
        taskListUserListsDomain.setTaskTitle("title");
        taskListUserListsDomain.setTaskId(1L);
        return Collections.singletonList(taskListUserListsDomain);
    }

}
