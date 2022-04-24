package Utils;

import Domain.Cliente;
import Domain.Filial;
import Domain.Veiculo;

import java.text.DecimalFormat;
import java.util.Queue;

public class Utils {

    public static void CarregaDadosFilial(Filial filial){

        CarregaVeiculos(filial);
        filial.OrdenaVeiculos();
        CarregaClientes(filial);
    }

    public static String Preenche(String str,int tamanho) {
        return str + " ".repeat(tamanho-str.length());
    }

    public static String FormataInteiro(int numero,int tamanho) {
        String retorno = new DecimalFormat("0").format(numero);
        return " ".repeat(tamanho-retorno.length()) + retorno;
    }
    public static String FormataDecimal(double numero,int tamanho) {
        String retorno = new DecimalFormat("0.00").format(numero);
        return " ".repeat(tamanho-retorno.length()) + retorno;
    }

    public static void CarregaVeiculos(Filial filial){
        /* inicializa o array frota em cada filial de Fifty Cars com 10 veículos */
        Veiculo[] frota = new Veiculo[10];
        switch (filial.getNome()){
            case "Diadema" :
                filial.setTamanhoFrota(5);
                frota[0] = new Veiculo("AAA-0000","VW","Preta","Fusca",50);
                frota[1] = new Veiculo("BBB-1111","FORD","Prata","Fiesta",74);
                frota[2] = new Veiculo("CCC-2222","GM","Grafite","Chevette",35);
                frota[3] = new Veiculo("DDD-3333","FIAT","Vermelha","147",41);
                frota[4] = new Veiculo("EEE-4444","GURGEL","Cinza","BR-800",60);
                break;
            case "Paris" :
                filial.setTamanhoFrota(7);
                frota[0] = new Veiculo("AAA-0000","CITROEN","Preta","C5",230);
                frota[1] = new Veiculo("BBB-1111","RENAULT","Prata","MEGANE",210);
                frota[2] = new Veiculo("CCC-2222","PEUGEOT","Grafite","307 SEDAN",320);
                frota[3] = new Veiculo("DDD-3333","FORD","Vermelha","MUSTANG",350);
                frota[4] = new Veiculo("EEE-4444","McLAREN","Cinza","350",380);
                frota[5] = new Veiculo("FFF-5555","FIAT","Amarela","500",310);
                frota[6] = new Veiculo("GGG-6666","RENAULT","Verde","SCENIC",290);
                break;
            case "Viena" :
                filial.setTamanhoFrota(9);
                frota[0] = new Veiculo("AAA-0000","BMW","Preta","X3",230);
                frota[1] = new Veiculo("BBB-1111","VOLVO","Prata","C60",210);
                frota[2] = new Veiculo("CCC-2222","MERCEDES-BENZ","Grafite","AMG GT",320);
                frota[3] = new Veiculo("DDD-3333","FERRARI","Vermelha","458 ITALIA",350);
                frota[4] = new Veiculo("EEE-4444","BUGATTI","Cinza","VEYRON",380);
                frota[5] = new Veiculo("FFF-5555","LAMBORGHINI","Amarela","AVENTATOR V12",310);
                frota[6] = new Veiculo("GGG-6666","JAGUAR","Verde","XK 120",290);
                frota[7] = new Veiculo("HHH-7777","AUDI","Prata","R8",280);
                frota[8] = new Veiculo("III-8888","ASTON MARTIN","Branco","V12 VANTAGE S",330);
                break;
            case "Dubai" :
                filial.setTamanhoFrota(10);
                frota[0] = new Veiculo("AAA-0000","BMW","Preta","X4",230);
                frota[1] = new Veiculo("BBB-1111","VOLVO","Prata","C60",210);
                frota[2] = new Veiculo("CCC-2222","MERCEDES-BENZ","Grafite","AMG GT",320);
                frota[3] = new Veiculo("DDD-3333","FERRARI","Vermelha","458 ITALIA",350);
                frota[4] = new Veiculo("EEE-4444","BUGATTI","Cinza","VEYRON",380);
                frota[5] = new Veiculo("FFF-5555","LAMBORGHINI","Amarela","AVENTATOR V12",310);
                frota[6] = new Veiculo("GGG-6666","JAGUAR","Verde","XK 120",290);
                frota[7] = new Veiculo("HHH-7777","AUDI","Prata","R8",280);
                frota[8] = new Veiculo("III-8888","ASTON MARTIN","Branco","V12 VANTAGE S",330);
                frota[9] = new Veiculo("JJJ-9999","ROLLS ROYCE","Preto","HYPERIOS",510.01);
                break;
            case "Perus" :
                filial.setTamanhoFrota(6);
                frota[5] = new Veiculo("AAA-0000","VW","Preta","Fusca",50);
                frota[4] = new Veiculo("BBB-1111","FORD","Prata","Fiesta",74);
                frota[3] = new Veiculo("CCC-2222","GM","Azul","Chevette",35);
                frota[2] = new Veiculo("DDD-3333","FIAT","Vermelha","147",41);
                frota[1] = new Veiculo("EEE-4444","GURGEL","Cinza","BR-800",60);
                frota[0] = new Veiculo("FFF-5555","VW","Amarela","Brasília",310);
                break;
            default :
                filial.setTamanhoFrota(10);
                frota[0] = new Veiculo("AAA-0000","BMW","Preta","X6",230);
                frota[1] = new Veiculo("BBB-1111","VOLVO","Prata","C60",210);
                frota[2] = new Veiculo("CCC-2222","MERCEDES-BENZ","Grafite","AMG GT",320);
                frota[3] = new Veiculo("DDD-3333","FERRARI","Vermelha","458 ITALIA",350);
                frota[4] = new Veiculo("EEE-4444","BUGATTI","Cinza","VEYRON",380);
                frota[5] = new Veiculo("FFF-5555","LAMBORGHINI","Amarela","AVENTATOR V12",310);
                frota[6] = new Veiculo("GGG-6666","JAGUAR","Verde","XK 120",290);
                frota[7] = new Veiculo("HHH-7777","AUDI","Prata","R8",280);
                frota[8] = new Veiculo("III-8888","ASTON MARTIN","Branco","V12 VANTAGE S",330);
                frota[9] = new Veiculo("JJJ-9999","ROLLS ROYCE","Preto","HYPERIOS",510.01);
        }
        filial.setFrota(frota);
    }



