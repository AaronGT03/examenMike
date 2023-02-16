package mx.edu.utez.examen.models.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.examen.models.entrenadores.Entrenadores;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String tipo;

    private int nivel;

    private int salud;

    private int ataque;

    private int defensa;

    @ManyToOne
    @JoinColumn(name = "entrenador_id",nullable = false)
    private Entrenadores entrenadores;

}
