package kz.springboot.SpringBootDemo.repositories;

import kz.springboot.SpringBootDemo.entities.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ShopItemRepository extends JpaRepository<ShopItems, Long> {

    List<ShopItems> findAllByAmountGreaterThanOrderByPriceDesc(int amount);

}
