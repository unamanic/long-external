package org.flowable.example.vanitypress.controllers;

import lombok.extern.log4j.Log4j2;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PrintRequestController {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public PrintRequestController(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @PostMapping("/print")
    public String postRequest() {
        ProcessInstance asyncDataReceiptProcess = runtimeService.startProcessInstanceByKey("asyncDataReceiptProcess");

        Task collectBookInfo = taskService.createTaskQuery().processInstanceId(asyncDataReceiptProcess.getId()).taskDefinitionKey("collectBookInfo").singleResult();

        taskService.complete(collectBookInfo.getId());

        log.info("Starting the task");

        return asyncDataReceiptProcess.getProcessInstanceId();
    }

    @PostMapping("/print/{id}")
    public void postbackRequest(@PathVariable("id") String id){
        log.info("Print Service Returned");

        Execution receivePrintComplete = runtimeService.createExecutionQuery().processInstanceId(id).activityId("receivePrintComplete").singleResult();

        runtimeService.trigger(receivePrintComplete.getId());
    }

}
