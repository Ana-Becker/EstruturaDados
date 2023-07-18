package lista.circular;

public class Teste {
    public static void main(String[] args) {

        ListaCircular<String> minhaListaCircular = new ListaCircular<>();

        minhaListaCircular.add("Teste 1");
        minhaListaCircular.add("Teste 2");
        minhaListaCircular.add("Teste 3");
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(2);
        System.out.println(minhaListaCircular);

        minhaListaCircular.remove(1);
        minhaListaCircular.remove(0);
        System.out.println(minhaListaCircular);
        System.out.println(minhaListaCircular.isEmpty());

        minhaListaCircular.add("Teste 0");
        minhaListaCircular.add("Teste 1");
        minhaListaCircular.add("Teste 2");
        System.out.println(minhaListaCircular);

        System.out.println(minhaListaCircular.isEmpty());
        System.out.println(minhaListaCircular.get(2));
        System.out.println(minhaListaCircular.get(1));
        System.out.println(minhaListaCircular.size());
    }
}
