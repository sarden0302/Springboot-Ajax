package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Product;
import kh.edu.react.provider.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        // keyword = productName || productCategory
        return productMapper.searchProducts(keyword);
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.findProductById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }

    @Override
    public int deleteProduct(int productId) {
        return productMapper.deleteProduct(productId);
    }
}
