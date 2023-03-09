package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("select t.car from Task t where t.car.carType='coupe'order by t.car.carType,t.price desc ")
    List<Task> findTaskWithCarAndMechanic ();
}
