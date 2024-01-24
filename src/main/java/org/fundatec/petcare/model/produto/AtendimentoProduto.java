package org.fundatec.petcare.model.produto;

import jakarta.persistence.*;
import org.fundatec.petcare.model.atendimento.Atendimento;

import java.time.LocalDateTime;

@Entity(name = "ATENDIMENTO_PRODUTO")
@Table(name = "ATENDIMENTO_PRODUTO")
public class AtendimentoProduto {

    @EmbeddedId
    private String id;

    @Column(name = "QUANTIDADE", nullable = false)
    private int quantidade;

    @ManyToOne
    @MapsId("ID_PRODUTO")
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    private Produto produto;

    @ManyToOne
    @MapsId("ID_ATENDIMENTO")
    @JoinColumn(name = "ID_ATENDIMENTO", referencedColumnName = "ID_ATENDIMENTO")
    private Atendimento atendimento;

    @Column(name = "DATA_ENTRADA", nullable = false)
    private LocalDateTime dataEntrada;

    public AtendimentoProduto() {
    }

    public AtendimentoProduto(String id, int quantidade, Produto produto, Atendimento atendimento, LocalDateTime dataEntrada) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.atendimento = atendimento;
        this.dataEntrada = dataEntrada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}