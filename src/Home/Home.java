package Home;
//import  ForumPack;

import java.awt.Container;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;



import promotionsPack.Promo;



import Acceuilpack.Acceuil;
import ForumPack.Client1;

import RechercherPack.Rechercher;
import Reservationpack.Reservation;

public class Home extends JFrame{
	JTabbedPane onglets = null;
	Container c;
	public Home() 
	{this.setBounds(100, 20,1000,650);
	c=this.getContentPane();
this.setResizable(false);

  onglets =new JTabbedPane();
	onglets.addTab("Acceuil",null,new Acceuil());
	onglets.addTab("promotions",null,new Promo());
	onglets.addTab("Reservation",null,new Reservation());
	onglets.addTab("Rechercher",null,new Rechercher());
	onglets.addTab("Forum",null,new Client1());
	c.add(onglets);
	
	
	
	
	
	
	
	
	
	
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setVisible(true);
		
	}
	public static void main(String []args){
		Home h=new Home();
	}
	

}
