
public class Trator {
	//atributo
	String marca;
	//Estados
	double velocidade;
	double alturaBraco;
	
	//métodos
	public Trator(String marca) { //construtor
		this.marca = marca;
		this.velocidade = 0;
		this.alturaBraco = 0;
	}
	
	public String acelerar() { //Incrementa em 10km/h
		String msg;
		if (this.velocidade < 80 && this.alturaBraco != 0) { //Testa se menor que a máxima
			this.velocidade = this.velocidade + 10;
			msg = "Velocidade aumentada para " + this.velocidade;
		} else {
			msg = "O braço precisa estar levantado para poder andar";
		}
		
		return msg;
	}

	public String desacelerar() { //Decrementa em 10km/h
		String msg;
		if (this.velocidade > 0) { // Testa se maior que zero
			this.velocidade = this.velocidade - 10;
			msg = "Velocidade diminuída para " + this.velocidade;
		} else {
			msg = "A velocidade já é Zero!";
		}
		return msg;
	}
	
	public String parar() {
		String msg;
		if (this.velocidade != 0) {
			this.velocidade = 0;
			msg = "Veículo parado!";
		} else {
			msg = "Veículo já se encontrava parado!";
		}
		
		return msg;
	}
	
	public String levantarBraco() {
		String msg = "";
		if (this.alturaBraco < 10) { //Testa se menor que a máxima
			this.alturaBraco = this.alturaBraco + 1;
			msg = "Braço levantado!";
		} else {
			msg = "Braço já está na altura máxima";
		}
		
		return msg;
	}
	
	public String abaixarBraco() {
		String msg = "";
		if (this.alturaBraco > 1 || (this.velocidade == 0 && this.alturaBraco == 1)) { //Testa se maior que zero
			this.alturaBraco = this.alturaBraco - 1;
			msg = "Braço abaixado!";
		} else {
			if (this.velocidade != 0 ) {
				if (this.alturaBraco == 1) {
					msg = "Braço já está na altura mínima para veículo em movimento";
				}		
			} else {
				msg = "Braço já está na altura mínima";
			}
		}
		
		return msg;
	}

	@Override
	public String toString() {
		return "Trator [marca=" + marca + ", velocidade=" + velocidade + ", alturaBraco=" + alturaBraco + "]";
	}
 

}
