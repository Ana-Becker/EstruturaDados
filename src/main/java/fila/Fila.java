package fila;

public class Fila <T> {

    private No <T> refNoEntradaFila;  //Um novo nó que vai entrar na fila

    public Fila() {
    }

    public Fila(No <T> refNoEntradaFila) {
        this.refNoEntradaFila = null;   //Quando eu for instanciar a minha ref de fila, quero ela vazia
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);  //A ref do novo nó será o nó de entrada, o primeiro.
        refNoEntradaFila = novoNo;        //Agora a ref virou o novo nó, o último da fila.
    }

    public T first(){
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;  //Caso tenha apenas um nó na fila, ele será o de entrada.
            while (true){
                if (primeiroNo.getRefNo() != null){   //Se a ref do nó não for nula, ele não é o único.
                    primeiroNo = primeiroNo.getRefNo();  //Esse meu primeiro nó passa a ser o nó da frente
                    // dele, até chegar no primeiro da fila
                    // que tem como ref null, aí quebra o loop e mostra o
                    // primeiro da fila.
                }else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue(){
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true){
                if (primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;   //O nó auxiliar vira o anterior ao primeiro.
                    primeiroNo = primeiroNo.getRefNo();

                }else {
                    noAuxiliar.setRefNo(null);  //fiz o auxiliar virar o primeiro da fila.
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = " ";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null){

            while (true){
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if (noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += null;
                    break;
                }

            }
        } else {
            stringRetorno = null;
        }

        return stringRetorno;
    }
}
