package mx.edu.utez.examen.services.entrenadores;

import mx.edu.utez.examen.models.entrenadores.Entrenadores;
import mx.edu.utez.examen.models.entrenadores.EntrenadoresRepository;
import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrenadoresService {
    @Autowired
    private EntrenadoresRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Entrenadores>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<Entrenadores>getOne(Long id){
        if (this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Entrenadores no encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> insert(Entrenadores entrenadores){
        Optional<Entrenadores> exists=this.repository.findByNombre(entrenadores.getNombre());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "La categoria ya se encuentra registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(entrenadores),
                false,
                200,
                "Categoria registrada"
        );

    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> update(Entrenadores entrenadores, long id){
        if (!this.repository.existsById(entrenadores.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El pokemon no se encontró"
            );
        return new Response<>(
                this.repository.saveAndFlush(entrenadores),
                false,
                200,
                "Pokemon actualizado correctamente"
        );

    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Entrenadores> delete(long id){
        Response response=null;
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);

            response= new Response<>(
                    this.repository.findById(id),
                    false,
                    200,
                    "El entrenador se eliminó"
            );
        }else {
            return new Response<>(
                    null,
                    true,
                    400,
                    "Entrenador no se encontro"
            );
        }

        return  response;
    }
}
