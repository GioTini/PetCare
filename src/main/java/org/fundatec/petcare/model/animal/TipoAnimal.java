package org.fundatec.petcare.model.animal;

import jakarta.persistence.*;
import org.fundatec.petcare.model.vacina.Vacina;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "ANIMAL")
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TipoAnimal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_ANIMAL", nullable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_ANIMAL", nullable = false)
    private TipoAnimalEnum especie;

    @OneToMany(mappedBy = "tipoAnimal", orphanRemoval = true)
    private Set<Vacina> vacinas = new LinkedHashSet<>();

    public TipoAnimal() {
    }

    public TipoAnimal(String id, TipoAnimalEnum especie, Set<Vacina> vacinas) {
        this.id = id;
        this.especie = especie;
        this.vacinas = vacinas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoAnimalEnum getEspecie() {
        return especie;
    }

    public void setEspecie(TipoAnimalEnum especie) {
        this.especie = especie;
    }

    public Set<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(Set<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
}
