package ci.boobacool.projetPiloteJAVA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.projetPiloteJAVA.entities.Task;
import ci.boobacool.projetPiloteJAVA.entities.User;

public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
