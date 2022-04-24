package View;

import Domain.Cliente;
import Domain.Filial;
import Domain.Veiculo;
import Utils.ConsoleUtils;
import Utils.Utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

import static Utils.ConsoleUtils.getUserInput;
import static Utils.Utils.Preenche;

public class VeiculoView {
    Filial filial;
    private Veiculo[] frota;
    Queue<Cliente> listaEspera;
    Stack<String> registros;

    public VeiculoView(Filial filial) {
        this.filial = filial;
        this.frota = filial.getFrota();
        this.listaEspera = filial.getListaEspera();
        this.registros = filial.getRegistros();
    }

    public  boolean MenuPrincipal(){
        String[] options = new String[8];
        String titulo = " MENU DA FILIAL " + filial.getNome() + "  ";
        StringBuilder sb = new StringBuilder("%n").append("#".repeat((100-titulo.length())/2));
        sb.append( titulo );
        sb.append("#".repeat((100-titulo.length())/2));
        sb.append("%n").append("  D : Listar Veículos Disponíveis  %n");
        options[0] = "D";
        sb.append("  T : Listar Todos os Veículos  %n");
        options[1] = "T";
        sb.append("  E : Lista de Espera  %n");
        options[2] = "E";
        sb.append("  A : Alugar Veículo para o próximo cliente na Lista de Espera  %n");
        options[3] = "A";
        sb.append("  R : Retorno de Veículo  %n");
        options[4] = "R";
        sb.append("  V : Alterar valor da diária  %n");
        options[5] = "V";
        sb.append("  H : Descarrega (lista) o histórico de operações  %n");
        options[6] = "H";
        sb.append("  # ").append("# ".repeat(48)).append("%n");
        sb.append("  X : Voltar ao Menu Principal  %n");
        options[7] = "X";
        sb.append("#".repeat(100)).append("%n");

        String opcao = ConsoleUtils.getUserOption(sb.toString(), options).toUpperCase(Locale.getDefault());
        switch (opcao) {
            case "D":
                ListaVeiculos(true);
                break;
            case "T":
                ListaVeiculos(false);
                break;
            case "E":
                MostraListaDeEspera(listaEspera,frota);
                break;
            case "A":
                AlugaVeiculo();
                break;
            case "R":
                RetornaVeiculo();
                break;
            case "V":
                AlteraValorDiaria();
                break;
            case "H":
                ListaRegistros(registros);
                break;
            case "X":
                return true;
            default:
                System.out.println("Opção inválida!!!");
        }
        return false;
    }

    public  void ListaVeiculos(boolean disponivel) {
        /* se disponivel=true, lista só os disponíveis; senão lista todos */
        System.out.println("\nNr.\tMarca           Modelo          Cor        Placa      Diária (R$) Situação");
        System.out.println("---\t--------------- --------------- ---------- ---------- ----------- ---------- ");

        for (int i = 0; i < filial.getTamanhoFrota(); i++) {
            if(!disponivel || frota[i].isVeiculoDisponivel()) {
                System.out.printf("%d\t%s %s %s %s %11.2f %s\n",
                        i+1,
                        Preenche(frota[i].getMarca(),15),
                        Preenche(frota[i].getModelo(),15),
                        Preenche(frota[i].getCor(),10),
                        Preenche(frota[i].getPlaca(),10),
                        frota[i].getValorDiaria(),
                        (frota[i].isVeiculoDisponivel()?"Disponível":"Alugado")
                );
            }
        }
        System.out.println();
    }

    public void AlugaVeiculo(){
        boolean acabou=false;
        while (!acabou){
            System.out.println("O veículo será alugado para o próximo cliente da nossa lista de espera :");
            MostraProximoDaFila(listaEspera);
            String nrVeiculo = ConsoleUtils.getUserInput("Informe o número do veículo a ser alugado, ou deixe em branco para voltar  : ");
            if(nrVeiculo.length()==0) {
                acabou=true;
            } else {
                if (!ConsoleUtils.isNumeric(nrVeiculo)) {
                    System.out.println("Valor inválido - informe um número da lista de veículos disponíveis");
                } else {
                    int index = Integer.valueOf(nrVeiculo);
                    if (index<1 || index>filial.getTamanhoFrota()) {
                        System.out.println("Valor inválido - informe um número da lista de veículos disponíveis");
                    } else {
                        if (!frota[index-1].isVeiculoDisponivel()) {
                            System.out.println("Valor inválido - informe um número da lista de veículos disponíveis");
                        } else {
                            frota[index-1].setVeiculoDisponivel(false);
                            System.out.println("Situação do Veículo alterada para 'Alugado'");
                            frota[index-1].setCliente(listaEspera.peek().getNome());
                            RegistraOperacao(frota[index-1],registros,"ALUGADO PARA");
                            Cliente salvaCliente = new Cliente("","","",null);
                            salvaCliente = listaEspera.remove();
                            // coloca o indivíduo na lista de novo. Só pra não ter que tratar a lista de espera vazia. Prometo que depois eu faço
                            listaEspera.add(salvaCliente);
                            acabou=true;
                        }
                    }
                }
            }

        }
    }

