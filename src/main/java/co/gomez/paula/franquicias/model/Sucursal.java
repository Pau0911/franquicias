package co.gomez.paula.franquicias.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "sucursales")
@Getter
@Setter
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "id_franquicia")
    private UUID idFranquicia;
    private String nombre;

    // relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_franquicia", insertable = false, updatable = false)
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal")
    private Set<Producto> productos;

}
