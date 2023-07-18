package pilha;

public class Pilha {

    private No refNoEntradaPilha; //referência de entrada da pilha, aquele pequeno que vimos na aula.

    public Pilha() {

        this.refNoEntradaPilha = null; //Essa "referênciazinha é nula, chega nula no nosso nó
    }

    public void push(No novoNo){                      //Empurrar, receber um novo nó.
        No refAuxiliar = refNoEntradaPilha;           //Vamos guardar esta referência de entrada.
        refNoEntradaPilha = novoNo;                   //A referência de entrada da pilha (primeiro nó da pilha)
        // agora é o novo nó.
        refNoEntradaPilha.setRefNo(refAuxiliar);      //A referência deste novo nó é o antigo nó (refAuxiliar).
    }

    public No pop(){
        if (!this.isEmpty()){
            No noPopped = refNoEntradaPilha;                   //Criado esse novo Nó Popped, que vai sair, que
            //é o mais acima.
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();  //Agora o mais acima vai virar a "referenciazinha"
            return noPopped;
        }

        return null;
    }

    public No top(){
        return refNoEntradaPilha;  //Mostra o nó que está no topo.
    }

    public boolean isEmpty(){
//       if (refNoEntradaPilha == null){
//           return true;
//       }
//       return false;
        return refNoEntradaPilha == null ? true:false;
    }

    @Override
    public String toString() {

        String retorno = "----------------\n";
        retorno += "    Pilha    \n";
        retorno += "----------------\n";

        No noAuxiliar = refNoEntradaPilha;                    //É o nó que utilizaremos para percorrer a pilha e
        // a printar para a gente. Para percorrer,
        // usar um laço.
        while (true)  {
            if (noAuxiliar != null){
                retorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";  //o primeiro nó, topo da pilha.
                noAuxiliar = noAuxiliar.getRefNo();                      //o segundo nó da pilha, depois do topo.
                                                                         // O segundo nó tem como referência o primeiro,
                                                                         // o que está no topo da pilha.

            }else {
                break;
            }
        }
        retorno += "================\n";
        return retorno;

    }
}
