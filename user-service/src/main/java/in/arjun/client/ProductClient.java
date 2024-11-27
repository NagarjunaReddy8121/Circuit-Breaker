package in.arjun.client;

import in.arjun.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE",url = "http://localhost:8080/product")
public interface ProductClient {

    @GetMapping("/list")
    public List<ProductResponse> getAllProducts();
}
