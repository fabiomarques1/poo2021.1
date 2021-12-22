package dao;

import java.util.List;

import modelo.Contato;

public interface ContatoDAO {
	
	public abstract int incluir(Contato contato); //C
	public abstract List<Contato> listarContatos(); //R
	public abstract int atualizar(Contato contato); //U
	public abstract int apagar(int id); //D

}
