package app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import app.entities.Task;

public interface TaskRepository 
       extends CrudRepository<Task, Long> {
}