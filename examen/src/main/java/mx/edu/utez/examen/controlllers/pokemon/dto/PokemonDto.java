package mx.edu.utez.examen.controlllers.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.entrenadores.Entrenadores;
import mx.edu.utez.examen.models.pokemon.Pokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private long id;
    private String nombre;
    private String tipo;
    private int nivel;

    private int salud;

    private int ataque;

    private int defensa ;
    private Entrenadores entrenadores;
    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),getNombre(),getTipo(),getNivel(),getSalud(),getAtaque(),getDefensa(),getEntrenadores()
        );

    }
}
