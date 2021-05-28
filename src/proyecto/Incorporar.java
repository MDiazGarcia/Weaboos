package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Incorporar extends JFrame implements WindowListener, ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField textAnime;
	private JTextField textExtra;
	private JButton btnAtras;
	private JButton btnIncorporar;
	private String nomU;
	

	/**
	 * Create the frame.
	 */
	public Incorporar(String nomU) {
		setTitle("Crear Incorporaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nomU=nomU;
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIncorporar = new JLabel("Incorporar");
		lblIncorporar.setBounds(185, 40, 65, 14);
		contentPane.add(lblIncorporar);
		
		JLabel lblNombreAnime = new JLabel("Nombre Anime");
		lblNombreAnime.setBounds(56, 86, 119, 14);
		contentPane.add(lblNombreAnime);
		
		textAnime = new JTextField();
		textAnime.setBounds(185, 83, 153, 20);
		contentPane.add(textAnime);
		textAnime.setColumns(10);
		
		JLabel lblInformacionExtra = new JLabel("Informacion Extra");
		lblInformacionExtra.setBounds(56, 127, 119, 14);
		contentPane.add(lblInformacionExtra);
		
		textExtra = new JTextField();
		textExtra.setBounds(185, 124, 153, 20);
		contentPane.add(textExtra);
		textExtra.setColumns(10);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(56, 202, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		btnIncorporar = new JButton("Incorporar");
		btnIncorporar.setBounds(233, 202, 105, 23);
		contentPane.add(btnIncorporar);
		btnIncorporar.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String bd ="proyecto";
		String url="jdbc:mysql://localhost:3306/"+bd;
		
		String user="root";
		String pasw="";
		
		Connection conn= null;
		Statement stmt=null;
		ResultSet rs=null;
		
		if(e.getSource()==btnIncorporar) {
			System.out.println("Incorporar");
			Utiles u =new Utiles();
			u.incorporar(nomU, textAnime.getText(), textExtra.getText());
			dispose();
			GestInc gi= new GestInc(nomU);
			
		}else if(e.getSource()==btnAtras) {
			System.out.println("Atras");
			dispose();
			GestInc gi=new GestInc(nomU);
			
		}
		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
