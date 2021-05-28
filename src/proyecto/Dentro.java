package proyecto;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Dentro extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JPanel miPanel;
	private JButton btnVerTablas, btnIntroducir,btnCerrar;
	private String nomU;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Dentro(String nomU) {
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dentro.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 298);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		btnIntroducir = new JButton("Introducir Datos");
		btnIntroducir.setBounds(166, 112, 129, 23);
		miPanel.add(btnIntroducir);
		
		btnIntroducir.addActionListener(this); 
		
		
		btnVerTablas = new JButton("Ver Tablas");
		btnVerTablas.setBounds(166, 59, 129, 23);
		miPanel.add(btnVerTablas);
		
		btnVerTablas.addActionListener(this);
		
		
		btnCerrar = new JButton("Cerrar Sesi\u00F3n");
		btnCerrar.setBounds(166, 165, 129, 23);
		miPanel.add(btnCerrar);
		
		btnCerrar.addActionListener(this);
		
		
		
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
		if (e.getSource() == btnVerTablas) {
			System.out.println("boton Ver Tablas");
			dispose();
			SelectTabla st = new SelectTabla(nomU);
			
		} else if (e.getSource() == btnIntroducir) {
			System.out.println("boton Incorporaciones");
			dispose();
			SelecInsert ti = new SelecInsert(nomU);
			
		}else if (e.getSource() == btnCerrar) {
			System.out.println("cerrar");
			dispose();
			
			Login l = new Login();
			
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
