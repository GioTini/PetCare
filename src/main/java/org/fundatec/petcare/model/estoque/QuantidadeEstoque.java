package org.fundatec.petcare.model.estoque;

import jakarta.persistence.*;
import org.fundatec.petcare.model.produto.Produto;

import java.util.UUID;

@Entity(name = "QUANTIDADE_ESTOQUE")
@Table(name = "QUANTIDADE_ESTOQUE")
public class QuantidadeEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "quantidade_atual", nullable = false)
    private Long quantidadeAtual;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "produtoId")
    private Produto produto;

    public QuantidadeEstoque() {
    }

    public QuantidadeEstoque(UUID id, Long quantidadeAtual, Produto produto) {
        this.id = id;
        this.quantidadeAtual = quantidadeAtual;
        this.produto = produto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Long quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}