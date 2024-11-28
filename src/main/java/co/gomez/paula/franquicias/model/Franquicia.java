package co.gomez.paula.franquicias.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Table(name = "franquicias")
@Entity
@Getter
@Setter
public class Franquicia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nombre;

    // relaciones
    @OneToMany(mappedBy = "franquicia")
    private Set<Sucursal> sucursales;

}
