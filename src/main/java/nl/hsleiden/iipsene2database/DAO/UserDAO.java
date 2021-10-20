package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.UserRepository;
import nl.hsleiden.iipsene2database.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAO implements DAO<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User update(Long id) {
        return null;
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
