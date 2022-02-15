package aplicacao;

import javax.swing.JOptionPane;

import conexao.ConexaoBD;
import dao.MateriaDAO;
import modelo.Materia;

public class Principal {

	public static void main(String[] args) {
		try {
			Materia m = new Materia();
			
			m.setAssunto(JOptionPane.showInputDialog("Informe assunto"));
			m.setAutor(JOptionPane.showInputDialog("Informe autor"));
			m.setDescricao(JOptionPane.showInputDialog("Informe descricao"));
			m.setDisciplina(JOptionPane.showInputDialog("Informe disciplina"));
			m.setLink(JOptionPane.showInputDialog("Informe link"));
			
			MateriaDAO mdao = new MateriaDAO();
			
			mdao.incluir(m);
			
			for (Materia materia : mdao.listar()) {
				System.out.println(materia);
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi Conectado :(");
			e.printStackTrace();
		}

	}

}
