package modelo;

public class Cliente {
	long cpf;
	String nome;
	Endereco enderecoCobranca;
	Endereco enderecoEntrega;
	
	public Cliente() {
		
	}

	public Cliente(long cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente(long cpf, String nome, Endereco enderecoCobranca, Endereco enderecoEntrega) {
		this.cpf = cpf;
		this.nome = nome;
		this.enderecoCobranca = enderecoCobranca;
		this.enderecoEntrega = enderecoEntrega;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Endereco enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", enderecoCobranca=" + enderecoCobranca
				+ ", enderecoEntrega=" + enderecoEntrega + "]";
	}

}
