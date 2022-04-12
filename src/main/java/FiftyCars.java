import Domain.Veiculo;
import Domain.Cliente;
import Utils.Utils;
import View.VeiculoView;
import Utils.ConsoleUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FiftyCars {

    public static void main(String[] args) {

        Veiculo[] veiculos = new Veiculo[10];

        Queue<Cliente> clientes = new ArrayBlockingQueue<>(6);

        Stack<String> registros = new Stack<String>();

        veiculos = Utils.CarregaVeiculos(veiculos);
        veiculos = Utils.OrdenaVeiculos(veiculos);

        clientes = Utils.CarregaClientes(clientes);

        boolean fim=false;
        VeiculoView view = new VeiculoView(veiculos,clientes,registros);
        while(!fim) {
            fim = view.MenuPrincipal();
        }
    }

}
