package org.fundatec.petcare.model.vacina;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "DOENCA")
@Table(name = "DOENCA")
public class Doenca {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_VACINA")
    private Vacina vacina;

    public Doenca() {
    }

    public Doenca(UUID id, String nome, String descricao, Vacina vacina) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.vacina = vacina;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
}
