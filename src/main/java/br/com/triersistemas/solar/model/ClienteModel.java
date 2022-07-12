package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class ClienteModel {

    private UUID id;
    private String nome;
    private LocalDate aniver;
    private String cpf;
    private String email;
    private Long idade;
    private String documento;
    private Boolean documentoValido;

    public ClienteModel(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.aniver = cliente.getAniver();
        this.cpf = cliente.getDocumento();
        this.email = cliente.getEmail();

        this.idade = cliente.getIdade();
        this.documento = this.cpf;
        this.documentoValido = cliente.getDocumentoValido();
    }
}
