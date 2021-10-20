package nl.hsleiden.iipsene2database.DAO;

import nl.hsleiden.iipsene2database.DAO.Repository.RoleRepository;
import nl.hsleiden.iipsene2database.model.Role;

import java.util.List;

public class RoleDAO implements DAO<Role> {
    private final RoleRepository roleRepository;

    public RoleDAO(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role get(Long id) {
        return this.roleRepository.getById(id);
    }

    @Override
    public Role create(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Long id) {
        return null;
    }

    @Override
    public void delete(Role role) {
        this.roleRepository.delete(role);
    }
}
