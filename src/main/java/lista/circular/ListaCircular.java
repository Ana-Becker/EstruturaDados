package lista.circular;

public class ListaCircular <T> {

    private No <T> cabeca;
    private No <T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    private No<T> getNo(int index){
        No <T> noAuxiliar = cauda;                                          // Para começao o loop for com a cauda.

        if (isEmpty() == true)
            throw new IndexOutOfBoundsException ("A lista está vazia");

        if (index == 0){
            return cauda;
        }

        for (int i = 0; i < index; i++ ){
            noAuxiliar = noAuxiliar.getNoProx();                        // Loop for para mostrar o nó do index passado.
        }
        return noAuxiliar;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public void remove(int index){
        if (index >= tamanhoLista){
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista.");
        }

        No <T> noAux = cauda;
        if (index == 0){
            cauda = cauda.getNoProx();
            cabeca.setNoProx(cauda);
        } else if (index == 1) {
            cauda.setNoProx(cauda.getNoProx().getNoProx());                                     // Perde-se a ref. do nó que queremos remover, a JVM a exclui.
        }else {
            for (int i = 0; i < index - 1; i ++){
                noAux = noAux.getNoProx();
            }
            noAux.setNoProx(noAux.getNoProx().getNoProx());
        }
        tamanhoLista --;
    }

    public void add(T conteudo){
        No <T> novoNo = new No<>(conteudo);

        if (isEmpty()){
            cabeca = novoNo;
            cauda = cabeca;
        }else {
            novoNo.setNoProx(cauda);                                                            // O meu novo nó vai apontar p/ a antiga cauda.
            cabeca.setNoProx(novoNo);                                                           // Como o novo nó será a nova cauda, a cabeça apontará p/ ele.
            cauda = novoNo;
        }
        tamanhoLista ++;
    }

    public boolean isEmpty(){
        return tamanhoLista == 0 ? true : false;
    }

    public int size(){
        return tamanhoLista;
    }

    @Override
    public String toString() {
        No <T> noAux = cauda;
        String str = "";

        for (int i = 0; i < size(); i ++){
            str += "[Nó {conteúdo = " + noAux.getConteudo() + "}] ----> ";
            noAux = noAux.getNoProx();
        }

        str += isEmpty() == false ? " (Retorna ao início) " : "[]";
        return str;
    }
}
