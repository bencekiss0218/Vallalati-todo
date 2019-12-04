package hu.elte.VallalatiTODOProject.controller;

import hu.elte.VallalatiTODOProject.model.Task;
import hu.elte.VallalatiTODOProject.model.User;
import hu.elte.VallalatiTODOProject.security.AuthenticatedUser;
import hu.elte.VallalatiTODOProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/workers")
public class UserController {

    @Autowired
    AuthenticatedUser authenticatedUser;

    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("login")
    public ResponseEntity login() {
        return ResponseEntity.ok(authenticatedUser.getUser());
    }

    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody User user) {
        Optional<User> oUser = userService.findByUsername(user.getUsername());
        if (oUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.ROLE_TEAM_MEMBER);
        return ResponseEntity.ok(userService.save(user));
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        Optional<User> optionalUser = userService.findUserById(id);

        if (optionalUser.isPresent()) {
            userService.delete(optionalUser.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User registeredUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(registeredUser);
    }

    @CrossOrigin
    @GetMapping("")
    public Iterable<User> getUsers() {
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable(value = "id") int id) {
        Optional<User> optionalUser = userService.findUserById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/tasks/{id}")
    public ResponseEntity<User> findWorkerByTaskId(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(userService.findWorkerByTaskId(id));
    }

    @PostMapping("/addtask/{id}")
    public ResponseEntity<User> addTaskToWorker(
            @RequestBody Task task,
            @PathVariable Integer id
    ) {
        Optional<User> oUser = userService.findUserById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();
            user.getTaskstodo().add(task);
            task.setUser(user);
            User createdUser = userService.save(user);
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/removetask/{id}")
    public ResponseEntity<User> removeTaskFromWorker(
            @RequestBody Task task,
            @PathVariable Integer id
    ) {
        Optional<User> oUser = userService.findUserById(id);
        if (oUser.isPresent()) {
            User user = oUser.get();
            if(user.getTaskstodo().contains(task)){
                user.getTaskstodo().remove(task);
                task.setUser(user);
                User createdUser = userService.save(user);
                return ResponseEntity.ok(createdUser);
            }else{
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}