package mx.edu.utez.examen.services.pokemon;

import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.models.pokemon.PokemonRepository;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {
    @Autowired
    private PokemonRepository repository;
    @Transactional(readOnly = true)
    public Response<List<Pokemon>>getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<Pokemon>getOne(Long id){
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
                "Pokemon no encontrado"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        Optional<Pokemon> exists=this.repository.findByNombre(pokemon.getNombre());
        if (exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "Pokemon ya se encuentra registrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon registrado"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Pokemon pokemon, long id){
        if (!this.repository.existsById(pokemon.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El pokemon no se encontró"
            );
        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Pokemon actualizado correctamente"
        );

    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete(long id){
        Response response=null;
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);

            response= new Response<>(
                   this.repository.findById(id),
                    false,
                    200,
                    "El pokemon se eliminó"
            );
        }else {
            return new Response<>(
                    null,
                    true,
                    400,
                    "Pokemon no se encontro"
            );
        }

        return  response;
    }
}
