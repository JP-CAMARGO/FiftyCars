package View;

import Domain.Filial;
import Domain.ListaFiliais;
import Utils.ConsoleUtils;

import java.util.Locale;

import static Utils.Utils.*;

public class FilialView {
    ListaFiliais fiftyCars;

    public FilialView(ListaFiliais fiftyCars) {
        this.fiftyCars = fiftyCars;
    }

    public boolean MenuPrincipal(){
        String[] options = new String[6];
        StringBuilder sb = new StringBuilder("%n").append("#".repeat(32));
        sb.append( " GRUPO FIFTY CARS - MENU PRINCIPAL ");
        sb.append("#".repeat(33));
        sb.append("%n").append("  F : Listar Todas as Filiais  %n");
        options[0] = "F";
        sb.append("  S : Selecionar uma Filial  %n");
        options[1] = "S";
        sb.append("  A : Adicionar uma Filial  %n");
        options[2] = "A";
        sb.append("  E : Excluir uma Filial  %n");
        options[3] = "E";
        sb.append("  R : Relatório das Filiais  %n");
        options[4] = "R";
        sb.append("  # ").append("# ".repeat(48)).append("%n");
        sb.append("  X : Sair  %n");
        options[5] = "X";
        sb.append("#".repeat(100)).append("%n");

        String opcao = ConsoleUtils.getUserOption(sb.toString(), options).toUpperCase(Locale.getDefault());
        switch (opcao) {
            case "F":
                ListaFiliais();
                break;
            case "S":
                SelecionaFilial();
                break;
            case "A":
                AdicionaFilial();
                break;
            case "E":
                ExcluiFilial();
                break;
            case "R":
                RelatorioFilial();
                break;
            case "X":
                ConsoleUtils.clear();
                System.out.println("Obrigado!!");
                return true;
            default:
                System.out.println("Opção inválida!!!");
        }
        return false;
    }

    public void ListaFiliais(){
        Filial filialAtual = new Filial ("");
        filialAtual = fiftyCars.getPrimeira();
        System.out.println("Relação de Filiais");
        System.out.println("------------------");
        while (filialAtual!=null){
            System.out.println(filialAtual.getNome());
            filialAtual = filialAtual.getProxima();
        }
    }

    public void SelecionaFilial(){
        String nomeFilial = ConsoleUtils.getUserInput("Informe o nome da Filial que quer selecionar : ");
        if (fiftyCars.FindFilialByName(nomeFilial) == null) {
            System.out.println("==>> Filial inexistente!");
        } else {
            boolean fim=false;
            VeiculoView View2 = new VeiculoView(fiftyCars.FindFilialByName(nomeFilial));
            while(!fim) {
                fim = View2.MenuPrincipal();
            }
        }
    }

    public void AdicionaFilial(){
        String nomeFilial = ConsoleUtils.getUserInput("Informe o nome da Filial que quer adicionar : ");
        if (fiftyCars.FindFilialByName(nomeFilial) != null) {
            System.out.println("==>> Essa filial já existe !");
        } else {
            fiftyCars.inserirFinal(nomeFilial);
            System.out.println("Filial " + nomeFilial + " adicionada ao Grupo Fifty Cars !");
            CarregaDadosFilial(fiftyCars.FindFilialByName(nomeFilial));
        }
    }
    public void ExcluiFilial() {
        String nomeFilial = ConsoleUtils.getUserInput("Informe o nome da Filial que quer excluir : ");
        if (fiftyCars.FindFilialByName(nomeFilial) == null) {
            System.out.println("==>> Filial inexistente!");
        } else {
            fiftyCars.remover(nomeFilial);
            System.out.println("Filial " + nomeFilial + " removida do Grupo Fifty Cars :(");
        }
    }

    public void RelatorioFilial(){
        Filial filialAtual = new Filial ("");
        int totalVeiculos=0;
        int totalVeiculosAlugados=0;
        int totalListaEspera=0;
        double totalValorDiarias=0.0d;

        filialAtual = fiftyCars.getPrimeira();
        System.out.println("                         Relatório das Filiais");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Filial           Quantidade de Veículos  Qtde. de  Clientes  Valor total (diárias)");
        System.out.println("                 Total         Alugados  na Lista de Espera   dos carros alugados ");
        System.out.println("---------------  --------      --------  ------------------  ---------------------");

        while (filialAtual!=null){
            System.out.printf("%s  %s      %s  %s  %s\n",
                    Preenche(filialAtual.getNome(),15),
                    FormataInteiro(filialAtual.getTamanhoFrota(),8),
                    FormataInteiro(filialAtual.getQtdeVeiculosAlugados(),8),
                    FormataInteiro(filialAtual.getTamanhoListaEspera(),18),
                    FormataDecimal(filialAtual.getValorVeiculosAlugados(),21));

            totalVeiculos+=filialAtual.getTamanhoFrota();
            totalVeiculosAlugados+=filialAtual.getQtdeVeiculosAlugados();
            totalListaEspera += filialAtual.getTamanhoListaEspera();
            totalValorDiarias += filialAtual.getValorVeiculosAlugados();

            filialAtual = filialAtual.getProxima();
        }
        System.out.println("---------------  --------      --------  ------------------  ---------------------");


            System.out.printf("%s  %s      %s  %s  %s\n",
                    Preenche("TOTAL",15),
                    FormataInteiro(totalVeiculos,8),
                    FormataInteiro(totalVeiculosAlugados,8),
                    FormataInteiro(totalListaEspera,18),
                    FormataDecimal(totalValorDiarias,21));

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();
    }

}
