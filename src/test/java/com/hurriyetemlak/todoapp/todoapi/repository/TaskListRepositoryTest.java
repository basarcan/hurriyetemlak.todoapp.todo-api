package com.hurriyetemlak.todoapp.todoapi.repository;

import com.couchbase.client.java.query.ParameterizedN1qlQuery;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaskListRepositoryTest {
    @InjectMocks
    private TaskListRepository taskListRepository;

    @Mock
    private CouchbaseTemplate couchbaseTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void it_should_save() {
        //given

        //when
        taskListRepository.save(new TaskListDomain());

        //then
        verify(couchbaseTemplate).save(any(TaskListDomain.class));
    }

    @Test
    public void it_should_delete() {
        //given

        //when
        taskListRepository.delete(new TaskListDomain());

        //then
        verify(couchbaseTemplate).remove(any(TaskListDomain.class));
    }

    @Test
    public void it_should_update() {
        //given

        //when
        taskListRepository.update(new TaskListDomain());

        //then
        verify(couchbaseTemplate).update(any(TaskListDomain.class));
    }
}