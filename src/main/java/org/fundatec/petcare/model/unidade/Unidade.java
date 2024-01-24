package org.fundatec.petcare.model.unidade;

import jakarta.persistence.*;
import org.fundatec.petcare.model.endereco.Endereco;

import java.util.UUID;

@Entity(name = "UNIDADE")
@Table(name = "UNIDADE")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_UNIDADE", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Unidade() {
    }

    public Unidade(UUID id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

