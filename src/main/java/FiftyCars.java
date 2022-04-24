import Domain.Filial;
import Domain.ListaFiliais;
import Domain.Veiculo;
import Domain.Cliente;
import Utils.Utils;
import View.FilialView;
import View.VeiculoView;
import Utils.ConsoleUtils;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static Utils.Utils.CarregaDadosFilial;

public class FiftyCars {

    public static void main(String[] args) {

        // as filiais do grupo Fifty Cars ficarão numa lista encadeada :
        ListaFiliais fiftyCars = new ListaFiliais();

        // vou criar 5 filiais e preencher frotas e listas de espera, para testar o programa
        fiftyCars.inserirInicio("Dubai");
        fiftyCars.inserirFinal("Viena");
        fiftyCars.inserirFinal("Paris");
        fiftyCars.inserirInicio("Perus");
        fiftyCars.inserirInicio("Diadema");
        // a lista vai ficar na ordem : Diadema-Perus-Dubai-Viena-Paris
        // carrega dados para cada filial :
        Filial filialAtual = new Filial ("");
        filialAtual = fiftyCars.getPrimeira();
        while (filialAtual!=null){
            CarregaDadosFilial(filialAtual);
            filialAtual = filialAtual.getProxima();
        }

        // chama o menu principal
        boolean fim=false;
        FilialView view = new FilialView(fiftyCars);
        while(!fim) {
            fim = view.MenuPrincipal();
        }
    }

}
