package hu.elte.VallalatiTODOProject.repository;

import hu.elte.VallalatiTODOProject.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