    public void RetornaVeiculo(){
        boolean acabou=false;
        while (!acabou){
            String nrVeiculo = ConsoleUtils.getUserInput("Informe o número do veículo que está retornando, ou deixe em branco para voltar  : ");
            if(nrVeiculo.length()==0) {
                acabou=true;
            } else {
                if (!ConsoleUtils.isNumeric(nrVeiculo)) {
                    System.out.println("Valor inválido - informe um número da lista de veículos onde a situação é 'alugado' ");
                } else {
                    int index = Integer.valueOf(nrVeiculo);
                    if (index<1 || index>10) {
                        System.out.println("Valor inválido - informe um número da lista de veículos onde a situação é 'alugado' ");
                    } else {
                        if (frota[index-1].isVeiculoDisponivel()) {
                            System.out.println("Valor inválido - informe um número da lista de veículos onde a situação é 'alugado' ");
                        } else {
                            frota[index-1].setVeiculoDisponivel(true);
                            System.out.println("Situação do Veículo alterada para 'Disponível'");
                            RegistraOperacao(frota[index-1],registros,"DEVOLVIDO POR");
                            frota[index-1].setCliente("");
                            acabou=true;
                        }
                    }
                }
            }

        }
    }
    public void AlteraValorDiaria(){
        boolean acabou=false;
        boolean indiceValido=false;
        int index=0;
        while (! (acabou || indiceValido)) {
            String nrVeiculo = ConsoleUtils.getUserInput("Informe o número do veículo cuja diária deseja alterar, ou deixe em branco para voltar  : ");
            if (nrVeiculo.length() == 0) {
                acabou = true;
            } else {
                if (!ConsoleUtils.isNumeric(nrVeiculo)) {
                    System.out.println("Valor inválido - informe um número entre 1 e 10");
                } else {
                    index = Integer.valueOf(nrVeiculo);
                    if (index < 1 || index > 10) {
                        System.out.println("Valor inválido - informe um número entre 1 e 10");
                    } else {
                        indiceValido=true;
                    }
                }
            }
        }

        while (!acabou) {
            System.out.printf("O valor atual dessa diária é R$ %7.2f \n",frota[index-1].getValorDiaria());
            String valorDiaria = ConsoleUtils.getUserInput("Informe o novo valor da diária, ou deixe em branco para voltar  : ");
            if(valorDiaria.length()==0) {
                acabou=true;
            } else {
                if (!ConsoleUtils.isNumeric(valorDiaria)) {
                    System.out.println("Valor inválido - informe um número maior do que zero");
                } else {
                    double valDiaria = Double.parseDouble(valorDiaria);
                    if (valDiaria <= 0) {
                        System.out.println("Valor inválido - informe um número maior do que zero");
                    } else {
                        frota[index - 1].setValorDiaria(valDiaria);
                        System.out.println("Valor da Diária alterado!");
                        filial.OrdenaVeiculos();
                        acabou = true;
                    }
                }
            }
        }
    }

    public void MostraListaDeEspera(Queue<Cliente> listaEspera,Veiculo[] veiculos){
        int n = listaEspera.size();
        Cliente salvaCliente = new Cliente("","","",null);
        System.out.println("Lista de Espera :\n\n");
        for (int i= 0; i < n; i++) {
            System.out.printf("%d :\n",i+1);
            MostraProximoDaFila(listaEspera);
            salvaCliente=listaEspera.remove();
            listaEspera.add(salvaCliente);
        }
    }


    public void MostraProximoDaFila(Queue<Cliente> listaEspera){
        String proximo="";

        proximo += "> Nome :" + listaEspera.peek().getNome() + "\n";
        proximo += "> Endereço : " + listaEspera.peek().getEndereco() + "\n";
        proximo += "> Telefone : " + listaEspera.peek().getTelefone() + "\n";
        proximo += "> Carro de Preferência :";
        proximo += " " + listaEspera.peek().getVeiculoDesejado().getMarca();
        proximo += " " + listaEspera.peek().getVeiculoDesejado().getModelo();
        proximo += " " + listaEspera.peek().getVeiculoDesejado().getCor() + "\n";

        System.out.println(proximo);

    }

    public void RegistraOperacao(Veiculo veiculo,Stack<String> registros, String operacao){
        String registro="";

        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        registro += formatter.format(date);
        registro += " : veículo " + veiculo.getMarca() + ", " + veiculo.getModelo() + ", "
                + veiculo.getPlaca()+ " foi "+ operacao + " " + veiculo.getCliente();
        registros.push(registro);
    }

    public void ListaRegistros(Stack<String> registros){

        System.out.println("Histórico de operações (desde a última listagem)");
        System.out.println("------------------------------------------------");

        while (!registros.empty()) {
            System.out.println(registros.pop());
        }
        System.out.println();
    }
}
