package Domain;

import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Filial {
    String Nome;
    Filial proxima;
    Veiculo[] frota;
    int tamanhoFrota;
    int tamanhoListaEspera;
    Queue<Cliente> listaEspera;
    Stack<String> registros = new Stack<String>();

    public Stack<String> getRegistros() {
        return registros;
    }

    public int getTamanhoFrota() {
        return tamanhoFrota;
    }

    public void setTamanhoFrota(int tamanhoFrota) {
        this.tamanhoFrota = tamanhoFrota;
    }

    public int getTamanhoListaEspera() {
        return tamanhoListaEspera;
    }

    public void setTamanhoListaEspera(int tamanhoListaEspera) {
        this.tamanhoListaEspera = tamanhoListaEspera;
    }

    public void setRegistros(Stack<String> registros) {
        this.registros = registros;
    }

    public Filial(String nome) {
        this.Nome = nome;
        this.tamanhoFrota=0;
        this.tamanhoListaEspera=0;
        this.proxima=null;
        this.frota=new Veiculo[10];
        this.listaEspera = new ArrayBlockingQueue<>(10);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Filial getProxima() {
        return proxima;
    }

    public void setProxima(Filial proxima) {
        this.proxima = proxima;
    }

    public Veiculo[] getFrota() {
        return frota;
    }

    public void setFrota(Veiculo[] frota) {
        this.frota = frota;
    }

    public Queue<Cliente> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(Queue<Cliente> listaEspera) {
        this.listaEspera = listaEspera;
    }

    public void OrdenaVeiculos() {
        /* ordena a frota desta filial pelo valor da diária (crescente) */

        Veiculo veiculoAuxiliar = new Veiculo();

        for (int i = 1; i < this.tamanhoFrota; i++) {
            int j = i;
            boolean acabou = false;
            while (this.frota[j].getValorDiaria() < this.frota[j - 1].getValorDiaria() && !acabou) {
                veiculoAuxiliar = this.frota[j - 1];
                this.frota[j - 1] = this.frota[j];
                this.frota[j] = veiculoAuxiliar;
                if (j == 1) {
                    acabou = true;
                } else {
                    j--;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filial)) return false;
        Filial filial = (Filial) o;
        return Objects.equals(getNome(), filial.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    public int getQtdeVeiculosAlugados(){
        int retorno=0;
        for (int i = 1; i < this.tamanhoFrota; i++) {
            if (!frota[i].isVeiculoDisponivel()) {
                retorno++;
            }
        }
        return retorno;
    }
    public double getValorVeiculosAlugados(){
        double retorno=0.0d;
        for (int i = 1; i < this.tamanhoFrota; i++) {
            if (!frota[i].isVeiculoDisponivel()) {
                retorno+=frota[i].getValorDiaria();
            }
        }
        return retorno;
    }
}
