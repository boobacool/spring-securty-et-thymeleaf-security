package ci.boobacool.projetPiloteJAVA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.boobacool.projetPiloteJAVA.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByNameLike(String name);

}
