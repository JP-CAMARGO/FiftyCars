package Domain;

import java.util.Objects;

public class Cliente {
    String nome;
    String telefone;
    String endereco;
    Veiculo veiculoDesejado;

    public Veiculo getVeiculoDesejado() {
        return veiculoDesejado;
    }

    public void setVeiculoDesejado(Veiculo veiculoDesejado) {
        this.veiculoDesejado = veiculoDesejado;
    }

    public Cliente(String nome, String telefone, String endereco, Veiculo veiculoDesejado) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculoDesejado = veiculoDesejado;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public Veiculo getIndexVeiculoDesejado() {
        return veiculoDesejado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIndexVeiculoDesejado(Veiculo veiculoDesejado) {
        this.veiculoDesejado = veiculoDesejado;
    }

}
