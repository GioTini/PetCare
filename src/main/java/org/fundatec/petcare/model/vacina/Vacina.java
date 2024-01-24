package org.fundatec.petcare.model.vacina;

import jakarta.persistence.*;
import org.fundatec.petcare.model.animal.TipoAnimal;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "VACINA")
@Table(name = "VACINA")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_VACINA", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VALIDADE", nullable = false)
    private LocalDate validade;

    @ManyToOne
    @JoinColumn(name = "TIPO_ANIMAL")
    private TipoAnimal tipoAnimal;

    @OneToMany(mappedBy = "vacina", orphanRemoval = true)
    private Set<Doenca> doencas = new LinkedHashSet<>();

    public Vacina() {
    }

    public Vacina(UUID id, String nome, LocalDate validade, TipoAnimal tipoAnimal, Set<Doenca> doencas) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
        this.tipoAnimal = tipoAnimal;
        this.doencas = doencas;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Set<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(Set<Doenca> doencas) {
        this.doencas = doencas;
    }
}