    public static void CarregaClientes(Filial filial){

        Queue<Cliente> listaEspera;
        listaEspera = filial.getListaEspera();
        Veiculo[] frota = new Veiculo[10];
        frota = filial.getFrota();

        switch (filial.getNome()) {
            case "Diadema":
                filial.setTamanhoListaEspera(4);
                listaEspera.add(new Cliente("Juca Brito", "31-5349-3739", "Estrada do Corvo, s/n", frota[0]));
                listaEspera.add(new Cliente("Arlindo Orlando", "41-5669-6669", "Rua da Matriz, 05", frota[1]));
                listaEspera.add(new Cliente("Passos Dias Aguiar", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[2]));
                listaEspera.add(new Cliente("Maria das Dores", "11-99988-7766", "Av. Diademense, 254", frota[3]));
                break;
            case "Paris":
                filial.setTamanhoListaEspera(6);
                listaEspera.add(new Cliente("Jean-Pierre Tran", "31-5349-3739", "Estrada do Corvo, s/n", frota[1]));
                listaEspera.add(new Cliente("Nicolas Legrans", "41-5669-6669", "Rua da Matriz, 05", frota[4]));
                listaEspera.add(new Cliente("Emannuel Macron", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[3]));
                listaEspera.add(new Cliente("Dominique Nique", "22-5339-33333", "Rua Venida Lameda,24", frota[2]));
                listaEspera.add(new Cliente("Edwiges Lafont", "91-2544-3299", "Praça do Correio, 2", frota[6]));
                listaEspera.add(new Cliente("Louis Charles", "11-1234-8756", "Beco do Cachorro Molhado, casa 3, 3o andar, fundos", frota[5]));
                break;
            case "Viena":
                filial.setTamanhoListaEspera(3);
                listaEspera.add(new Cliente("Hanz Fritz", "31-5349-3739", "Estrada do Corvo, s/n", frota[2]));
                listaEspera.add(new Cliente("Johann Sebastião", "41-5669-6669", "Rua da Matriz, 05", frota[4]));
                listaEspera.add(new Cliente("Grettel Gretchen", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[7]));
                break;
            case "Dubai":
                filial.setTamanhoListaEspera(3);
                listaEspera.add(new Cliente("Yussef Abdul", "31-5349-3739", "Estrada do Corvo, s/n", frota[7]));
                listaEspera.add(new Cliente("Mohammed Ali", "41-5669-6669", "Rua da Matriz, 05", frota[4]));
                listaEspera.add(new Cliente("Mustafá Lido", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[7]));
                break;
            case "Perus":
                filial.setTamanhoListaEspera(5);
                listaEspera.add(new Cliente("Joca Brito", "31-5349-3739", "Estrada do Corvo, s/n", frota[3]));
                listaEspera.add(new Cliente("Arlindo Orlando", "41-5669-6669", "Rua da Matriz, 05", frota[4]));
                listaEspera.add(new Cliente("Passos Dias Aguiar", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[5]));
                listaEspera.add(new Cliente("Melissa Peka", "22-5339-33333", "Rua Venida Lameda,24", frota[0]));
                listaEspera.add(new Cliente("Telma Neira", "91-2544-3299", "Praça do Correio, 2", frota[2]));
                break;
            default:
                filial.setTamanhoListaEspera(6);
                listaEspera.add(new Cliente("Jica Brito", "31-5349-3739", "Estrada do Corvo, s/n", frota[7]));
                listaEspera.add(new Cliente("Arlindo Orlando", "41-5669-6669", "Rua da Matriz, 05", frota[4]));
                listaEspera.add(new Cliente("Passos Dias Aguiar", "11-99988-7766", "Av. Paulista, 1001 1o andar", frota[7]));
                listaEspera.add(new Cliente("Melissa Peka", "22-5339-33333", "Rua Venida Lameda,24", frota[1]));
                listaEspera.add(new Cliente("Telma Neira", "91-2544-3299", "Praça do Correio, 2", frota[9]));
                listaEspera.add(new Cliente("Foobar Beiro", "11-1234-8756", "Beco do Cachorro Molhado, casa 3, 3o andar, fundos", frota[5]));
                break;
        }

    }
}
