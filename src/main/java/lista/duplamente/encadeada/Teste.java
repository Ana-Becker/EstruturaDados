package lista.duplamente.encadeada;

public class Teste {
    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> minhaListaDupla = new ListaDuplamenteEncadeada<>();

        minhaListaDupla.add("Teste 1");
        minhaListaDupla.add("Teste 2");
        minhaListaDupla.add("Teste 3");

        System.out.println(minhaListaDupla);

        minhaListaDupla.add(2, "Teste 4");
        minhaListaDupla.add("Teste 5");
        minhaListaDupla.add("Teste 6");

        System.out.println(minhaListaDupla);

        minhaListaDupla.remove(2);

        System.out.println(minhaListaDupla);

        minhaListaDupla.add(3, "Teste 4");

        System.out.println(minhaListaDupla);

        minhaListaDupla.remove(5);

        System.out.println(minhaListaDupla);
        System.out.println(minhaListaDupla.size());
        System.out.println(minhaListaDupla.get(2));
    }
}
