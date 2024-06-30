package kz.springboot.SpringBootDemo.repositories;

import kz.springboot.SpringBootDemo.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
