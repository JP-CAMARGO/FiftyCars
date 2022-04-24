package Domain;

import static Utils.Utils.CarregaDadosFilial;

public class ListaFiliais {
    private Filial primeira,ultima;

    public ListaFiliais() {
        this.primeira = null;
        this.ultima = null;
    }

    public Filial getPrimeira() {
        return primeira;
    }

    public void setPrimeira(Filial primeira) {
        this.primeira = primeira;
    }

    public Filial getUltima() {
        return ultima;
    }

    public void setUltima(Filial ultima) {
        this.ultima = ultima;
    }

    public boolean listaVazia(){
        return primeira == null ? true : false;
    }
    public void inserirInicio(String nome) {
        Filial novaFilial = new Filial(nome);

        if(listaVazia()){
            this.ultima = novaFilial;
        } else {
            novaFilial.setProxima(this.primeira);
        }

        this.primeira = novaFilial;
    }

    public void inserirFinal(String nome) {
        Filial novaFilial = new Filial(nome);

        if(listaVazia())
            this.primeira = novaFilial;
        else
            this.ultima.setProxima(novaFilial);

        this.ultima = novaFilial;
    }

    public void remover(String nome){
        Filial estaFilial = this.primeira;
        Filial filialAnterior = null;
        if (primeira.getNome().equals(nome)){
            primeira = primeira.getProxima();
        } else {
            while ((estaFilial != null) && (!estaFilial.getNome().equals(nome))){
                filialAnterior = estaFilial;
                estaFilial = estaFilial.getProxima();
            }
            if (estaFilial != null){
                filialAnterior.setProxima(estaFilial.getProxima());
            }
            if (estaFilial == ultima){
                ultima = filialAnterior;
            }
        }
    }

    public Filial FindFilialByName(String nomeBuscar) {
        Filial filialAtual = new Filial ("");
        filialAtual = this.primeira;
        while (filialAtual!=null){
            if (filialAtual.getNome().equals(nomeBuscar)) {
                return filialAtual;
            }
            filialAtual = filialAtual.getProxima();
        }

        return null;
    }
}
