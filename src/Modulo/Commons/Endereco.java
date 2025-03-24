package Modulo.Commons;

import Modulo.Commons.Enums.Status;

import static Modulo.SGE.Utils.CaptalizarTexto.capitalizarPalavras;

public class Endereco {
    private final String rua;
    private final String numero;
    private final String cep;
    private Status status;

    public Endereco(String rua, String numero, String cep) {
        this.rua = capitalizarPalavras(rua);
        this.numero = ((!numero.isEmpty() ? numero : "s/n"));
        this.cep = FormatarCEP(cep);
        this.status = Status.Habilitado;
    }

    @Override
    public String toString() {
        if (this.status != status.Habilitado) {
            return "Endereço desabilitado";
        } else {
            return rua + ", " + (numero != null ? "n° " + numero : "s/n") + " - CEP: " + cep;
        }
    }

    private String FormatarCEP(String cepAntigo) {
        return cepAntigo.substring(0, 5) + "-" + cepAntigo.substring(5);
    }

    public void DesabilitarEndereco() {
        this.status = Status.Desabilitado;
    }

}
