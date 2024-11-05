package org.fis.inventorymanagement;

import org.fis.inventorymanagement.models.Product;
import org.fis.inventorymanagement.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testCreateProduct() {
        Product productDTO = new Product( 1, "Product1", 100, 10);
        Product product = productService.createProduct(productDTO);
        assertNotNull(product);
        assertEquals(1, product.getProductId());
        assertEquals("Product1", product.getName());
        assertEquals(100, product.getPrice());
        assertEquals(10, product.getStock());
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertEquals(3, products.size());
    }

    @Test
    void testGetProductById() {
        Product product = productService.getProductById(1);
        assertNotNull(product);
        assertEquals(1, product.getId());
    }

    @Test
    void testUpdateProduct() {
        Product product = productService.getProductById(1);

        product.setName("Prueba");
        product.setPrice(150);
        product.setStock(2);

        Product updatedProduct = productService.updateProduct(1, product);

        assertNotNull(updatedProduct);
        assertEquals(1, updatedProduct.getProductId());
        assertEquals("Prueba", updatedProduct.getName());
        assertEquals(150, updatedProduct.getPrice());
        assertEquals(2, updatedProduct.getStock());
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1);
        Product product = productService.getProductById(1);
        assertNull(product);
    }
}
