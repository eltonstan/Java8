import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class Stream {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		int soma = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .sum();
		System.out.println(soma);
		
		Optional<Curso> optionalCurso = cursos.stream()
		   .filter(c -> c.getAlunos() >= 100)
		   .findAny();
		
		
		Curso curso = optionalCurso.orElse(null);
		System.out.println("Optional");
		System.out.println(curso.getNome());
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		if (optionalCurso.isPresent()) {
			Curso curso2 = optionalCurso.get();
			System.out.println(curso2.getNome());
		}
		
		cursos.stream()
		   .filter(c -> c.getAlunos() >= 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c.getNome()));
		
		OptionalDouble average = cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .mapToInt(Curso::getAlunos)
				   .average();
		average.ifPresent(c -> System.out.println(c));
		
		List<Curso> listResultado = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		listResultado.stream()
		   .forEach(c -> System.out.println(c.getNome()));
		
		Map<String, Integer> map = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(), 
					c -> c.getAlunos()));
		System.out.println(map);
		
		map.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
}