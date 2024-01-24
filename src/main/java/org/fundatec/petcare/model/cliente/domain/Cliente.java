package org.fundatec.petcare.model.cliente.domain;

import jakarta.persistence.*;
import org.fundatec.petcare.model.endereco.Endereco;

import java.util.UUID;

@Entity(name = "CLIENTE")
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_CLIENTE", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private long cpf;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, long cpf, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

