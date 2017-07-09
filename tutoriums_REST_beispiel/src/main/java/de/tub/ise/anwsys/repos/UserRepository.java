package de.tub.ise.anwsys.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import de.tub.ise.anwsys.models.User;

/**
 * All the database methods related to User
 * 
 * JpaRepository extends CrudRepository
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByName(String name);
	Optional<User> findById(Long id);
}
