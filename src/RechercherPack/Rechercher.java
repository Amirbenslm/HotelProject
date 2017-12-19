package RechercherPack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import promotionsPack.voirhotel;

import Reservationpack.Connect_base;

public class Rechercher extends JPanel{
	 Image bg1 = new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/Background/17.jpg").getImage();
	JPanel Critere,affichage;
	JLabel dest,etoile,plage,parking,imglbl,imglbl2,imglbl3,nomhotel,nomhotel2,nomhotel3,lpromo;
	JTextField tdest;
	JComboBox<String> cb_etoile;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JCheckBox chb,ch_promo;
	JTextArea ta,ta2,ta3;
	JButton filtrer;
	ImageIcon img1,img2,img3;
	public Rechercher()
	{this.setLayout(null);
	Critere=new JPanel();
Critere.setBorder(BorderFactory.createTitledBorder("Filtrer par :"));
		Critere.setLayout(null);
		/***************Panel Rechercher selon les critere*************/
		dest=new JLabel("Destination:");
		//tdest=new JTextField();
		String[] dict = { "Nabeul", "Sousse", "Sfax", "Monastir","Tunis",
				"Hammamet"};
		 tdest = AutoCompleteDocument.createAutoCompleteTextField(dict);
		//dest.setBackground(Color.black);
		//dest.setOpaque(true);
		tdest.setBounds(20,60,150,35);
		dest.setBounds(20,20,120,40);
		
		etoile=new JLabel("Etoiles:");
		etoile.setBounds(20,90,120,40);
		cb_etoile=new JComboBox<String>();
		cb_etoile.addItem("3 Etoiles");
		cb_etoile.addItem("4 Etoiles");
		cb_etoile.addItem("5 Etoiles");
		cb_etoile.setBounds(20,130,120,35);
		plage=new JLabel("Accès à la plage:");
		plage.setBounds(20,170,120,40);
		r1=new JRadioButton("Oui");
		r2=new JRadioButton("Non");
		r1.setOpaque(false);
		r2.setOpaque(false);
		bg=new ButtonGroup();
		bg.add(r1);bg.add(r2);
		r1.setBounds(20,210,50,35);
		r2.setBounds(80,210,55,35);
		parking=new JLabel("Accès à la parking:");
		parking.setBounds(20,255,150,40);
		chb=new JCheckBox("Oui");
		chb.setOpaque(false);
		chb.setBounds(20,300,55,35);
		lpromo=new JLabel("Promotions:");
		lpromo.setBounds(20,340,120,40);
		ch_promo=new JCheckBox("Oui");
		ch_promo.setOpaque(false);
		ch_promo.setBounds(20,380,55,35);
		filtrer=new JButton("Filtrer");
		filtrer.setBounds(30,450,130,40);
		filtrer.setBackground(new Color(115, 194, 251));
		filtrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imglbl3.setIcon(null);
				ta3.setText("");
				nomhotel3.setText("");
			Connect_base c=new Connect_base();
			c.connect();
			String plg="non",park="non",pro="non";
			if (r1.isSelected()==true)
				plg="oui";
			if(chb.isSelected()==true)
				park="oui";
			if(ch_promo.isSelected()==true)
				pro="oui";
			System.out.println(tdest.getText().toLowerCase()+(String)cb_etoile.getSelectedItem()+plg+park+pro);
			ResultSet rs=c.filtrerHotel(tdest.getText().toLowerCase(),"NULL",plg,park,pro);
			ResultSet count=rs;
				int nbhot=0;
				
			try {
				while(count.next())
                   nbhot ++;
				System.out.println("nombre="+nbhot);
				 rs=c.filtrerHotel(tdest.getText().toLowerCase(),"NULL",plg,park,pro);
				 if(nbhot>0)	
				 {	rs.next();
				
				String h=rs.getString(2);
				System.out.println(h);
			
			img1= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+h+"/1.jpg");
			Image image = img1.getImage(); // transform it 
			Image newimg = image.getScaledInstance(200,125,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			img1 = new ImageIcon(newimg);  // transform it back
			imglbl.setIcon(img1);
			imglbl.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(2)+"/"));

			nomhotel.setText(h);
			System.out.println(rs.getString(9));
			ta.setText(rs.getString(9));
			nbhot--;
				 }
				 ta.setLineWrap(true);
				 ta2.setLineWrap(true);
				 ta3.setLineWrap(true);
		//if(rs.next()==false)
			if(nbhot>0)
			{rs.next();
			System.out.println(rs.getString(2));
		img2= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(2)+"/1.jpg");
		Image image2 = img2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(200,125,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		img2 = new ImageIcon(newimg2);  // transform it back
		imglbl2.setIcon(img2);
		imglbl2.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(2)+"/"));

		String sm=rs.getString(2);
		
		nomhotel2.setText(sm);
		System.out.println(rs.getString(9));
		ta2.setText(rs.getString(9));
		nbhot--;	}
			if(nbhot>0)
		{rs.next();
		System.out.println(rs.getString(2));
	img3= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(2)+"/1.jpg");
	Image image3 = img3.getImage(); // transform it 
	Image newimg3 = image3.getScaledInstance(200,125,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	img3 = new ImageIcon(newimg3);  // transform it back
	imglbl3.setIcon(img3);
	imglbl3.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(2)+"/"));

	nomhotel3.setText(rs.getString(2));
	System.out.println(rs.getString(9));
	ta3.setText(rs.getString(9));
			}
		} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
