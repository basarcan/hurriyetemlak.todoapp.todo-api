package com.hurriyetemlak.todoapp.todoapi.converter;

import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TaskListConverterTest {

    @InjectMocks
    private TaskListConverter taskListConverter;

    @Test
    public void it_should_convert_add_to_domain() {
        //given
        TaskListAddRequest taskListAddRequest = new TaskListAddRequest();
        taskListAddRequest.setUserId("0");
        taskListAddRequest.setTaskTitle("taskTitle");
        taskListAddRequest.setTaskSubject("taskSubject");
        taskListAddRequest.setTaskContent("taskContent");
        taskListAddRequest.setTaskType("taskType");
        taskListAddRequest.setTaskPriority((byte) 0);
        taskListAddRequest.setTaskFavorite(false);

        //when
        TaskListDomain taskListDomain = taskListConverter.convertAddRequest(taskListAddRequest);

        //then
        assertThat(taskListDomain.getUserId()).isEqualTo("0");
        assertThat(taskListDomain.getTaskTitle()).isEqualTo("taskTitle");
        assertThat(taskListDomain.getTaskSubject()).isEqualTo("taskSubject");
        assertThat(taskListDomain.getTaskContent()).isEqualTo("taskContent");
        assertThat(taskListDomain.getTaskType()).isEqualTo("taskType");
        assertThat(taskListDomain.getTaskPriority()).isEqualTo((byte) 0);
        assertThat(taskListDomain.getTaskFavorite()).isEqualTo(false);
    }

    @Test
    public void it_should_convert_update_request_to_domain()
    {
        //given
        TaskListUpdateRequest taskListUpdateRequest = new TaskListUpdateRequest();
        taskListUpdateRequest.setId("0");
        taskListUpdateRequest.setUserId("0");
        taskListUpdateRequest.setTaskTitle("taskTitle");
        taskListUpdateRequest.setTaskSubject("taskSubject");
        taskListUpdateRequest.setTaskContent("taskContent");
        taskListUpdateRequest.setTaskType("taskType");
        taskListUpdateRequest.setTaskPriority((byte) 0);
        taskListUpdateRequest.setTaskFavorite(false);

        //when
        TaskListDomain taskListDomain = taskListConverter.convertUpdateRequest(taskListUpdateRequest);

        //then
        assertThat(taskListDomain.getId()).isEqualTo("0");
        assertThat(taskListDomain.getUserId()).isEqualTo("0");
        assertThat(taskListDomain.getTaskTitle()).isEqualTo("taskTitle");
        assertThat(taskListDomain.getTaskSubject()).isEqualTo("taskSubject");
        assertThat(taskListDomain.getTaskContent()).isEqualTo("taskContent");
        assertThat(taskListDomain.getTaskType()).isEqualTo("taskType");
        assertThat(taskListDomain.getTaskPriority()).isEqualTo((byte) 0);
        assertThat(taskListDomain.getTaskFavorite()).isEqualTo(false);
    }

    @Test
    public void it_should_convert_delete_item_request_to_domain()
    {
        //given
        TaskListDeleteItemRequest taskListDeleteItemRequest = new TaskListDeleteItemRequest();
        taskListDeleteItemRequest.setId("0");

        //when
        TaskListDomain taskListDomain = taskListConverter.convertDeleteRequest(taskListDeleteItemRequest);

        //then
        assertThat(taskListDomain.getId()).isEqualTo("0");
    }

    @Test
    public void it_should_convert_user_list_to_model_list() {
        //given
        TaskListDomain taskListDomain1 = new TaskListDomain();
        taskListDomain1.setId("0");
        taskListDomain1.setTaskTitle("title1");
        taskListDomain1.setTaskFavorite(false);
        TaskListDomain taskListDomain2 = new TaskListDomain();
        taskListDomain2.setId("1");
        taskListDomain2.setTaskTitle("title2");
        taskListDomain2.setTaskFavorite(true);
        List<TaskListDomain> taskListDomains = Arrays.asList(taskListDomain1, taskListDomain2);
        //when
        List<TaskListGetUserListsResponse> taskListGetUserListsResponseList = taskListConverter.convertUserListToModelList(taskListDomains);

        //then
        assertThat(taskListGetUserListsResponseList.get(0).getTaskFavorite()).isFalse();
        assertThat(taskListGetUserListsResponseList.get(0).getTaskTitle()).isEqualTo("title1");
        assertThat(taskListGetUserListsResponseList.get(0).getTaskId()).isEqualTo("0");
        assertThat(taskListGetUserListsResponseList.get(1).getTaskId()).isEqualTo("1");
        assertThat(taskListGetUserListsResponseList.get(1).getTaskTitle()).isEqualTo("title2");
        assertThat(taskListGetUserListsResponseList.get(1).getTaskFavorite()).isTrue();
    }

}