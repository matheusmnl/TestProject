package br.com.viacep.productapi.repository;

import br.com.viacep.productapi.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
