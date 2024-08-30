package bj.highfiveuniveristy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniveristy.ecommerce.models.Category;

public interface CategoryRepository  extends JpaRepository<Category,Long>{

}
