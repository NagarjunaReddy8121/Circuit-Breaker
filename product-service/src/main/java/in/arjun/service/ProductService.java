package in.arjun.service;

import in.arjun.entity.Product;
import in.arjun.repository.ProductRepository;
import in.arjun.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> getAllProducts(){
        List<Product> productsList = productRepository.findAll();
       return productsList.stream().map(ProductResponse::fromProduct).toList();
    }
}
