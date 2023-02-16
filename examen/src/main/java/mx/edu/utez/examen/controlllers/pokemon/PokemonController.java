package mx.edu.utez.examen.controlllers.pokemon;

import mx.edu.utez.examen.controlllers.pokemon.dto.PokemonDto;
import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.services.pokemon.PokemonService;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-examen/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>getOne(@PathVariable("id") Long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>>insert(
            @RequestBody PokemonDto pokemon
    ){
        return new ResponseEntity<>(
                this.service.insert(pokemon.getPokemon()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>>update(@PathVariable long id ,@RequestBody PokemonDto pokemon){

        return new ResponseEntity<>(
                this.service.update(pokemon.getPokemon(),id),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
