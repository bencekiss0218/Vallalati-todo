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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findUserById(int userId) {
        return userRepository.findById(userId);
    }


    public User findWorkerByTaskId(int id) {
        Task task = null;
        for (Task t : taskRepository.findAll()) {
            if (t.getId() == id) {
                task = t;
                break;
            }
        }
        return task.getUser();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
