package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.helper.StringUtils;

import java.time.LocalDate;
import java.util.List;

public abstract class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica() {
        this.cnpj = this.geraCnpj(super.geraDocumento(12));
    }

    protected PessoaJuridica(final String nome, final LocalDate aniver, final String cnpj) {
        super(nome, aniver);
        this.cnpj = StringUtils.extractNumbers(cnpj);
    }

    public void editar(final String nome, final LocalDate aniver, final String cnpj) {
        super.editar(nome, aniver);
        this.cnpj = cnpj;
    }

    public String geraCnpj(final List<Integer> digitos) {
        digitos.add(this.mod11(digitos, 6,7,8,9,2,3,4,5,6,7,8,9));
        digitos.add(this.mod11(digitos, 5,6,7,8,9,2,3,4,5,6,7,8,9));
        return StringUtils.listToString(digitos);
    }
    @Override
    public Boolean getDocumentoValido() {
        var documento = StringUtils.toListInteger(this.cnpj);
        if (documento.size() == 14 && documento.stream().distinct().count() > 1) {
            return geraCnpj(documento.subList(0, 12)).equals(this.cnpj);
        }
        return false;
    }

    @Override
    public String getDocumento() {
        if (cnpj.length() == 14) {
            return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
        return cnpj;
    }
}
