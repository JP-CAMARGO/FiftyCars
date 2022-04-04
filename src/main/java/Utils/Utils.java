package Utils;

import Domain.Veiculo;

public class Utils {

    public static Veiculo[] CarregaVeiculos(Veiculo[] veiculos){
        /* inicializa o array veiculos com os 10 veículos da frota de Fifty Cars */
        for (int i = 0; i < 10; i++) {
            veiculos[i] = new Veiculo();
            veiculos[i].setVeiculoDisponivel(true);
            veiculos[i].setValorDiaria(200-i*10);
        }

        veiculos[0].setPlaca("AAA-0000");
        veiculos[1].setPlaca("BBB-1111");
        veiculos[2].setPlaca("CCC-2222");
        veiculos[3].setPlaca("DDD-3333");
        veiculos[4].setPlaca("EEE-4444");
        veiculos[5].setPlaca("FFF-5555");
        veiculos[6].setPlaca("GGG-6666");
        veiculos[7].setPlaca("HHH-7777");
        veiculos[8].setPlaca("III-8888");
        veiculos[9].setPlaca("JJJ-9999");

        veiculos[0].setCor("Branco");
        veiculos[1].setCor("Prata");
        veiculos[2].setCor("Preto");
        veiculos[3].setCor("Vermelho");
        veiculos[4].setCor("Azul");
        veiculos[5].setCor("Verde");
        veiculos[6].setCor("Branco");
        veiculos[7].setCor("Prata");
        veiculos[8].setCor("Preto");
        veiculos[9].setCor("Branco");

        veiculos[0].setMarca("Toyota");
        veiculos[1].setMarca("Fiat");
        veiculos[2].setMarca("Renault");
        veiculos[3].setMarca("Ford");
        veiculos[4].setMarca("GM");
        veiculos[5].setMarca("Honda");
        veiculos[6].setMarca("VW");
        veiculos[7].setMarca("Fiat");
        veiculos[8].setMarca("Honda");
        veiculos[9].setMarca("VW");

        veiculos[0].setModelo("Corolla");
        veiculos[1].setModelo("Palio");
        veiculos[2].setModelo("Sandero");
        veiculos[3].setModelo("Focus");
        veiculos[4].setModelo("Prisma");
        veiculos[5].setModelo("Fit");
        veiculos[6].setModelo("Gol");
        veiculos[7].setModelo("Siena");
        veiculos[8].setModelo("Civic");
        veiculos[9].setModelo("Jetta");

        return veiculos;
    }

    public static Veiculo[] OrdenaVeiculos(Veiculo[] veiculos) {
        /* ordena o array veiculos pelo valor da diária (crescente) */

        Veiculo veiculoAuxiliar = new Veiculo();

        for (int i = 1; i < 10; i++) {
            int j=i;
            boolean acabou=false;
            while(veiculos[j].getValorDiaria()<veiculos[j-1].getValorDiaria() && !acabou) {
                veiculoAuxiliar = veiculos[j - 1];
                veiculos[j - 1] = veiculos[j];
                veiculos[j]=veiculoAuxiliar;
                if(j==1) {
                    acabou=true;
                } else {
                    j--;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            veiculos[i].setIndex(i);
        }
        return veiculos;
    }

    public static String Preenche(String str,int tamanho) {
        return str + " ".repeat(tamanho-str.length());
    }
}
