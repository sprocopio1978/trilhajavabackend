package trilha.back.financys.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
