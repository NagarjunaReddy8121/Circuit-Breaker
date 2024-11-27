package in.arjun.service;

import in.arjun.entity.DummyProduct;
import in.arjun.repository.DummyProductRepository;
import in.arjun.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyProductService {

    @Autowired
    private DummyProductRepository repository;

    public List<ProductResponse> getAllProducts(){
        List<DummyProduct> list = repository.findAll();
      return list.stream().map(ProductResponse::fromProduct).toList();
    }
}
