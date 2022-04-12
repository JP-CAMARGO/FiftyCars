package Domain;

import java.util.Objects;

public class Cliente {
    String nome;
    String telefone;
    String endereco;
    int indexVeiculoDesejado;

    public Cliente(String nome, String telefone, String endereco, int indexVeiculoDesejado) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.indexVeiculoDesejado = indexVeiculoDesejado;
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

    public int getIndexVeiculoDesejado() {
        return indexVeiculoDesejado;
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

    public void setIndexVeiculoDesejado(int indexVeiculoDesejado) {
        this.indexVeiculoDesejado = indexVeiculoDesejado;
    }


}
