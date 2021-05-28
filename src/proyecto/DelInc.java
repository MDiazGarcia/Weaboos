package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DelInc extends JFrame implements WindowListener, ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField textIdDel;
	private JButton btnEliminar;
	private JButton btnAtras;
	private String nomU;
	

	

	/**
	 * Create the frame.
	 */
	public DelInc(String nomU) {
		setTitle("Eliminar Incorporaci\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DelInc.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEliminar = new JLabel("Id a Eliminar");
		lblIdEliminar.setBounds(168, 73, 74, 14);
		contentPane.add(lblIdEliminar);
		
		textIdDel = new JTextField();
		textIdDel.setBounds(135, 98, 133, 20);
		contentPane.add(textIdDel);
		textIdDel.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(235, 177, 89, 23);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(71, 177, 89, 23);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
	
	
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
		
		if(e.getSource()==btnEliminar) {
			System.out.println("ElimanarInc");
			
			Utiles u=new Utiles();
			u.eliminarInc(textIdDel.getText());
			
			
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
