package promotionsPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Promotions1 extends JPanel{
	 Image bg1 = new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/Background/17.jpg").getImage();

	JPanel sultane,kheops,kheops1,sendebed,corail,princesse,pan_promo;
	ImageIcon img,img1,img2,img3,imgpromo ;
	JLabel imgLbl,imgLbl1,imgLbl2,imgLbl3,promos ;
JTextField jt1;
	public Promotions1()
	{/*GridLayout gl=new GridLayout(2,3);
	gl.setHgap(50);
		this.setLayout(gl);*/
		this.setLayout(null);
	sultane =new JPanel();

	/***************Promotions **********************/
	pan_promo=new JPanel();
	imgpromo= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/p8.png");
	promos =new JLabel();
	Image image = imgpromo.getImage(); // transform it 
	Image newimg = image.getScaledInstance(600,125,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	imgpromo = new ImageIcon(newimg);  // transform it back
	promos.setIcon(imgpromo);
	pan_promo.add(promos);
	pan_promo.setOpaque(false);
	pan_promo.setBounds(130,10,600,120);
	/*********Hotel LeCorail*************/
	corail =new JPanel();
	JPanel corail1=new JPanel();
	//JLabel jlcor=new JLabel("Hotel Le Corail  ");
	img1= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/leCorail/1234.jpg");
	imgLbl1 =	new JLabel(img1);
	//imgLbl1.setPreferredSize(new Dimension(300,169));
	corail.setBackground(Color.GRAY);
	corail1.add(imgLbl1);
	//corail1.add(jlcor);
	corail1.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/leCorail/"));
	corail.add(corail1);
	//corail1.setOpaque(false);
	//corail.setOpaque(false);
	corail.setBounds(20,170,280,190);
	
	/************Hotel Kheops*************************/
	kheops =new JPanel();
	kheops1 =new JPanel();
	img= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/kheops/12345.jpg");
	imgLbl =new JLabel(img);
	//imgLbl.setPreferredSize(new Dimension(300,169));
	//JLabel jl1=new JLabel("Hotel Kheops");
	kheops1.add(imgLbl);
	//kheops1.add(jl1);
	kheops1.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/kheops/"));
	kheops1.setOpaque(false);
	//kheops.setOpaque(false);

	kheops1.setBackground(Color.GRAY);	
	kheops.add(kheops1);
	kheops.setOpaque(false);
	kheops.setBounds(20,360,280,200);
	/********Hotel  sultane********************/
	
	sultane =new JPanel();
	JPanel sultane1=new JPanel();
	//JLabel jlsol=new JLabel("Hotel Soltane");
	img2= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/soltane/12.jpg");
	imgLbl2 =	new JLabel(img2);
	//imgLbl1.setPreferredSize(new Dimension(300,169));
	sultane1.setBackground(Color.GRAY);
	sultane1.add(imgLbl2);
	//sultane1.add(jlsol);
	sultane1.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/soltane/"));
	sultane.add(sultane1);
	sultane.setOpaque(false);
	sultane.setBounds(550,170,280,200);
	/************Hotel Princesse**********************/
	princesse =new JPanel();
	JPanel princesse1=new JPanel();
	//JLabel jlprinc=new JLabel("Hotel Princesse");
	img3= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/princesse/12.jpg");
	imgLbl3 =	new JLabel(img3);
	princesse1.setBackground(Color.GRAY);

	princesse1.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/princesse/"));
//princesse1.setOpaque(false);
	//princesse1.setBackground(Color.white);
princesse.setOpaque(false);

princesse1.add(imgLbl3);
	//princesse1.add(jlprinc);
	princesse.add(princesse1);
	princesse.setBounds(550,360,400,200);
	
	
	
	
	
	this.setBackground(Color.gray);
	this.add(kheops);
	this.add(corail);
	this.add(sultane);
	this.add(princesse);
	this.add(pan_promo);
	this.setBackground(new Color(0,191,255));
	}
	 public void paintComponent(Graphics g) {
	        g.drawImage(bg1, 0, 0, getWidth(), getHeight(), this);
	    }

}
