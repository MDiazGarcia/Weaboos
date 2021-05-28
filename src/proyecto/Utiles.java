package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Utiles {
	
	private String bd ="proyecto";
	private String url="jdbc:mysql://localhost:3306/"+bd;
	
	private String user="root";
	private String pasw="";
	
	private Connection conn= null;
	private Statement stmt=null;
	private ResultSet rs=null;
	
public void nomCombo(ArrayList<String> animeNom) {
	
	
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pasw);
			stmt = conn.createStatement();
			
		
		rs=stmt.executeQuery("select * from animes");
		
		while(rs.next()) {
			
			animeNom.add(rs.getString("nombreA"));
			
		}
		rs.close();
		stmt.close();
		}catch (ClassNotFoundException e1) {
		
			e1.printStackTrace();
		}catch (SQLException e1) {
		
			e1.printStackTrace();
		}
	}
	
	
	
	public void recomendar(String nombreA,float valoracion,String reseña,String nomU) {
		int pos=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pasw);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("select IdRecomendacion from recomendaciones order by IdRecomendacion");
			
			
			rs.last();
			pos=rs.getInt("IdRecomendacion");
			pos++;
			stmt.executeUpdate("insert into recomendaciones values ('"+pos+
			"','"+nombreA+"','"+nomU+"','"+reseña+"','"+valoracion+"',now())");
			
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	public void incorporar(String nomU,String anime,String extra) {
		int pos=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pasw);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("select * from animes where animes.nombreA = '"+anime+"'");
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Este anime ya existe",
							"Anime Existente", JOptionPane.WARNING_MESSAGE);
				}else {
					rs=stmt.executeQuery("select NumeroInc from incorporaciones order by NumeroInc");
					
					if(!rs.next()) {
						pos=1;
						
					}else {
					rs.last();
					pos=rs.getInt("NumeroInc")+1;
					
					}
					System.out.println(pos);
					stmt.executeUpdate("insert into incorporaciones values('"+pos+
					"','"+anime+"','"+nomU+"','"+extra+"',now(),0)");
				
					JOptionPane.showMessageDialog(null, "Anime Incorporado",
							"Incorporado", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			
			rs.close();
			stmt.close();
			conn.close();
		}catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	public void eliminarInc(String idDel) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pasw);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("select NumeroInc from incorporaciones where NumeroInc='"+idDel+"'");
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "No existe",
						"Error no existe", JOptionPane.ERROR_MESSAGE);
				
			}else {
				
				stmt.executeUpdate("delete from incorporaciones where NumeroInc='"+idDel+"'");
				JOptionPane.showMessageDialog(null, "Incorporacion eliminada","Eliminado", JOptionPane.INFORMATION_MESSAGE);
				
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
