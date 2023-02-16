package mx.edu.utez.examen.controlllers.entrenadores.dto;

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
public class EntrenadoresDto {
    private long id;
    private String nombre;
    private String equipo;
    public Entrenadores getEntrenadores() {
        return new Entrenadores(
                getId(), getNombre(), getEquipo(), null
        );
    }
}
