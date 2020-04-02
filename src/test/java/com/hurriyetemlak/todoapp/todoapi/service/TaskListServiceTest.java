package com.hurriyetemlak.todoapp.todoapi.service;

import com.hurriyetemlak.todoapp.todoapi.converter.TaskListConverter;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListGetUserListsRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.todoapi.repository.TaskListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaskListServiceTest {

    @InjectMocks
    private TaskListService taskListService;

    @Mock
    private TaskListRepository taskListRepository;

    @Mock
    private TaskListConverter taskListConverter;

    @Test
    public void it_should_add_task_to_list() {
        //given
        TaskListAddRequest taskListAddRequest = new TaskListAddRequest();
        taskListAddRequest.setUserId("0");
        taskListAddRequest.setTaskTitle("taskTitle");
        taskListAddRequest.setTaskSubject("taskSubject");
        taskListAddRequest.setTaskType("taskType");
        taskListAddRequest.setTaskContent("taskContent");
        taskListAddRequest.setTaskPriority((byte) 0);
        taskListAddRequest.setTaskFavorite(false);

        TaskListDomain taskListDomain = new TaskListDomain();
        taskListDomain.setUserId("0");
        taskListDomain.setTaskTitle("taskTitle");
        taskListDomain.setTaskSubject("taskSubject");
        taskListDomain.setTaskContent("taskContent");
        taskListDomain.setTaskType("taskType");
        taskListDomain.setTaskPriority((byte) 0);
        taskListDomain.setTaskFavorite(false);

        given(taskListConverter.convertAddRequest(taskListAddRequest)).willReturn(taskListDomain);

        //when
        taskListService.addToList(taskListAddRequest);

        //then
        ArgumentCaptor<TaskListDomain> addTaskToListDomainArgumentCaptor = ArgumentCaptor.forClass(TaskListDomain.class);
        verify(taskListRepository).save(addTaskToListDomainArgumentCaptor.capture());
        TaskListDomain addTaskToListArgumentCaptorValue = addTaskToListDomainArgumentCaptor.getValue();
        assertThat(addTaskToListArgumentCaptorValue.getTaskTitle()).isEqualTo("taskTitle");
        assertThat(addTaskToListArgumentCaptorValue.getTaskSubject()).isEqualTo("taskSubject");
        assertThat(addTaskToListArgumentCaptorValue.getTaskContent()).isEqualTo("taskContent");
        assertThat(addTaskToListArgumentCaptorValue.getTaskType()).isEqualTo("taskType");
        assertThat(addTaskToListArgumentCaptorValue.getTaskPriority()).isEqualTo((byte) 0);
        assertThat(addTaskToListArgumentCaptorValue.getTaskFavorite()).isEqualTo(false);
        assertThat(addTaskToListArgumentCaptorValue.getUserId()).isEqualTo("0");
    }

    @Test
    public void it_should_update_task_on_list() {
        //given
        TaskListUpdateRequest taskListUpdateRequest = new TaskListUpdateRequest();
        taskListUpdateRequest.setId("0");
        taskListUpdateRequest.setUserId("0");
        taskListUpdateRequest.setTaskTitle("taskTitle");
        taskListUpdateRequest.setTaskSubject("taskSubject");
        taskListUpdateRequest.setTaskType("taskType");
        taskListUpdateRequest.setTaskContent("taskContent");
        taskListUpdateRequest.setTaskPriority((byte) 0);
        taskListUpdateRequest.setTaskFavorite(false);

        TaskListDomain taskListDomain = new TaskListDomain();
        taskListDomain.setId("0");
        taskListDomain.setUserId("0");
        taskListDomain.setTaskTitle("taskTitle");
        taskListDomain.setTaskSubject("taskSubject");
        taskListDomain.setTaskContent("taskContent");
        taskListDomain.setTaskType("taskType");
        taskListDomain.setTaskPriority((byte) 0);
        taskListDomain.setTaskFavorite(false);

        given(taskListConverter.convertUpdateRequest(taskListUpdateRequest)).willReturn(taskListDomain);

        //when
        taskListService.updateToList(taskListUpdateRequest);

        //then
        ArgumentCaptor<TaskListDomain> TaskListUpdateDomainArgumentCaptor = ArgumentCaptor.forClass(TaskListDomain.class);
        verify(taskListRepository).update(TaskListUpdateDomainArgumentCaptor.capture());
        TaskListDomain TaskListUpdateArgumentCaptorValue = TaskListUpdateDomainArgumentCaptor.getValue();
        assertThat(TaskListUpdateArgumentCaptorValue.getId()).isEqualTo("0");
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskTitle()).isEqualTo("taskTitle");
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskSubject()).isEqualTo("taskSubject");
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskContent()).isEqualTo("taskContent");
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskType()).isEqualTo("taskType");
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskPriority()).isEqualTo((byte) 0);
        assertThat(TaskListUpdateArgumentCaptorValue.getTaskFavorite()).isEqualTo(false);
        assertThat(TaskListUpdateArgumentCaptorValue.getUserId()).isEqualTo("0");
    }

    @Test
    public void it_should_delete_from_list() {
        //given
        TaskListDeleteItemRequest taskListDeleteItemRequest = new TaskListDeleteItemRequest();
        taskListDeleteItemRequest.setId("0");

        TaskListDomain taskListDomain = new TaskListDomain();
        taskListDomain.setId("0");

        given(taskListConverter.convertDeleteRequest(taskListDeleteItemRequest)).willReturn(taskListDomain);

        //when
        taskListService.deleteFromList(taskListDeleteItemRequest);

        //then
        ArgumentCaptor<TaskListDomain> TaskListDeleteDomainArgumentCaptor = ArgumentCaptor.forClass(TaskListDomain.class);
        verify(taskListRepository).delete(TaskListDeleteDomainArgumentCaptor.capture());
        TaskListDomain TaskListUpdateArgumentCaptorValue = TaskListDeleteDomainArgumentCaptor.getValue();
        assertThat(TaskListUpdateArgumentCaptorValue.getId()).isEqualTo("0");
    }

    @Test
    public void it_should_return_task_lists_by_user() {
        //given
        TaskListGetUserListsRequest taskListGetUserListsRequest = new TaskListGetUserListsRequest();
        taskListGetUserListsRequest.setUserId("0");

        TaskListDomain model1 = new TaskListDomain();
        TaskListDomain model2 = new TaskListDomain();
        model1.setId("1");
        model1.setTaskTitle("firstTitle");
        model1.setTaskFavorite(false);
        model2.setId("2");
        model2.setTaskTitle("secondTitle");
        model2.setTaskFavorite(false);
        List<TaskListDomain> taskListUserListsDomain = Arrays.asList(model1, model2);

        TaskListGetUserListsResponse model11 = new TaskListGetUserListsResponse();
        TaskListGetUserListsResponse model12 = new TaskListGetUserListsResponse();
        model11.setTaskId("1");
        model11.setTaskTitle("firstTitle");
        model11.setTaskFavorite(false);
        model12.setTaskId("2");
        model12.setTaskTitle("secondTitle");
        model12.setTaskFavorite(false);
        List<TaskListGetUserListsResponse> taskListGetUserListsResponseList = Arrays.asList(model11, model12);


        given(taskListRepository.getUserTaskLists("0")).willReturn(taskListUserListsDomain);

        given(taskListConverter.convertUserListToModelList(taskListUserListsDomain)).willReturn(taskListGetUserListsResponseList);


        //when
        List<TaskListGetUserListsResponse> taskListGetListsResponseListUser = taskListService.getTaskLists("0");

        //then
        assertThat(taskListGetListsResponseListUser.get(0).getTaskId()).isEqualTo("1");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskTitle()).isEqualTo("firstTitle");
        assertThat(taskListGetListsResponseListUser.get(0).getTaskFavorite()).isEqualTo(false);

        assertThat(taskListGetListsResponseListUser.get(1).getTaskId()).isEqualTo("2");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskTitle()).isEqualTo("secondTitle");
        assertThat(taskListGetListsResponseListUser.get(1).getTaskFavorite()).isEqualTo(false);
    }

}