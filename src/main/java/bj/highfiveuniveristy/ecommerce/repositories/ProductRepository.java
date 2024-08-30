package bj.highfiveuniveristy.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniveristy.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
