package Reservationpack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;




public class Reservation extends JPanel{
	  Image bg = new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/Background/17.jpg").getImage();

	JLabel l_hotel,lmod_hotel,lid_client,lid_reser,ltype,lcheckin,lcheckout,modl_client,modl_reser,modl_type,modl_checkin,modl_checkout,supl_reserv;
	JTextField tid_client,tid_reser,ttype,/*tcheckin,tcheckout,*/mod_client,mod_reser,mod_type,sup_reserv;
	JComboBox type,jmod_type;
	JPanel  pan_ajout,pan_supp,pan_mod,pan1,pan2,pan3,pan_aff,pan_aff1;
 	JButton ajout,modifier,supprimer,reservations ;
 	JTable taff;
 	ResultSet rs;
 	JTable jt;
 	JScrollPane sp;
 	JComboBox<String> cb_reser,cb_idclient,cb_hotel,cb_modhotel;
 	JDateChooser tcheckin,tcheckout,mod_checkin,mod_checkout;
	public Reservation(){	
		this.setLayout(null);
		/*     declaration des Labelle               */
		lid_client=new JLabel("ID_Client:");
		lid_reser=new JLabel("ID_Reservation:");
		ltype=new JLabel("Room_Type:");
		lcheckin=new JLabel("Date_CheckIn:");
		lcheckout=new JLabel("Date_CheckOut:");
		l_hotel=new JLabel("Hotel:");
		//tid_client=new JTextField(15);
		cb_idclient=new JComboBox<String>() ;
		cb_hotel=new JComboBox<String>() ;
		tid_reser=new JTextField(15);
		tcheckin=new JDateChooser();
		tcheckout=new JDateChooser();
		pan_ajout=new JPanel();
		ajout =new JButton("Ajouter");
		pan1=new JPanel();
		pan_supp=new JPanel();
		pan_aff=new JPanel();
		pan_mod=new JPanel();
		Connect_base c1=new Connect_base();
		c1.connect();
		ResultSet rs1=c1.afficheHotel();


	try {
			while(rs1.next())
			{
			cb_hotel.addItem(rs1.getString(1));	
			}
		} catch (SQLException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
	cb_idclient.removeAllItems();
	
	ResultSet rs2=c1.afficheClient();
	try {
		while(rs2.next())
		{
		cb_idclient.addItem(rs2.getString(1));	
		}
	} catch (SQLException e12) {
		// TODO Auto-generated catch block
		e12.printStackTrace();
	}
		
			
		cb_idclient.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				cb_idclient.removeAllItems();
				Connect_base c=new Connect_base();
				c.connect();
				ResultSet rs=c.afficheClient();
				try {
					while(rs.next())
					{
					cb_idclient.addItem(rs.getString(1));	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		/************* Ajouter Panel*************/ 
		GridLayout aj=new GridLayout(7,2);
		aj.setVgap(6);
		pan_ajout.setLayout(aj);
		pan_ajout.setBorder(BorderFactory.createTitledBorder("Ajouter Une Reservation"));
		pan1.add(ajout);
		type=new JComboBox();
		type.addItem("Single room");
		type.addItem("Double room");
		type.addItem("triple room");
		pan_ajout.add(lid_reser);
		pan_ajout.add(tid_reser);
		pan_ajout.add(lid_client);
		pan_ajout.add(cb_idclient);
		pan_ajout.add(l_hotel);
		pan_ajout.add(cb_hotel);
		pan_ajout.add(ltype);
		pan_ajout.add(type);
		pan_ajout.add(lcheckin);
		pan_ajout.add(tcheckin);
		pan_ajout.add(lcheckout);
		pan_ajout.add(tcheckout);
		pan1.setOpaque(false);
		pan_ajout.add(pan1);
		pan_ajout.setLocation(30,30);
		pan_ajout.setSize(300,300);
		pan_ajout.setOpaque(false);
		ajout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cb_reser.addItem(tid_reser.getText());
				Connect_base c=new Connect_base();
				c.connect();
				java.util.Date bir=tcheckin.getDate();
				java.sql.Date d = new java.sql.Date(bir.getTime());
				
				java.util.Date bir1=tcheckout.getDate();
				java.sql.Date d2 = new java.sql.Date(bir1.getTime());
				

				c.ajout(tid_reser.getText(),(String)cb_idclient.getSelectedItem(),(String)type.getSelectedItem(),(String)cb_hotel.getSelectedItem(),d.toString(),d2.toString());
				
				rs=c.affiche();
				AffichageJtable af=new AffichageJtable();
				jt=af.retourJtable(rs);
				pan_aff1.remove(sp);
				sp=new JScrollPane(jt);
				c.deconnect();
				pan_aff1.add(sp);
				c.deconnect();
			}
		});
		
		/************ Modifier Panel ***********************/ 
		pan_mod.setBorder(BorderFactory.createTitledBorder("Modifier Une Reservation"));
		modl_client=new JLabel("Entrer ID_Client:");
		modl_reser=new JLabel("Entrer ID_Reservation:");
		modl_type=new JLabel("Room_Type:");
		modl_checkin=new JLabel("Date_CheckIn:");
		modl_checkout=new JLabel("Date_CheckOut:");
		mod_client=new JTextField(15);
		//mod_reser=new JTextField(15);
		cb_reser=new JComboBox<String>() ;
		cb_modhotel=new JComboBox<String>() ;
		lmod_hotel=new JLabel("Hotel:");
		mod_checkin=new JDateChooser();
		mod_checkout=new JDateChooser();
		pan2=new JPanel();
		GridLayout gl=new GridLayout(7,2);
		gl.setVgap(6);
		pan_mod.setLayout(gl);
		modifier =new JButton("Modifier");
		//modifier.setPreferredSize(new Dimension(100,25));
		pan2.add(modifier);
		jmod_type=new JComboBox();
		jmod_type.addItem("Single room");
		jmod_type.addItem("Double room");
		jmod_type.addItem("triple room");
		pan_mod.add(modl_reser);
		pan_mod.add(cb_reser);
		pan_mod.add(modl_client);
		pan_mod.add(mod_client);
		pan_mod.add(lmod_hotel);
		pan_mod.add(cb_modhotel);
		pan_mod.add(modl_type);
		pan_mod.add(jmod_type);
		pan_mod.add(modl_checkin);
		pan_mod.add(mod_checkin);
		pan_mod.add(modl_checkout);
		pan_mod.add(mod_checkout);
		pan2.setOpaque(false);
		pan_mod.add(pan2);
		//pan_ajout.setBackground(Color.BLUE);
		pan_mod.setLocation(350,30);
		pan_mod.setSize(300,300);
		pan_mod.setOpaque(false);
		cb_reser.removeAll();
		Connect_base c12=new Connect_base();
		c12.connect();
		ResultSet rs6=c12.afficheHotel();


	try {
			while(rs6.next())
			{
			cb_modhotel.addItem(rs6.getString(1));	
			}
		} catch (SQLException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}

		
		
			
			
	Connect_base c21=new Connect_base();
	c21.connect();
	ResultSet rs21=c21.affiche();
	try {
		while(rs21.next())
		{
		cb_reser.addItem(rs21.getString(1));	
		}
	} catch (SQLException e21) {
		// TODO Auto-generated catch block
		e21.printStackTrace();
	}
				
		
			
				
		
		
		modifier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connect_base c=new Connect_base();
				c.connect();
				java.util.Date bir=mod_checkin.getDate();
				java.sql.Date d = new java.sql.Date(bir.getTime());
				
				java.util.Date bir1=mod_checkout.getDate();
				java.sql.Date d2 = new java.sql.Date(bir1.getTime());
				
				c.modifier((String)cb_reser.getSelectedItem(),mod_client.getText(),(String)jmod_type.getSelectedItem(),(String)cb_modhotel.getSelectedItem(),d.toString(),d2.toString());
				rs=c.affiche();
				AffichageJtable af=new AffichageJtable();
				jt=af.retourJtable(rs);
				pan_aff1.remove(sp);
				sp=new JScrollPane(jt);
				c.deconnect();
				pan_aff1.add(sp);
				c.deconnect();
			
			}
		});
		/**************Supprimer Reservation*****///
		pan3=new JPanel();
		//pan_supp.setLayout(null);
		pan_supp.setBorder(BorderFactory.createTitledBorder("Supprimer Une Reservation"));
		supl_reserv=new JLabel("ID reservation:");
		sup_reserv=new JTextField(15);
		supprimer =new JButton("Supprimer");
		//supprimer.setPreferredSize(new Dimension(140,40));
		//supprimer.setLocation(780,150);

		
		pan_supp.add(supl_reserv);
		pan_supp.add(sup_reserv);
		pan_supp.add(supprimer);
		
		pan_supp.setLocation(670,30);
		pan_supp.setSize(300,300);
		pan_supp.setOpaque(false);
		supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Connect_base c=new Connect_base();
				c.connect();
				c.supprimer(sup_reserv.getText());
				rs=c.affiche();
				AffichageJtable af=new AffichageJtable();
				jt=af.retourJtable(rs);
				pan_aff1.remove(sp);
				sp=new JScrollPane(jt);
				c.deconnect();
				pan_aff1.add(sp);
				c.deconnect();
			}
		});
		
		/**************Affiche*********************///
		/*taff=new JTable();
		pan_aff.add(taff);*/
		pan_aff1=new JPanel();
		pan_aff.setLayout(null);
		reservations=new JButton("Reservations");
		pan_aff1.setBackground(Color.white);
		pan_aff1.setLocation(150,10);
		pan_aff1.setSize(480,200);
		//pan_aff1.setOpaque(false);

		reservations.setLocation(10,10);
		reservations.setSize(140,40);
		pan_aff.add(reservations);
		pan_aff.add(pan_aff1);
		pan_aff.setOpaque(false);
		pan_aff.setLocation(150,360);
		pan_aff.setSize(750,220);
		
		reservations.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Connect_base c=new Connect_base();
				c.connect();
				
				rs=c.affiche();
				AffichageJtable af=new AffichageJtable();
				jt=af.retourJtable(rs);
				sp=new JScrollPane(jt);
				c.deconnect();
				pan_aff1.add(sp);
	       

			}
		}
			);
		
		
		
		pan_supp.setBackground(Color.black);
		pan_mod.setBackground(Color.black);
		
		
		this.setBackground(Color.gray);
		this.add(pan_ajout);
		this.add(pan_mod);
		this.add(pan_supp);
	    this.add(pan_aff);
		
	    this.setBackground(new Color(0,191,255));
	}
	 public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }

}
