import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethod {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		// jeito antigo de ordenação e imprimir
		//	Collections.sort(palavras, new ComparadorPorTamanho());
		//	System.out.println(palavras);
		
		// nova forma de ordenar e imprimir
		palavras.sort(new ComparadorPorTamanho());
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		
	}

}

class ImprimeNaLinha implements Consumer<String>{

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			return -1;
		}
		if (s1.length() > s2.length()) {
			return 1;
		}
		return 0;
	}
	
}