package org.fis.inventorymanagement.services;

import org.fis.inventorymanagement.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Product1", 100, 10),
                    new Product(2, "Product2", 50, 5),
                    new Product(3, "Product3", 200, 20)
            )
    );

    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setProductId(updatedProduct.getProductId());
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                product.setStock(updatedProduct.getStock());
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
