package nl.hsleiden.iipsene2database.DAO.Repository;

import nl.hsleiden.iipsene2database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Handles the queries for the User
 * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds the user by its email.
     * @param email The email of the user
     * @return The user the email belongs to
     * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
     */
    User findByEmail(String email);
}
