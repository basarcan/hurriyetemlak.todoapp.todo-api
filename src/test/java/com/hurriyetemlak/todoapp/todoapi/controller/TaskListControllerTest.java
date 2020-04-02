package com.hurriyetemlak.todoapp.todoapi.controller;

import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListAddRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListDeleteItemRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListGetUserListsRequest;
import com.hurriyetemlak.todoapp.todoapi.model.request.TaskListUpdateRequest;
import com.hurriyetemlak.todoapp.todoapi.model.response.TaskListGetUserListsResponse;
import com.hurriyetemlak.todoapp.todoapi.service.TaskListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskListController.class)
public class TaskListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskListService taskListService;

    @Test
    public void it_should_add_task_to_list() throws Exception {
        //given


        //when
        ResultActions resultActions = mockMvc.perform(post("/add-to-list")
                .content("{\n" +
                        "  \"userId\": \"0\",\n" +
                        "  \"taskTitle\": \"taskTitle\",\n" +
                        "  \"taskSubject\": \"taskSubject\",\n" +
                        "  \"taskContent\": \"taskContent\",\n" +
                        "  \"priority\": 0,\n" +
                        "  \"taskType\": \"taskType\",\n" +
                        "  \"taskFavorite\": false\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON));
        //then

        resultActions.andExpect(status().isCreated());
        verify(taskListService).addToList(any(TaskListAddRequest.class));
    }

    @Test
    public void it_should_update_task_on_list() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(put("/update-to-list")
                .content("{\n" +
                        "  \"id\": \"0\",\n" +
                        "  \"userId\": \"0\",\n" +
                        "  \"taskTitle\": \"taskTitle\",\n" +
                        "  \"taskSubject\": \"taskSubject\",\n" +
                        "  \"taskContent\": \"taskContent\",\n" +
                        "  \"priority\": 0,\n" +
                        "  \"taskType\": \"taskType\",\n" +
                        "  \"taskFavorite\": false\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON));
        //then
        resultActions.andExpect(status().isOk());
        verify(taskListService).updateToList(any(TaskListUpdateRequest.class));
    }

    @Test
    public void it_should_delete_task_on_list() throws Exception
    {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(delete("/delete-from-list")
                .content("{ \"id\":\"0\"}")
                .contentType(MediaType.APPLICATION_JSON));

        //then
        resultActions.andExpect(status().isOk());
        verify(taskListService).deleteFromList(any(TaskListDeleteItemRequest.class));
    }

    @Test
    public void it_should_return_task_lists_by_user() throws Exception
    {
        //given
        TaskListGetUserListsRequest taskListGetUserListsRequest = new TaskListGetUserListsRequest();
        taskListGetUserListsRequest.setUserId("0");

        TaskListGetUserListsResponse model1 = new TaskListGetUserListsResponse();
        model1.setTaskId(1L);
        model1.setTaskTitle("firstTitle");
        model1.setTaskFavorite(false);
        TaskListGetUserListsResponse model2 = new TaskListGetUserListsResponse();
        model2.setTaskId(2L);
        model2.setTaskTitle("secondTitle");
        model2.setTaskFavorite(false);

        given(taskListService.getTaskLists(taskListGetUserListsRequest)).willReturn(Arrays.asList(model1,model2));

        //when
        ResultActions resultActions = mockMvc.perform(get("/get-user-lists")
                .content("{ \"userId\":\"0\"}")
                .contentType(MediaType.APPLICATION_JSON));
        //then
        resultActions.andExpect(status().isOk());
        verify(taskListService).getTaskLists(any(TaskListGetUserListsRequest.class));
    }
}