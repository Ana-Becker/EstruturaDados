package arvore.binaria;

public class ArvoreBinaria <T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {       // Toda vez que instanciar uma árvore binária, a raiz va ser nula, com os método inserir que vamos colocar nó com conteúdo .
        this.raiz = null;
    }

    public void inserir (T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);

    }

    private BinNo <T> inserir (BinNo<T> atual, BinNo<T> novoNo){        // Método private, da classe.
        if (atual == null){                                             //Se o nó atual estiver nulo, então minha árvore está vazia. Portanto, o novo nó será a raiz.
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
            atual.setNoEsq(inserir(atual.getNoEsq(), novoNo));
        } else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }

        return atual;
    }

    public void exibirInOrdem(){
        System.out.println("\nExibindo InOrdem");
        exibirInOrdem(this.raiz);                                                   //O atual v ai sempre COMEÇAR na raiz
    }

    private void exibirInOrdem(BinNo<T> atual){                                     //Método Recursivo, vai pegando o da esquerda até não ter mais filhos. Pegou o mais a esq, esse vira o atual, printa,
                                                                                    // aí pega o da dir. dele, se for nulo, pega o mais à esq e assim vai
        if (atual != null){
            exibirInOrdem(atual.getNoEsq());                                        // O método chama ele mesmo (recursivo) - ele primeiro pega o nó mais à esq., mostra qual é e ele vira o atual
            System.out.print(atual.getConteudo() + ", ");                         //
            exibirInOrdem(atual.getNoDir());
        }
    }

    public void exibirPosOrdem(){
        System.out.println("\nExibindo PosOrdem");
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrdem(){
        System.out.println("\nExibindo PreOrdem");
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    public void remover(T conteudo){                                    //Passar o conteúdo do nó que queremos remover da árvore
        try {
            BinNo <T> atual = this.raiz;
            BinNo <T> pai = null;
            BinNo <T> filho = null;
            BinNo <T> aux = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){      //loop p/ achar o 1º nó q possui o conteúdo passado no método, o que tem de ser removido, a não ser que ele seja a raiz ou não exista.

                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0){               //comparar o conteúdo passado com o atual, que é a raiz
                    atual = atual.getNoEsq();
                } else {
                    atual = atual.getNoDir();
                }

            }

            if (pai == null){                                                   //p/ o caso de estarmos na raiz, o nó pai é nulo pois o conteudo comparado = conteudo do atual, não passou pelo while.
                if (atual.getNoDir() == null){                                  // se não tiver nó à dir., o nó á esq. vira a raiz
                    this.raiz = atual.getNoEsq();
                } else if (atual.getNoEsq() == null) {
                    this.raiz = atual.getNoDir();
                } else {
                    for (
                            aux = atual, filho = atual.getNoEsq();
                            filho.getNoDir() != null;
                            aux = filho, filho = filho.getNoEsq()
                    ){
                        if (filho != atual.getNoEsq()){
                            aux.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }

            } else if (atual.getNoDir() == null) {
                if (pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoEsq());
                }else {
                    pai.setNoDir(atual.getNoEsq());
                }

            } else if (atual.getNoEsq() == null) {
                if (pai.getNoEsq() == atual){
                    pai.setNoEsq(atual.getNoDir());
                }else {
                    pai.setNoDir(atual.getNoDir());
                }

            } else {
                for (
                        aux = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;                   // faça o laço até isso
                        aux = filho, filho = filho.getNoDir()       // vai fazendo isso até não chegar na condição acima
                ){
                    if (filho != atual.getNoEsq()){
                        aux.setNoDir(filho.getNoEsq());
                        filho.setNoEsq(atual.getNoEsq());
                    }
                    filho.setNoDir(atual.getNoDir());               // o nó direito do filho vai virar o nó direito do nó que será removido.
                    if (pai.getNoEsq() == atual){
                        pai.setNoEsq(filho);
                    }else {
                        pai.setNoDir(filho);
                    }

                }

            }

            if (atual == null){
                System.out.println("Não há nada para remover");
            }

        }catch (NullPointerException erro){
            System.out.println("Não há nada para remover");
        }

    }
}
