package mx.edu.utez.examen.models.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findById(Long id);
    Optional<Pokemon>findByNombre(String nombre);

   @Query(value = "UPDATE pokemon SET nombre= : nombre"+"WHERE id= :id ;",nativeQuery = true)
    boolean update( @Param("id")Long id);

}
