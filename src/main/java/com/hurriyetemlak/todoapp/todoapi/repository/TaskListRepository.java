package com.hurriyetemlak.todoapp.todoapi.repository;

import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.ParameterizedN1qlQuery;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hurriyetemlak.todoapp.todoapi.domain.TaskListDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Slf4j
public class TaskListRepository {
    private final CouchbaseTemplate couchbaseTemplate;
    private final ObjectMapper objectMapper;

    public TaskListRepository(CouchbaseTemplate couchbaseTemplate, ObjectMapper objectMapper) {
        this.couchbaseTemplate = couchbaseTemplate;
        this.objectMapper = objectMapper;
    }

    public void save(TaskListDomain taskListDomain) {
        couchbaseTemplate.save(taskListDomain);
    }

    public void delete(TaskListDomain taskListDomain) {
        couchbaseTemplate.remove(taskListDomain);
    }

    public void update(TaskListDomain taskListDomain) {
        couchbaseTemplate.update(taskListDomain);
    }

    public List<TaskListDomain> getUserTaskLists(String userId) {
        String query = "SELECT meta(f).id, f.* FROM `todo-bucket` AS f WHERE f.userId= $userId";
        ParameterizedN1qlQuery parameterizedN1qlQuery = N1qlQuery.parameterized(query, JsonObject.create().put("userId", userId));
        Stream<TaskListDomain> userStream = couchbaseTemplate.queryN1QL(parameterizedN1qlQuery).allRows().stream().map(this::map);
        return userStream.collect(Collectors.toList());
    }

    private TaskListDomain map(N1qlQueryRow n1qlQueryRow) {
        try {
            return objectMapper.readValue(n1qlQueryRow.byteValue(), TaskListDomain.class);
        } catch (Exception ex) {
            log.error("Could not parsed");
        }
        return null;
    }

}
