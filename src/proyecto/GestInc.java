package proyecto;



import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestInc extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnSolicitar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private String nomU;
	
	/**
	 * Create the frame.
	 */
	public GestInc(String nomU) {
		setTitle("Gestionar Incorporaciones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestInc.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaOpcion = new JLabel("Selecciona Opci\u00F3n");
		lblSeleccionaOpcion.setBounds(164, 37, 117, 14);
		contentPane.add(lblSeleccionaOpcion);
		
		
		btnSolicitar = new JButton("Solicitar Incorporacion");
		btnSolicitar.setBounds(115, 76, 191, 23);
		contentPane.add(btnSolicitar);
		btnSolicitar.addActionListener(this);
		
		btnEliminar = new JButton("Eliminar Incorporacion");
		btnEliminar.setBounds(115, 125, 191, 23);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(164, 188, 98, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		
		setVisible(true);
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
		
		if(e.getSource()==btnSolicitar) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,user,pasw);
				stmt = conn.createStatement();
				
				rs=stmt.executeQuery("select Nickname from incorporaciones where Nickname='"+nomU+"'");
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "El usuario ya tiene solicitada una incorporación",
							"Error ya solicitado", JOptionPane.WARNING_MESSAGE);
				}else {
					System.out.println("Solicitar");
					dispose();
					Incorporar i=new Incorporar(nomU);
				}
			}catch (ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			
		}else if(e.getSource()==btnEliminar) {
			System.out.println("Eliminar");
			dispose();
			DelInc di=new DelInc(nomU);
			
		}else if(e.getSource()==btnAtras) {
			System.out.println("Atras");
			dispose();
			SelecInsert si=new SelecInsert(nomU);
		}
		
		
	}

}
