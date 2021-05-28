package proyecto;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class SelecInsert extends JFrame implements WindowListener, ActionListener, MouseListener{

	private JPanel miPanel;
	private JLabel lblNewLabel;
	private JButton btnGestInc;
	private JButton btnRecomendar; 
	private JButton btnAtras;
	private String nomU;
	

	/**
	 * Create the frame.
	 */
	public SelecInsert(String nomU) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecInsert.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		 lblNewLabel = new JLabel("Elige opci\u00F3n");
		lblNewLabel.setBounds(181, 42, 79, 14);
		miPanel.add(lblNewLabel);
		
		btnGestInc = new JButton("Gestionar Incorporaciones");
		btnGestInc.setBounds(124, 82, 190, 23);
		miPanel.add(btnGestInc);
		btnGestInc.addActionListener(this);
		
		btnRecomendar = new JButton("Recomendar Anime");
		btnRecomendar.setBounds(124, 126, 190, 23);
		miPanel.add(btnRecomendar);
		btnRecomendar.addActionListener(this);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(181, 189, 89, 23);
		miPanel.add(btnAtras);
		btnAtras.addActionListener(this);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == btnRecomendar) {
			System.out.println("boton Animes");
			dispose();
			Recomendar ta = new Recomendar(nomU);
			
		} else if (e.getSource() == btnGestInc) {
			System.out.println("boton Recomendaciones");
			dispose();
			GestInc gi=new GestInc(nomU);
			
		}else if(e.getSource()==btnAtras) {
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
