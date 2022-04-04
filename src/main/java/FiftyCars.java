import Domain.Veiculo;
import Utils.Utils;
import View.VeiculoView;
import Utils.ConsoleUtils;

import java.util.Locale;

public class FiftyCars {

    public static void main(String[] args) {

        Veiculo[] veiculos = new Veiculo[10];

        veiculos = Utils.CarregaVeiculos(veiculos);
        veiculos = Utils.OrdenaVeiculos(veiculos);

        boolean fim=false;
        VeiculoView view = new VeiculoView(veiculos);
        while(!fim) {
            fim = view.MenuPrincipal();
        }
    }



}
