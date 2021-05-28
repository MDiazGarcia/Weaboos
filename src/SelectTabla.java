package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
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
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SelectTabla extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel miPanel;
	private JLabel lblSeleccionarTabla;
	private JButton btnAnimes ;
	private JButton btnRecomendaciones;
	private JButton btnIncorporaciones;
	private JButton btnUsuarios;
	private JButton btnAtras;
	private String nomU;
	
	/**
	 * Create the frame.
	 */
	public SelectTabla(String nomU) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelectTabla.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		lblSeleccionarTabla = new JLabel("Seleccionar Tabla");
		lblSeleccionarTabla.setBounds(167, 28, 109, 14);
		miPanel.add(lblSeleccionarTabla);
		
		btnAnimes = new JButton("Animes");
		btnAnimes.setBounds(48, 83, 141, 23);
		miPanel.add(btnAnimes);
		btnAnimes.addActionListener(this);
		
		btnRecomendaciones = new JButton("Recomendaciones");
		btnRecomendaciones.setBounds(48, 148, 141, 23);
		miPanel.add(btnRecomendaciones);
		
		btnRecomendaciones.addActionListener(this);
		
		btnIncorporaciones = new JButton("Incorporaciones");
		btnIncorporaciones.setBounds(230, 83, 141, 23);
		miPanel.add(btnIncorporaciones);
		btnIncorporaciones.addActionListener(this);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(230, 148, 141, 23);
		miPanel.add(btnUsuarios);
		btnUsuarios.addActionListener(this);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(167, 208, 89, 23);
		miPanel.add(btnAtras);
		btnAtras.addActionListener(this);
	
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == btnAnimes) {
			System.out.println("boton Animes");
			dispose();
			Tablas ta = new Tablas("Animes",nomU);
			
		} else if (e.getSource() == btnRecomendaciones) {
			System.out.println("boton Recomendaciones");
			dispose();
			Tablas tr = new Tablas("Recomendaciones",nomU);
			
		} else if (e.getSource() == btnIncorporaciones) {
			System.out.println("boton Incorporaciones");
			
			String bd ="proyecto";
			String url="jdbc:mysql://localhost:3306/"+bd;
		
			String user="root";
			String pasw="";
		
			Connection conn= null;
			Statement stmt=null;
			ResultSet rs=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,user,pasw);
				stmt = conn.createStatement();
				
				
				rs = stmt.executeQuery("Select * from incorporaciones ");
				
				if(rs.next()) {
					dispose();
					Tablas ti = new Tablas("Incorporaciones",nomU);
				}else {
					
					JOptionPane.showMessageDialog(null, "No hay incorporaciones en este momento",
							"Sin incorporaciones", JOptionPane.WARNING_MESSAGE);
				}
				rs.close();
				stmt.close();
				conn.close();
			}catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}else if (e.getSource() == btnUsuarios) {
			System.out.println("boton Usuarios");
			dispose();
			Tablas tr = new Tablas("Usuarios",nomU);
			
		}else if (e.getSource() == btnAtras) {
			System.out.println("atras");
			dispose();
			
			Dentro d = new Dentro(nomU);
			
		}
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
