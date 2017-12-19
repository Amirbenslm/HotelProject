package Reservationpack;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

import javax.swing.JOptionPane;


public class Connect_base {
	String url = "jdbc:mysql://localhost:3306/Agence";
	String utilisateur = "root";
	String motDePasse = "";
	Connection connexion = null; 
	Statement statement;
	public Connect_base(){
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
	System.out.print("erreur drive");
		}
		try {
		    connexion =  DriverManager.getConnection( url, utilisateur, motDePasse );
		}catch(SQLException e){
			System.out.print("erreur connection");
		}
		
	}
	public void connect()
	{
		try {
		    connexion =  DriverManager.getConnection( url, utilisateur, motDePasse );
		
		
    	     statement =  connexion.createStatement();
		}catch(SQLException e){
			System.out.print("erreur connection");
		}	
	}
	void ajout(String a,String b,String c,String d,String e,String f)
	{
		try {
			statement.executeUpdate("INSERT INTO reservation VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void supprimer(String a)
	{
		try {
			statement.executeUpdate("delete from reservation where id_reservation='"+a+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void modifier(String a,String b,String c,String d,String e,String f)
	{//System.out.println(a+b+c+d+e);
		try {
			statement.executeUpdate("update reservation set id_reservation='"+a+"',id_client='"+b+"',room_type='"+c+"',idHotel='"+d+"',date_checkin='"+e+"',date_checkout='"+f+"' where id_reservation='"+a+"'");
			
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	 public ResultSet affiche(){
		ResultSet r = null;
		try {
			 r=statement.executeQuery("SELECT * FROM Agence.reservation;");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return r;
	}
	 public ResultSet afficheisValidCIN(String c){
			ResultSet r = null;
			try {
				 r=statement.executeQuery("SELECT * FROM Agence.client where cin='"+c+"';");
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return r;
		}
	 public ResultSet afficheClient(){
			ResultSet r = null;
			try {
				 r=statement.executeQuery("SELECT * FROM Agence.client;");
				 //System.out.println("done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return r;
		}
	 public ResultSet affichepromotions(){
			ResultSet r = null;
			try {
				 r=statement.executeQuery("SELECT nom FROM Agence.hotel where promotions='oui';");
				 //System.out.println("done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return r;
		}
	 public ResultSet afficheHotel(){
			ResultSet r = null;
			try {
				 r=statement.executeQuery("SELECT * FROM Agence.hotel;");
				 //System.out.println("done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return r;
		}
	public void ajoutclient(String a,String b,String c,String d,String e,String f,String g)
	{		

		try {
			statement.executeUpdate("INSERT INTO client VALUES('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')");
			System.out.println("succes");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ajoutHotel(String a,String b,String c,String d,String e,String f,String g,String h)
	{	String id=a+'_'+b;	
   System.out.println(id);
		try {
			statement.executeUpdate("INSERT INTO hotel VALUES('"+id+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','hhahah')");
			System.out.println("succes");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
public ResultSet filtrerHotel(String ville,String etoil,String plag,String park,String promo)
{
	ResultSet r = null;
	String instruction=("Select * from Agence.hotel where ville='"+ville+"'");
	 
	if (plag.equals("oui"))
	{
		instruction+=" and plage='"+plag+"'";
	}
	if (park.equals("oui"))
	{	instruction+=" and parking='oui'";
	}
	if (promo.equals("oui"))
	{	instruction+=" and promotions='oui'";
	}
	System.out.println(instruction);
	try {
		 r=statement.executeQuery(instruction);
		 //System.out.println("done");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	
	/*try {
		 r=statement.executeQuery("SELECT * FROM Agence.hotel where ville='"+ville+"' and nombre_etoile='"+etoil+"' and plage='"+plag+"' and parking='"+plag+"' and promotions='"+promo+"';");
		 //System.out.println("done");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	System.out.println("Recherche effectué avec succes");	
	
	return r;

}
	
	public void deconnect()
	{
		try{
	
		connexion.close();
	}
	catch( SQLException e){System.out.println("connection close");}
	
}
	}



