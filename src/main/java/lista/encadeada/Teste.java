package lista.encadeada;

public class Teste {

    public static void main(String[] args) {

        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();    // Declarada a nova lista de String (Generics).

        minhaListaEncadeada.add("Teste 1");
        minhaListaEncadeada.add("Teste 2");
        minhaListaEncadeada.add("Teste 3");
        minhaListaEncadeada.add("Teste 4");

        System.out.println(minhaListaEncadeada.get(0));

        System.out.println(minhaListaEncadeada);

        System.out.println(minhaListaEncadeada.remove(2));

        System.out.println(minhaListaEncadeada);
    }
}
