package bj.highfiveuniveristy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniveristy.ecommerce.models.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
