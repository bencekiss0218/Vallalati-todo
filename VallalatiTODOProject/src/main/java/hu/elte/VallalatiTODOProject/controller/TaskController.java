package hu.elte.VallalatiTODOProject.controller;

import hu.elte.VallalatiTODOProject.model.Task;
import hu.elte.VallalatiTODOProject.model.Comment;
import hu.elte.VallalatiTODOProject.security.AuthenticatedUser;
import hu.elte.VallalatiTODOProject.service.CommentService;
import hu.elte.VallalatiTODOProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Autowired
    private TaskService taskService;

    @Autowired
    private CommentService commentService;

    @Secured( { "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" } )
    @GetMapping("")
    public Iterable<Task> getTasks() {
        return taskService.findAll();
    }

    @Secured( { "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" } )
    @GetMapping("/{id}")
    public Task getTaskById(
            @PathVariable Integer id
    ) {
        try {
            Task task = taskService.findTaskById(id);
            return task;
        } catch (Exception e) {
            return null;
        }
    }

    @Secured( { "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" } )
    @PostMapping("")
    public ResponseEntity<Task> createTask(
            @RequestBody Task task
    ) {
        task.setUser(authenticatedUser.getUser());
        Task savedTask = taskService.save(task);
        return ResponseEntity.ok(savedTask);
    }

    @Secured({ "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" })
    @PatchMapping("/status/{id}")
    public ResponseEntity<Task> modifyTaskStatus(
            @PathVariable Integer id,
            @RequestBody Task task
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            if (task.getStatus() == null) {
                return ResponseEntity.badRequest().build();
            }
            Task oldTask = oTask.get();
            oldTask.setStatus(task.getStatus());
            Task savedTask = taskService.save(oldTask);

            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" })
    @PatchMapping("/priority/{id}")
    public ResponseEntity<Task> modifyTaskPriority(
            @PathVariable Integer id,
            @RequestBody Task task
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            if (task.getStatus() == null) {
                return ResponseEntity.badRequest().build();
            }
            Task oldTask = oTask.get();
            oldTask.setPriority(task.getPriority());
            Task savedTask = taskService.save(oldTask);

            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" })
    @PatchMapping("/duedate/{id}")
    public ResponseEntity<Task> modifyTaskDueDate(
            @PathVariable Integer id,
            @RequestBody Task task
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            if (task.getStatus() == null) {
                return ResponseEntity.badRequest().build();
            }
            Task oldTask = oTask.get();
            oldTask.setDuedate(task.getDuedate());
            Task savedTask = taskService.save(oldTask);

            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" })
    @PatchMapping("/worker/{id}")
    public ResponseEntity<Task> modifyTaskWorker(
            @PathVariable Integer id,
            @RequestBody Task task
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            if (task.getStatus() == null) {
                return ResponseEntity.badRequest().build();
            }
            Task oldTask = oTask.get();
            oldTask.setUser(task.getUser());
            Task savedTask = taskService.save(oldTask);

            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured({ "ROLE_TEAM_LEADER", "ROLE_TEAM_MEMBER" })
    @PatchMapping("/description/{id}")
    public ResponseEntity<Task> modifyTaskDescription(
            @PathVariable Integer id,
            @RequestBody Task task
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            if (task.getStatus() == null) {
                return ResponseEntity.badRequest().build();
            }
            Task oldTask = oTask.get();
            oldTask.setDescription(task.getDescription());
            Task savedTask = taskService.save(oldTask);

            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Secured( { "ROLE_TEAM_LEADER" } )
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(
            @PathVariable Integer id
    ) {
        try {
            Task taskToDelete = taskService.findTaskById(id);
            taskService.delete(taskToDelete);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/comments/{id}")
    public ResponseEntity<Comment> addComment(
            @RequestBody Comment comment,
            @PathVariable Integer id
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            Task task = oTask.get();
            task.getComments().add(comment);
            comment.setTask(task);
            Comment createdComment = commentService.save(comment);
            return ResponseEntity.ok(createdComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/removecomment/{id}")
    public ResponseEntity<Comment> removeComment(
            @RequestBody Comment comment,
            @PathVariable Integer id
    ) {
        Optional<Task> oTask = taskService.findTask(id);
        if (oTask.isPresent()) {
            Task task = oTask.get();
            if(task.getComments().contains(comment)){
                task.getComments().remove(comment);
                comment.setTask(task);
                Comment createdComment = commentService.save(comment);
                return ResponseEntity.ok(createdComment);
            }else{
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
