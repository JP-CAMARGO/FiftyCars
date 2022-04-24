package Domain;

import Utils.ConsoleUtils;

import java.util.Locale;

public class Veiculo {
    String placa;
    String marca;
    String cor;
    String modelo;
    double valorDiaria;
    boolean veiculoDisponivel;
    String cliente;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Veiculo() {
        this.valorDiaria=0;
        this.veiculoDisponivel=true;
        this.cliente="";
    }

    public Veiculo(String placa, String marca, String cor, String modelo, double valorDiaria) {
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.veiculoDisponivel = true;
        this.cliente = "";
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setVeiculoDisponivel(boolean veiculoDisponivel) {
        this.veiculoDisponivel = veiculoDisponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isVeiculoDisponivel() {
        return veiculoDisponivel;
    }

}
