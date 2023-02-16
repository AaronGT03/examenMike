package mx.edu.utez.examen.controlllers.entrenadores;

import mx.edu.utez.examen.controlllers.entrenadores.dto.EntrenadoresDto;
import mx.edu.utez.examen.controlllers.pokemon.dto.PokemonDto;
import mx.edu.utez.examen.models.entrenadores.Entrenadores;
import mx.edu.utez.examen.models.pokemon.Pokemon;
import mx.edu.utez.examen.services.entrenadores.EntrenadoresService;
import mx.edu.utez.examen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api-examen/entrenadores")
@CrossOrigin(origins = {"*"})
public class EntrenadoresController {
    @Autowired
    private EntrenadoresService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenadores>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>getOne(@PathVariable("id") Long id ){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Entrenadores>>insert(
            @RequestBody EntrenadoresDto entrenadoresDto
    ){
        return new ResponseEntity<>(
                this.service.insert(entrenadoresDto.getEntrenadores()),
                HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>>update(@PathVariable long id , @RequestBody EntrenadoresDto entrenadoresDto){

        return new ResponseEntity<>(
                this.service.update(entrenadoresDto.getEntrenadores(),id),
                HttpStatus.CREATED
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenadores>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
