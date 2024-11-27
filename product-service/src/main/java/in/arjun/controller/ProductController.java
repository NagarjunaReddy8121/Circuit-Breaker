package in.arjun.controller;

import in.arjun.response.ProductResponse;
import in.arjun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> responseList = productService.getAllProducts();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
