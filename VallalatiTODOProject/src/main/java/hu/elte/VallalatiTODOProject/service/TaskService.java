package hu.elte.VallalatiTODOProject.service;

import java.util.List;
import java.util.Optional;

import hu.elte.VallalatiTODOProject.model.Task;
import hu.elte.VallalatiTODOProject.model.User;
import hu.elte.VallalatiTODOProject.repository.TaskRepository;
import hu.elte.VallalatiTODOProject.repository.UserRepository;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public Optional<Task> findTask(int taskId) {
        return taskRepository.findById(taskId);
    }

    public Task findTaskById(int id) {

        Task task = null;
        for (Task t : taskRepository.findAll()) {
            if (t.getId() == id) {
                task = t;
                break;
            }
        }
        return task;
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

}
