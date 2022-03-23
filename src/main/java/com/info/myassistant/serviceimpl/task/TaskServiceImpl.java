package com.info.myassistant.serviceimpl.task;

import com.info.myassistant.dto.responseDto.ResponseDto;
import com.info.myassistant.dto.taskDto.TaskDto;
import com.info.myassistant.model.task.Task;
import com.info.myassistant.repo.task.TaskRepo;
import com.info.myassistant.service.taskService.TaskService;
import com.info.myassistant.shared.ServiceResponse.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author rawalokes
 * Date:3/22/22
 * Time:3:55 PM
 */
@Service
public class TaskServiceImpl extends BaseResponse implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    //create a new task in database
    @Override
    public ResponseDto create(TaskDto taskDto) {
        try {
            //convert task into taskDto
            Task task = new Task(taskDto);
            taskRepo.save(task);
            return successResponse("Task Added successfully", null);
        } catch (Exception e) {
            return errorResponse("Failed", null);
        }

    }

    @Override
    public ResponseDto findByID(Integer integer) {
        Optional<Task> task = taskRepo.findById(integer);

        if (task != null) {
            TaskDto taskDto = new TaskDto(task.get());
            return successResponse("", taskDto);
        } else {
            return errorResponse("Task not found", null);
        }


    }

}
