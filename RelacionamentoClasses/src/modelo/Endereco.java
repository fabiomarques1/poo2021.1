package modelo;

public class Endereco {
	private String rua;
	private short numero;
	private String complemento;
	private int cep;
	private String cidade;
	private String estado;
	
	public Endereco() {
		
	}

	public Endereco(short numero, int cep) {
		this.numero = numero;
		this.cep = cep;
	}

	public Endereco(String rua, short numero, String complemento, int cep, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public short getNumero() {
		return numero;
	}

	public void setNumero(short numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
	
}
