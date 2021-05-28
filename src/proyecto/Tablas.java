package proyecto;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
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

public class Tablas extends JFrame implements WindowListener, ActionListener, MouseListener{

	private JPanel miPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAtrs;
	private String nomU;
	
	/**
	 * Launch the application.
	 */

public Tablas(String tablaNom,String nomU) {
		this.nomU=nomU;
	
		String bd = "proyecto";
		String url="jdbc:mysql://localhost:3306/" + bd ;

		String user="root";
		String pass="";
		
		String nombreColumnas[];
		String datos[][];
		int numFilas=0, numCol=0, pos=0;
		
		Connection conn=null;		
		Statement stmt=null;
		ResultSet rs = null;
		
		
	 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user,pass);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );
			rs = stmt.executeQuery("Select * from "+tablaNom);
			
			numCol = rs.getMetaData().getColumnCount();
			
			nombreColumnas = new String[numCol];
			
			for(int i=0 ; i< nombreColumnas.length ; i++) {
				nombreColumnas[i] = rs.getMetaData().getColumnName(i+1);
			}
			
			rs.last();
			
			numFilas = rs.getRow();
			datos = new String[numFilas][numCol];
			
			rs.beforeFirst();
			while(rs.next()) {
				for(int i=0 ; i<numCol ; i++) {
					datos[pos][i] = rs.getString(i+1);
				}
				pos++;
			}		
			
			rs.close();
			stmt.close();
			conn.close();
			
			Tablas miTabla = new Tablas(nombreColumnas,datos,tablaNom);
			
		}catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException: " + ex.getMessage());
		}catch(SQLException ex) {
			System.out.println("SQLException: " +ex.getMessage());
			ex.printStackTrace();
		}
		
		
	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public Tablas(String[] nombreColumnas, String[][] datos,String tablaNom) {
		setTitle(tablaNom);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tablas.class.getResource("/proyecto/logoCeinmark.png")));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		miPanel = new JPanel();
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		table = new JTable(datos,nombreColumnas);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 786, 563);
		miPanel.add(scrollPane);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(this);
		
		scrollPane.setRowHeaderView(btnAtrs);
		
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAtrs) {
			System.out.println("aceptar");
			dispose();
			
			SelectTabla st = new SelectTabla(nomU);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
