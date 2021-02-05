package poly.shopme.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poly.shopme.common.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
}
