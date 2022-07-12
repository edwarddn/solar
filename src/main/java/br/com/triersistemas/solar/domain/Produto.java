package br.com.triersistemas.solar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@Table(name = "produto")
@NoArgsConstructor
public class Produto {

    @Id
    private UUID id;
    private String nome;
    private BigDecimal valor;

    public Produto(final String nome, final BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.valor = valor;
    }

    public Produto editar(final String nome, final BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
        return this;
    }
}
