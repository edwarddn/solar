package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "cliente")
@Getter
public class Cliente extends PessoaFisica {

    private String email;

    public Cliente(final String nome,
                   final LocalDate aniver,
                   final String cpf,
                   final String email) {
        super(nome, aniver, cpf);
        this.email = email;
    }

    public Cliente(ClienteModel model) {
        super(model.getNome(), model.getAniver(), model.getCpf());
        this.email = model.getEmail();
    }

    public Cliente editar(final String nome, final LocalDate aniver, final String cpf, final String email) {
        super.editar(nome, aniver, cpf);
        this.email = email;
        return this;
    }
}
