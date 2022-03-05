package jp.x0x0b.jbbs.repository;

import jp.x0x0b.jbbs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
