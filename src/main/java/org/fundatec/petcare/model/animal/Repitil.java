package org.fundatec.petcare.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.fundatec.petcare.model.vacina.Vacina;

import java.util.Set;

@Entity(name = "REPITIL")
@Table(name = "REPITIL")
public class Repitil extends TipoAnimal {

    @Column(name = "PECONHENTO", nullable = false)
    private boolean peconhento;

    public Repitil() {
    }

    public Repitil(boolean peconhento) {
        this.peconhento = peconhento;
    }

    public Repitil(String id, TipoAnimalEnum especie, Set<Vacina> vacinas, boolean peconhento) {
        super(id, especie, vacinas);
        this.peconhento = peconhento;
    }

    public boolean isPeconhento() {
        return peconhento;
    }

    public void setPeconhento(boolean peconhento) {
        this.peconhento = peconhento;
    }
}