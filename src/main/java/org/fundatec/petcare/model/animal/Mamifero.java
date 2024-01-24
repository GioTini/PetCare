package org.fundatec.petcare.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.fundatec.petcare.model.vacina.Vacina;

import java.util.Set;

@Entity(name = "MAMIFERO")
@Table(name = "MAMIFERO")
public class Mamifero extends TipoAnimal {

    @Column(name = "RACA", nullable = false)
    private String raca;

    @Column(name = "POSSUI_PELOS", nullable = false)
    private boolean possuiPelos;

    public Mamifero() {
    }

    public Mamifero(String raca, boolean possuiPelos) {
        this.raca = raca;
        this.possuiPelos = possuiPelos;
    }

    public Mamifero(String id, TipoAnimalEnum especie, Set<Vacina> vacinas, String raca, boolean possuiPelos) {
        super(id, especie, vacinas);
        this.raca = raca;
        this.possuiPelos = possuiPelos;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isPossuiPelos() {
        return possuiPelos;
    }

    public void setPossuiPelos(boolean possuiPelos) {
        this.possuiPelos = possuiPelos;
    }
}