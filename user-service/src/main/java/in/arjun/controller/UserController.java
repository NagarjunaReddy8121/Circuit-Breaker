package in.arjun.controller;

import in.arjun.client.ProductClient;
import in.arjun.response.ProductResponse;
import in.arjun.service.DummyProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DummyProductService service;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/products")
    @CircuitBreaker(name = "USER-SERVICE",fallbackMethod = "getProductsList")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> allProducts = productClient.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponse>> getProductsList(Exception e){
        List<ProductResponse> responseList = service.getAllProducts();
        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }
}
