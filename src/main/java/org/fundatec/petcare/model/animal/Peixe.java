package org.fundatec.petcare.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.fundatec.petcare.model.vacina.Vacina;

import java.util.Set;

@Entity(name = "PEIXE")
@Table(name = "PEIXE")
public class Peixe extends TipoAnimal {

    @Column(name = "TIPO_AGUA", nullable = false)
    private String tipoAgua;

    public Peixe() {
    }

    public Peixe(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    public Peixe(String id, TipoAnimalEnum especie, Set<Vacina> vacinas, String tipoAgua) {
        super(id, especie, vacinas);
        this.tipoAgua = tipoAgua;
    }

    public String getTipoAgua() {
        return tipoAgua;
    }

    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }
}