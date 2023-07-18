package lista.duplamente.encadeada;

public class NoDuplo <T> {

    private T conteudo;                    // Criada a classe NoDuplo, onde temos o conteúdo do nó, a referência p/ o nó posterior e a ref. p/ o nó anterior.
    private NoDuplo <T> noProximo;
    private NoDuplo <T> noPrevio;

    public NoDuplo(T conteudo) {

        this.conteudo = conteudo;
    }

    public T getConteudo() {

        return conteudo;
    }

    public void setConteudo(T conteudo) {

        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoProximo() {

        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {

        this.noProximo = noProximo;
    }

    public NoDuplo<T> getNoPrevio() {

        return noPrevio;
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {

        this.noPrevio = noPrevio;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
