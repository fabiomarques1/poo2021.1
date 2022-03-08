package aplicacao;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	URI uri = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Cria URI
		String link = "http://www.uol.com.br";
		try
		{
			uri = new URI(link);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Cria Label
		JLabel website = new JLabel("New label");
		website.setBounds(5, 115, 302, 46);
		website.setText("<html> Website : <a href=\"\">" + link + "</a></html>");
        website.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	contentPane.add(website);
        //Evento Clique do Mouse no Label
		website.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open(uri);
			}
		});

		
		
		
	
	
		
	}
	
	//Método para abrir a uri no browser default do SO
	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(uri);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Failed to launch the link, your computer is likely misconfigured.",
						"Cannot Launch Link", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Java is not able to launch links on your computer.",
					"Cannot Launch Link", JOptionPane.WARNING_MESSAGE);
		}
	}
}

