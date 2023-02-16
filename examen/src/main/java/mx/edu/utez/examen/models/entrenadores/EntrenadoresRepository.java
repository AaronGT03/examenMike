package mx.edu.utez.examen.models.entrenadores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrenadoresRepository extends JpaRepository<Entrenadores, Long> {
    Optional<Entrenadores> findById(Long id);
    Optional<Entrenadores>findByNombre(String nombre);
    @Query(value = "UPDATE entrenadores SET nombre= : nombre"+"WHERE id= :id ;",nativeQuery = true)
    boolean update( @Param("id")Long id);
}
