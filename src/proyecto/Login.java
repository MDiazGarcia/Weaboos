package proyecto;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;


public class Login extends JFrame implements WindowListener, ActionListener, MouseListener{

	private JPanel miPanel;
	private JTextField textUsuario;
	private JLabel lblUsuario, lblPass;
	private JButton btnAceptar, btnRegistrar;
	private JPasswordField password;
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/proyecto/logoCeinmark.png")));
		
		setEnabled(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 298);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(101, 120, 69, 20);
		miPanel.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(180, 120, 144, 20);
		miPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
		lblPass = new JLabel("Contrase\u00F1a: ");
		lblPass.setBounds(101, 162, 87, 20);
		miPanel.add(lblPass);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(270, 213, 89, 23);
		miPanel.add(btnAceptar);
		
		btnAceptar.addActionListener(this);
	
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(118, 213, 89, 23);
		miPanel.add(btnRegistrar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/proyecto/logo weaboo5,5.png")));
		lblLogo.setBounds(135, 0, 213, 118);
		miPanel.add(lblLogo);
		
		password = new JPasswordField();
		password.setBounds(180, 162, 144, 20);
		miPanel.add(password);
		
		btnRegistrar.addActionListener(this);
		
		
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
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnAceptar) {
			System.out.println("aceptar");
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
				
				
				rs = stmt.executeQuery("Select * from usuarios where nickname like '"+textUsuario.getText()+"'");
				
				if(rs.next()) {
					
						if(!(password.getText().equals(rs.getString("contraseña")))) {
							
							JOptionPane.showMessageDialog(null, "Contraseña Incorrecta",
									"Error Contraseña", JOptionPane.WARNING_MESSAGE);
							
							
						}else {
							
							dispose();
							Utiles u = new Utiles();
							
							Dentro d = new Dentro(textUsuario.getText());
							
						}
						
					
				}else {
					JOptionPane.showMessageDialog(null, "El usuario no existe",
							"Error usuario", JOptionPane.WARNING_MESSAGE);
				}
				rs.close();
				stmt.close();
				conn.close();
			}catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			
		} else if (e.getSource() == btnRegistrar) {
			System.out.println("registrar");
			dispose();
			Registro r = new Registro();
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
