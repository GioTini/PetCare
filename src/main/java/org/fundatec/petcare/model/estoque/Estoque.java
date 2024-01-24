package org.fundatec.petcare.model.estoque;

import jakarta.persistence.*;
import org.fundatec.petcare.model.produto.Produto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "ESTOQUE")
@Table(name = "ESTOQUE")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "DATA_OPERACAO", nullable = false)
    private LocalDateTime dataOperacao;

    @Column(name = "TIPO_OPERACAO", nullable = false)
    private Enum<TipoOperacao> tipoOperacaoEnum;

    @Column(name = "QUANTIDADE", nullable = false)
    private int quantidade;

    @Column(name = "VALIDADE", nullable = false)
    private LocalDate validade;

    @Column(name = "LOTE", nullable = false)
    private String lote;

    @OneToMany(mappedBy = "estoque", orphanRemoval = true)
    private Set<Produto> produtos = new LinkedHashSet<>();

    public Estoque() {
    }

    public Estoque(UUID id, LocalDateTime dataOperacao, Enum<TipoOperacao> tipoOperacaoEnum, int quantidade, LocalDate validade, String lote, Set<Produto> produtos) {
        this.id = id;
        this.dataOperacao = dataOperacao;
        this.tipoOperacaoEnum = tipoOperacaoEnum;
        this.quantidade = quantidade;
        this.validade = validade;
        this.lote = lote;
        this.produtos = produtos;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDateTime dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Enum<TipoOperacao> getTipoOperacaoEnum() {
        return tipoOperacaoEnum;
    }

    public void setTipoOperacaoEnum(Enum<TipoOperacao> tipoOperacaoEnum) {
        this.tipoOperacaoEnum = tipoOperacaoEnum;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
