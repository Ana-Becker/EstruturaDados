package lista.circular;

public class No <T> {

    private T conteudo;
    private No <T> noProx;

    public No() {
    }

    public No(T conteudo) {
        this.noProx = null;                  // Quando fizer o 1º nó, a ref dele será null
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getNoProx() {
        return noProx;
    }

    public void setNoProx(No<T> noProx) {
        this.noProx = noProx;
    }

    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }
}