/*******************Panel affichage les hotels rechercher****************************/
	affichage=new JPanel();
	affichage.setLayout(null);
	//affichage.setBackground(Color.red);
	affichage.setOpaque(false);
	affichage.setBounds(240,20,750,550);
	/**********hotel1**************/
	imglbl=new JLabel();	
	imglbl.setBounds(10,10,150,150);
	imglbl.setOpaque(false);
	//imglbl.setBackground(Color.BLACK);
	nomhotel=new JLabel();
	nomhotel.setOpaque(true);
	//nomhotel.setBackground(Color.BLACK);
	nomhotel.setBounds(180,10,250,40);
	nomhotel.setOpaque(false);
	ta=new JTextArea();
	ta.setBounds(180,60,550,100);
	//ta.setBackground(Color.BLACK);
	ta.setOpaque(false);
	ta.setEditable(false);
	/**********hotel2**************/
	imglbl2=new JLabel();	
	imglbl2.setBounds(10,180,150,150);
	imglbl2.setOpaque(false);
	imglbl2.setBackground(Color.BLACK);
	nomhotel2=new JLabel();
	nomhotel2.setOpaque(false);
	//nomhotel2.setBackground(Color.BLACK);
	nomhotel2.setBounds(180,235,250,40);
	ta2=new JTextArea();
	ta2.setOpaque(false);
	ta2.setBounds(180,280,550,100);
	ta2.setEditable(false);
	//ta2.setBackground(Color.BLACK);
	/**********hotel3**************/
	imglbl3=new JLabel();	
	imglbl3.setBounds(10,360,150,150);
	imglbl3.setOpaque(false);
	imglbl3.setBackground(Color.BLACK);
	nomhotel3=new JLabel();
	//nomhotel3.setOpaque(true);
	//nomhotel3.setBackground(Color.BLACK);
	nomhotel3.setOpaque(false);
	nomhotel3.setBounds(180,360,250,40);
	ta3=new JTextArea();
	ta3.setOpaque(false);
	ta3.setBounds(180,410,550,100);
	ta3.setBackground(Color.BLACK);
	ta3.setEditable(false);
	
	
	
	affichage.add(nomhotel);
	affichage.add(imglbl);
	affichage.add(nomhotel);
	affichage.add(ta);	
	affichage.add(imglbl2);	
	affichage.add(nomhotel2);
	affichage.add(ta2);
	affichage.add(imglbl3);
	affichage.add(nomhotel3);
	affichage.add(ta3);	
		
		//Critere.setBackground(Color.BLUE);
	Critere.setOpaque(false);
		Critere.setBounds(10,20,220,550);
		Critere.add(chb);
		Critere.add(lpromo);
		Critere.add(ch_promo);
		Critere.add(parking);
		Critere.add(r1);
		Critere.add(r2);	
		Critere.add(plage);
		Critere.add(cb_etoile);
		Critere.add(etoile);
		Critere.add(dest);
		Critere.add(tdest);
		Critere.add(filtrer);
		this.add(Critere);
		this.add(affichage);
		
	}
	 public void paintComponent(Graphics g) {
	        g.drawImage(bg1, 0, 0, getWidth(), getHeight(), this);
	    }

}
/* L hébergement indépendant Douja Apartment se trouve à Nabeul. La connexion Wi-Fi est gratuite. Cet appartement comporte une télévision, la climatisation et un coin salon.*/