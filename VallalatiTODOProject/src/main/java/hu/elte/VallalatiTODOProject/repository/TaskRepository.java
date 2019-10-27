package hu.elte.VallalatiTODOProject.repository;

import hu.elte.VallalatiTODOProject.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
}
