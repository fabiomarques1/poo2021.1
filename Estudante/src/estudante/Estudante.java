package estudante;

public class Estudante {
	private String nome;
	private double nota1;
	private double nota2;
	
	public Estudante() {

	}

	public Estudante(String n, double n1, double n2) {
		this.nome = n;
		this.nota1 = n1;
		this.nota2 = n2;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double media() { // Calcula a média aritmética
		return (this.nota1 + this.nota2) / 2;
	}
	
	public String resultado(double mediaAprovacao) { //Mostra se foi aprovado a partir da nota mínima
		
		if (this.media() >= mediaAprovacao) {
			return "Aprovado";
		} else {
			return "Reprovado";
		}
	}
	
	
}
