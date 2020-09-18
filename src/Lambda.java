import java.util.ArrayList;
import java.util.List;

public class Lambda {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		palavras.sort((s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});
		palavras.forEach(palavra -> {
			System.out.println(palavra);
		});
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.forEach(palavra -> System.out.println(palavra));

	}

}