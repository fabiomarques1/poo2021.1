import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class Voo {
	
	private int numeroVoo;
	private Date data;
	private boolean vaga[];
	
	public int getNumeroVoo() {
		return numeroVoo;
	}
	
	public void setNumeroVoo(int numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean[] getVaga() {
		return vaga;
	}

	public void setVaga(boolean[] vaga) {
		this.vaga = vaga;
	}

	public Voo(int numeroVoo) {

		this.numeroVoo = numeroVoo;
		this.data = new Date();
		this.vaga = new boolean[100];
		for (int i=0; i<this.vaga.length; i++) {
			this.vaga[i] = true;
		}
		
	}
	
	public int verifica(int assento) {
		if (assento >= 0 && assento < this.vaga.length) {
			if (this.vaga[assento]) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 2;
		}
	}
	
	public boolean ocupa(int assento) {
		if (assento >= 0 && assento < this.vaga.length) {
			if (this.vaga[assento]) {
				this.vaga[assento] = false;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	public int vagas() {
		
		int cont = 0;
		for (int i=0; i<this.vaga.length; i++) {
			if (this.vaga[i]) {
				cont++;
			}
		}
		return cont;
		
	}
	
	public int getVoo () {
		return this.numeroVoo;
	}
	
	public Voo clona() {
		Voo clone = new Voo(this.numeroVoo);
		clone.data = this.data;
		clone.vaga = this.vaga;
		return clone;
	}

	@Override
	public String toString() {
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		return "Voo [numeroVoo=" + numeroVoo + ", data=" + dtHora.format(data) + "]";
	}
	

}


//Questão 2: Escreva uma classe em que cada objeto representa um vôo que acontece em determinada data e em determinado horário. 
//Cada vôo possui no máximo 100 passageiros, e a classe permite controlar a ocupação das vagas. A classe deve ter os seguintes métodos: 
//
//construtor 
//configura os dados do vôo (recebidos como parâmetro): número do vôo, data (para armazenar a data utilize um objeto da classe Data
//
//
//verifica 
//verifica se o número da cadeira recebido como parâmetro está ocupada

//ocupa 
//ocupa determinada cadeira do vôo, cujo número é recebido como parâmetro, e retorna verdadeiro se a cadeira ainda não estiver ocupada (operação foi bem sucedida) e falso caso contrário 
//
//vagas 
//retorna o número de cadeiras vagas disponíveis (não ocupadas) no vôo 
//
//
//getVoo 
//retorna o número do vôo 