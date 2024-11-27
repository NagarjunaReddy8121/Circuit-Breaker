package in.arjun.repository;

import in.arjun.entity.DummyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyProductRepository extends JpaRepository<DummyProduct,Integer> {
}
