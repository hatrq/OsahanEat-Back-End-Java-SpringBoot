package project.Oshana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Oshana.entity.OrderItem;
import project.Oshana.entity.keys.KeyOrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, KeyOrderItem> {
}
