package lista.duplamente.encadeada;

import fila.No;

public class ListaDuplamenteEncadeada <T> {

    private NoDuplo <T> primeiroNo;
    private NoDuplo <T> ultimoNo;

    private int tamanhoLista = 0;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    private NoDuplo<T> getNo (int index){
        NoDuplo<T> noAuxiliar = primeiroNo;

        for (int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);

        if (primeiroNo == null){
            primeiroNo = novoNo;
        }
        if (ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }

        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);               // Nó do index que passei.
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);                    // O nó que será adicionado terá como próximo o do index passado.

        if (novoNo.getNoProximo() != null){
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());   // Agora o nó prévio do auxiliar será o prévio do novo nó.
            novoNo.getNoProximo().setNoPrevio(novoNo);      // Agora tb, o nó prévio do auxiliar passará a ser o prévio do novo nó.
        }else {
            novoNo.setNoPrevio(ultimoNo);                   // Se não nulo, esse novo nó será o último da lista, portanto o anterior a ele será o antigo último.
            ultimoNo = novoNo;                              // E agora o novo nó tomará o lugar de último da lista.
        }

        if (index == 0){                                    // Se o índice for 0, o novo Nó será o primeiro da lista.
            primeiroNo = novoNo;
        }else {
            novoNo.getNoPrevio().setNoProximo(novoNo);      // P/ qqer outro índice, o próximo nó do prévio do novo será o novo.
        }

        tamanhoLista++;
    }

    public void remove(int index){
        NoDuplo<T> noAuxiliar = getNo(index);
        if (index == 0){
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null){                                                // Precisamos conferir se o 2º nó da lista, que vai virar o 1º não estava nulo.
                primeiroNo.setNoPrevio(null);                                       // Pois se ele não for  nulo, temos que dizer q o prévio é nulo.
            }
        }else {
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());       // O próx nó do prévio dele será o próx. dele.
            if (noAuxiliar != ultimoNo){
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());    // Se o nó auxiliar não for o último, então o próx nó do aux terá como prévio o prévio do aux. Assim retira-se a ref. desse nó aux e a JVM limpa ele.

            }else {
                ultimoNo = noAuxiliar;                                              // O último é nulo.
            }
        }

        this.tamanhoLista --;

    }

    public int size (){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        NoDuplo<T> noAuxiliar = primeiroNo;
        String str = "";

        for (int i = 0; i < size(); i++ ){
            str += "[Nó {conteudo = " + noAuxiliar.getConteudo() + "}] ----> ";
            noAuxiliar = noAuxiliar.getNoProximo();
        }

        str += "null";
        return str;
    }
}
