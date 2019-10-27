package hu.elte.VallalatiTODOProject.service;

import java.util.List;
import hu.elte.VallalatiTODOProject.model.Comment;
import hu.elte.VallalatiTODOProject.repository.CommentRepository;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

}
