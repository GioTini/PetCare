package org.fundatec.petcare.model.animal;

import jakarta.persistence.*;
import org.fundatec.petcare.model.cliente.domain.Cliente;

import java.util.UUID;

@Entity(name = "PET")
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_PET", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "IDADE", nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(referencedColumnName = "ID_ANIMAL")
    private TipoAnimal tipoAnimal;

    public Pet() {
    }

    public Pet(UUID id, String nome, int idade, Cliente cliente, TipoAnimal tipoAnimal) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cliente = cliente;
        this.tipoAnimal = tipoAnimal;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
}

