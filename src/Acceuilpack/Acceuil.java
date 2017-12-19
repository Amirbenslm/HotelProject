package Acceuilpack;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

import com.toedter.calendar.JDateChooser;

import Reservationpack.Connect_base;

public class Acceuil extends JPanel {
	  Image bg = new ImageIcon("Images/Background/17.jpg").getImage();
	JPanel pan_ajout,pan_hotel,pan_title;
	JLabel lid_client,lnom,lprenom,lcin,ldatenaiss,ltele,lemail,lnom_hot,lville_hot,ltel_hot,etoile,lpromo,lparking,lplage;
	JTextField tid_client,tnom,tprenom,tcin,ttele,temail,tnom_hot,ttel_hot,tville_hot;
	JButton ajout,reset,hot_ajout,hot_reset,afficher;
	JComboBox<String> cb_etoile;
	JCheckBox ch_plage,ch_promo,ch_parking;
	JList listhot;
	JScrollPane splist;
	DefaultListModel dlm;
	JDateChooser tdatenaiss;
	public Acceuil()
	{this.setLayout(null);
	/*************Ajout Client***********************/
	ajout=new JButton("Ajouter");
	reset=new JButton("Reset");
	pan_ajout=new JPanel();
	lid_client=new JLabel("ID_client:");
	lnom=new JLabel("nom:");
	lprenom=new JLabel("prenom:");
	lcin=new JLabel("Cin:");
	ldatenaiss=new JLabel("DateNaissance:");
	ltele=new JLabel("N° telephone:");
	lemail=new JLabel("Email");
	tid_client=new JTextField("ID_client");
	tnom=new JTextField("nom");
	tprenom=new JTextField("prenom");
	tcin=new JTextField("Cin");
	tdatenaiss=new JDateChooser();
	ttele=new JTextField("N° telephone");
	temail=new JTextField("Email");
	
	tid_client.addMouseListener(new ClassMouse());
	tnom.addMouseListener(new ClassMouse());
	tprenom.addMouseListener(new ClassMouse());
	tcin.addMouseListener(new ClassMouse());
	tdatenaiss.addMouseListener(new ClassMouse());
	temail.addMouseListener(new ClassMouse());
	ttele.addMouseListener(new ClassMouse());
	GridLayout aj=new GridLayout(7,2);
	aj.setVgap(6);
	pan_ajout.setLayout(aj);
	pan_ajout.setBorder(BorderFactory.createTitledBorder("Ajouter Client"));
	pan_ajout.add(lid_client);
	pan_ajout.add(tid_client);
	pan_ajout.add(lcin);
	pan_ajout.add(tcin);
	pan_ajout.add(lnom);
	pan_ajout.add(tnom);
	pan_ajout.add(lprenom);
	pan_ajout.add(tprenom);
	pan_ajout.add(ldatenaiss);
	pan_ajout.add(tdatenaiss);
	pan_ajout.add(lemail);
	pan_ajout.add(temail);
	pan_ajout.add(ltele);
	pan_ajout.add(ttele);
	
	pan_ajout.setBounds(30,110,300,400);
	pan_ajout.setOpaque(false);
    reset.setBounds(210,520,100,40);
    ajout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		   if(isValidCIN(tcin.getText())&& isValidTel(ttele.getText())&&isCINExist() )
		   {
			System.out.println(temail.getText());
			 Connect_base cb=new Connect_base();
			new SendMail(temail.getText());
			cb.connect();
			java.util.Date bir=tdatenaiss.getDate();
			java.sql.Date d = new java.sql.Date(bir.getTime());
			cb.ajoutclient(tid_client.getText(),tcin.getText(),tnom.getText(),tprenom.getText(),d.toString(),temail.getText(),ttele.getText());
			
			cb.deconnect();			
		}}
	});
    reset.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tid_client.setText("");
			tnom.setText("");
			tprenom.setText("");
			tcin.setText("");
			temail.setText("");
			ttele.setText("");
		}
	});
    ajout.setBounds(50,520,100,40);
    /******************Affichage Liste Hotel************************/
    afficher=new JButton("Afficher");
    afficher.setBounds(420,520,120,40);
    splist=new JScrollPane();;
    dlm=new DefaultListModel();
    listhot=new JList();
	Connect_base c=new Connect_base();
    c.connect();
    ResultSet rst=c.afficheHotel();

    
    try {
		while(rst.next()){
		dlm.addElement("  "+rst.getString(2).toUpperCase()+"   "+rst.getString(3).toUpperCase());
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    listhot.setModel(dlm);
    listhot.setCellRenderer(new TransparentListCellRenderer());
    listhot.setOpaque(false);
    splist=new JScrollPane(listhot);
    splist.setEnabled(false);
    
    splist.getViewport().setOpaque(false);
    splist.setOpaque(false);
    splist.setBounds(360,270,280,250);
splist.setVisible(false);
    afficher.addActionListener(new ActionListener() {
    		
		@Override
		public void actionPerformed(ActionEvent e) {
			splist.setVisible(true);	
		}
		
	});
    
    
    /***************** Ajouter un Hotel****************************/
    hot_ajout=new JButton("Ajouter");
	hot_reset=new JButton("Reset");
	pan_hotel=new JPanel();
	GridLayout ajh=new GridLayout(7,2);
	ajh.setVgap(6);
	pan_hotel.setLayout(ajh);
	pan_hotel.setBorder(BorderFactory.createTitledBorder("Ajouter Hotel"));
	lnom_hot=new JLabel("Nom de l'hotel:");
	tnom_hot=new JTextField();
	lville_hot=new JLabel("Ville:");
	tville_hot=new JTextField();
	etoile=new JLabel("Nombre d'etoiles:");
	etoile.setBounds(20,90,120,40);
	cb_etoile=new JComboBox<String>();
	cb_etoile.addItem("3 Etoiles");
	cb_etoile.addItem("4 Etoiles");
	cb_etoile.addItem("5 Etoiles");
	ltel_hot=new JLabel("N° telephone");
	ttel_hot=new JTextField();
	lpromo=new JLabel("Promotions:");
	ch_promo=new JCheckBox("Oui");
	lparking=new JLabel("Accès à la parking:");
	ch_parking=new JCheckBox("Oui");
	lplage=new JLabel("Accès à la plage:");
	ch_plage=new JCheckBox("Oui");
ch_parking.setOpaque(false);
ch_plage.setOpaque(false);
ch_promo.setOpaque(false);

    pan_hotel.add(lnom_hot);
    pan_hotel.add(tnom_hot);
    pan_hotel.add(lville_hot);
    pan_hotel.add(tville_hot);
    pan_hotel.add(etoile);
    pan_hotel.add(cb_etoile);
    pan_hotel.add(ltel_hot);
    pan_hotel.add(ttel_hot);
    pan_hotel.add(lplage);
    pan_hotel.add(ch_plage);
    pan_hotel.add(lparking);
    pan_hotel.add(ch_parking);
    pan_hotel.add(lpromo);
    pan_hotel.add(ch_promo);
    pan_hotel.setOpaque(false);
    hot_ajout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(isValidTel(ttel_hot.getText()))
			{
			String plag="non",pro="non",park="non";
			if(ch_plage.isSelected()==true)
				plag="oui";
			if(ch_parking.isSelected()==true)
				park="oui";
			if(ch_promo.isSelected()==true)
				pro="oui";
			Connect_base c=new Connect_base();
			c.connect();
			c.ajoutHotel(tnom_hot.getText()+"_"+tville_hot.getText(),tnom_hot.getText(),tville_hot.getText(),(String)cb_etoile.getSelectedItem(),plag,park,pro,ttel_hot.getText());
		}}
	});
	hot_reset.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tnom_hot.setText("");
			tville_hot.setText("");
			ttel_hot.setText("");
			ch_parking.setSelected(false);
			ch_plage.setSelected(false);
			ch_promo.setSelected(false);
		}
	});
    
	pan_hotel.setBounds(670,110,300,400);
	hot_reset.setBounds(840,520,100,40);
	hot_ajout.setBounds(680,520,100,40);
	
	pan_title=new Tilte();
    pan_title.setBounds(70,10,800,90);
   
    this.add(pan_title);
    this.add(hot_ajout);
    this.add(hot_reset);
    this.add(pan_hotel);
    this.add(reset);
    this.add(ajout);
	this.add(pan_ajout);
	//this.setBackground(new Color(0,191,255));
	this.add(splist);
	this.add(afficher);
	}

	public class Tilte extends JPanel{
	 public void paint(Graphics g) {
		    Dimension d = this.getPreferredSize();
		 
		    int fontSize = 50;

		    g.setFont(new Font("Helvetica", Font.ITALIC, fontSize));
		     
		    g.setColor(new Color(167, 103, 38));
		    //g.setColor(Color.white);
		    g.drawString("Hotel Management System", 100, 50);
		  }
	}
	class ClassMouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==tid_client)
				tid_client.setText("");
			if(e.getSource()==tcin)
				tcin.setText("");
			if(e.getSource()==tnom)
				tnom.setText("");
			if(e.getSource()==tprenom)
				tprenom.setText("");
			if(e.getSource()==temail)
				temail.setText("");
			if(e.getSource()==ttele)
				ttele.setText("");
		}

		@Override
		public void mousePressed(MouseEvent e) {
	
					
		}

		@Override
		public void mouseReleased(MouseEvent e) {
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
		
	}
	  
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	    public class TransparentListCellRenderer extends DefaultListCellRenderer {

	        @Override
	        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	            setOpaque(isSelected);
	            setForeground(new Color(167, 103, 38));
	            return this;
	        }

	    }
	    private boolean isValidCIN(String cin) {
			if (!(cin.length()==8) && (!(cin.matches("\\d\\d\\d\\d\\d\\d\\d\\d")) ) )
			{JOptionPane.showMessageDialog(null,"CIN Non Valide :D"," ",JOptionPane.WARNING_MESSAGE);
			return false;}
		
		return true;	
	    }
	    private boolean isValidTel(String tel) {
			if (!(tel.length()==8) && (!(tel.matches("\\d\\d\\d\\d\\d\\d\\d\\d")) ) )
			{JOptionPane.showMessageDialog(null,"Numéro téléphonique  Non Valide :D"," ",JOptionPane.WARNING_MESSAGE);
			return false;}
		
		return true;	
	    }
	    protected boolean isCINExist() {
	    	Connect_base c=new Connect_base();
	    	c.connect();
			String cin=tcin.getText();
				ResultSet rs=c.afficheisValidCIN(cin);
				int count=0;
				try {
					if(rs.next())
						count++;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if(count>0)
					{JOptionPane.showMessageDialog(this, "CIN Existe","Erreur",JOptionPane.ERROR_MESSAGE);
			return false;
			}
				return true;
		}
	    
	}


