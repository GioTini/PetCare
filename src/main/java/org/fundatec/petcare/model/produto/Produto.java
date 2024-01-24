package org.fundatec.petcare.model.produto;

import jakarta.persistence.*;
import org.fundatec.petcare.model.animal.TipoAnimal;
import org.fundatec.petcare.model.estoque.Estoque;
import org.fundatec.petcare.model.estoque.QuantidadeEstoque;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "PRODUTO")
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_PRODUTO", nullable = false)
    private UUID id;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal valor;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_ANIMAL")
    private TipoAnimal tipoAnimal;

    @OneToOne(mappedBy = "produto", orphanRemoval = true)
    private QuantidadeEstoque quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "ESTOQUE_ID")
    private Estoque estoque;

    public Produto() {
    }

    public Produto(UUID id, BigDecimal valor, String descricao, TipoAnimal tipoAnimal, QuantidadeEstoque quantidadeEstoque, Estoque estoque) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.tipoAnimal = tipoAnimal;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoque = estoque;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public QuantidadeEstoque getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(QuantidadeEstoque quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
}