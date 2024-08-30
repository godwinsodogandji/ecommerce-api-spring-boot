package bj.highfiveuniveristy.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniveristy.ecommerce.models.Product;
import bj.highfiveuniveristy.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById( Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("aucun utilisateur trouvé"));
        return product;
    }


    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public Product updateProduct( Long id,Product product) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product avec l'id " + id + " non trouvé"));
        productToUpdate.setName(product.getName());
        productToUpdate.setCategories(product.getCategories());
        productToUpdate.setDescription(product.getDescription());
        return productToUpdate;
    }

    public void deleteProduct( Long id) {
        productRepository.deleteById(id);
    }
}
