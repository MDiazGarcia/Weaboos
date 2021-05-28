package proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Component;


public class Recomendar extends JFrame implements WindowListener, ActionListener, MouseListener{
	
	
	private JPanel miPanel;
	private JComboBox animeSel;
	private JTextField textReseña;
	private JComboBox valoracion;
	private JLabel lblReseña;
	private JButton btnRecomendar;
	private String nomU;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public Recomendar(String nomU) {
		setTitle("Recomendar Anime");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Recomendar.class.getResource("/proyecto/logoCeinmark.png")));
		this.nomU=nomU;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		animeSel = new JComboBox();
		animeSel.setMaximumRowCount(50);
		animeSel.setBounds(207, 36, 169, 20);
		miPanel.add(animeSel);
		
		JLabel lblRecomendar = new JLabel("Recomendar");
		lblRecomendar.setBounds(184, 11, 95, 14);
		miPanel.add(lblRecomendar);
		
		JLabel lblNombreAnime = new JLabel("Nombre Anime");
		lblNombreAnime.setBounds(77, 39, 102, 14);
		miPanel.add(lblNombreAnime);
		
		valoracion = new JComboBox();
		valoracion.setModel(new DefaultComboBoxModel(new String[] {"1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5"}));
		valoracion.setToolTipText("1\r\n1.5\r\n2\r\n2.5\r\n3\r\n3.5\r\n4\r\n4.5\r\n5");
		valoracion.setMaximumRowCount(50);
		valoracion.setBounds(207, 74, 169, 20);
		miPanel.add(valoracion);
		
		JLabel lblValoracin = new JLabel("Valoraci\u00F3n");
		lblValoracin.setBounds(77, 77, 102, 14);
		miPanel.add(lblValoracin);
		
		lblReseña = new JLabel("Rese\u00F1a");
		lblReseña.setBounds(77, 120, 46, 14);
		miPanel.add(lblReseña);
		
		textReseña = new JTextField();
		textReseña.setBounds(207, 117, 169, 85);
		miPanel.add(textReseña);
		textReseña.setColumns(10);
		
		btnRecomendar = new JButton("Recomendar");
		btnRecomendar.setBounds(268, 213, 108, 23);
		miPanel.add(btnRecomendar);
		btnRecomendar.addActionListener(this);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(77, 213, 89, 23);
		miPanel.add(btnAtras);
		btnAtras.addActionListener(this);
		
		
		
		ArrayList<String> animeNom=new ArrayList<String>();
		Utiles u=new Utiles();
		u.nomCombo(animeNom);
		for(int i=0;i<animeNom.size();i++) {
		animeSel.addItem(animeNom.get(i));
		}
		
		
		
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
		
		if(e.getSource()==btnRecomendar) {
			System.out.println("Recomendar");
			if(textReseña.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Reseña Vacia",
						"Error Reseña", JOptionPane.WARNING_MESSAGE);
			}else {
				Utiles u = new Utiles();
				
				u.recomendar(animeSel.getSelectedItem().toString(), Float.parseFloat(valoracion.getSelectedItem().toString()), textReseña.getText(), nomU);
				JOptionPane.showMessageDialog(null, "Reseña hecha con exito",
						"Exito", JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				SelecInsert si = new SelecInsert(nomU);
			}
			
			
		}else if(e.getSource()==btnAtras) {
			System.out.println("atras");
			dispose();
			
			SelecInsert si = new SelecInsert(nomU);
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
	
