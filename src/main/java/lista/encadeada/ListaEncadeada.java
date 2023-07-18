package lista.encadeada;

public class ListaEncadeada <T> {

    No <T> referenciaEntrada;

    public ListaEncadeada() {

        this.referenciaEntrada = null;
    }

    public void add(T conteudo){                            //Método add -> adicionar um nó na nossa lista.
        No<T> novoNo = new No<T>(conteudo);

        if (this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No <T> noAuxiliar = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        noAuxiliar.setProximoNo(novoNo);
    }

    public T get(int index){                                // Para obter o conteúdo, a info do nó e não ele, que é no getNo.

        return getNo(index).getConteudo();

    }

    private No <T> getNo(int index){                         // Ele é private pois é um método interno da classe. Foi passado um index
                                                             // p/ colocarmos a posição que queremos adicionar o nó.
        No <T> noAuxiliar = referenciaEntrada;
        No <T> noRetorno = null;

        validaIndice(index);

        for (int i = 0; i <= index; i++){                   //Laço (for) igual ao do método add só que guarda-se
                                                            // o "noRetorno" antes da passagem p/ o prox. nó
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noRetorno;

    }

    public T remove(int index){                           // Passamos o índice do nó que queremos remover.
        No<T> noPivot = this.getNo(index);                // getNo (pegar o nó) do índice que foi passado.

        if (index == 0 ){
            referenciaEntrada = noPivot.getProximoNo();   // O nó de índice 0, ou seja, o primeiro nó da lista,
                                                          // será o próximo nó, pois removemos o que estava no index 0.
                                                          // Portanto, o novo nó de index 0 será o que antes estava como Próximo Nó.
            return noPivot.getConteudo();                 // Retorna o conteúdo do novo nó.
        }

        No<T> noAnterior = getNo(index - 1);        // Criado o noAnterior, que é o antes do index passado. Ex: escolhemos o index 1, o noAnterior será o de index 0.
        noAnterior.setProximoNo(noPivot.getProximoNo());  // Setei que o próx nó do nó anterior (index 0) seja o próx
                                                          // nó do nó pivot, ou seja, o nó de index 2.
        return noPivot.getConteudo();

    }

    public int size (){
        int tamanhoLista = 0;
        No <T> referenciaAux = referenciaEntrada;

        while (true){
            if (referenciaAux != null){
                tamanhoLista ++;

                if (referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();

                }else {
                    break;
                }

            }else {
                break;
            }
        }

        return tamanhoLista;
    }

    public void validaIndice(int index){
        if (index >= size()){
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não Existe conteúdo no índice " + index + " desta lista. " +
                    "Esta lista só vai até o índice " + ultimoIndice);
        }
    }

    public boolean isEmpty(){

        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;                                       // Criado um nó auxiliar que é a ref de entrada.

        for (int i = 0; i < this.size(); i++){                                      // Laço para correr a lista e mostrá-la inteira:
            strRetorno += "[Nó {conteúdo = " + noAuxiliar.getConteudo() + "} ----> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null.";                                                      // O último nó sempre vai apontar para nulo.
        return strRetorno;
    }
                                                                                    // Ao percorrer a lista, o nó aux será sempre o da frente
                                                                                    // dele, até terminar o size(tamanho) da lista.
}
