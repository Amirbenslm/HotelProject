package promotionsPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Acceuilpack.Acceuil.Tilte;
import Reservationpack.Connect_base;

public class Promo extends JPanel {
	 Image bg1 = new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/Background/17.jpg").getImage();

JPanel pan1,pan2,pan3,pan4,pan5,pan6,pan_promo;
ImageIcon img1,img2,img3,img4,img5,img6,imgpromo;
JLabel label1,label2,label3,label4,label5,label6,labelpromo;
public Promo()
{this.setLayout(null);
/*pan_promo=new Tilte();
pan_promo.setBounds(70,10,800,90);*/
/***********promo*****************/
pan_promo=new JPanel();
pan_promo.setBounds(150,10,600,120);
imgpromo= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/p9.png");
Image imagepromo = imgpromo.getImage(); // transform it 
Image newimgpromo = imagepromo.getScaledInstance(600,120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imgpromo = new ImageIcon(newimgpromo);  // transform it back
labelpromo=new JLabel();
labelpromo.setIcon(imgpromo);
pan_promo.add(labelpromo);
pan_promo.setOpaque(false);
//pan_promo.setBackground(Color.blue);

Connect_base c=new Connect_base();
c.connect();
ResultSet count=c.affichepromotions();
int nbhot=0;
try {
	while(count.next())
		nbhot++;
	ResultSet rs=c.affichepromotions();
	
if(nbhot>0)
{rs.next();
/***********pan1*****************/
	System.out.println(rs.getString(1));
pan1=new JPanel();
pan1.setBounds(20,170,280,190);
img1= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image = img1.getImage(); // transform it 
Image newimg = image.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img1 = new ImageIcon(newimg);  // transform it back
label1=new JLabel();
label1.setIcon(img1);
pan1.add(label1);
pan1.setOpaque(false);
pan1.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));


nbhot--;
this.add(pan1);

}

/***********pan2*****************/
if(nbhot>0)
{rs.next();

pan2=new JPanel();
pan2.setBounds(330,170,280,190);
img2= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image2 = img2.getImage(); // transform it 
Image newimg2 = image2.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img2 = new ImageIcon(newimg2);  // transform it back
label2=new JLabel();
label2.setIcon(img2);
pan2.add(label2);
pan2.setOpaque(false);
//pan2.setBackground(Color.blue);
pan2.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));
nbhot--;
this.add(pan2);
}

/***********pan3*****************/
if(nbhot>0)
{rs.next();

pan3=new JPanel();
pan3.setBounds(650,170,280,190);
img3= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image3 = img3.getImage(); // transform it 
Image newimg3 = image3.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img3 = new ImageIcon(newimg3);  // transform it back
label3=new JLabel();
label3.setIcon(img3);
pan3.add(label3);
pan3.setOpaque(false);
//pan3.setBackground(Color.blue);
pan3.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));
nbhot--;
this.add(pan3);
}

/***********pan4*****************/
if(nbhot>0)
{System.out.println(nbhot);
rs.next();

pan4=new JPanel();
pan4.setBounds(20,370,280,190);
img4= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image4 = img4.getImage(); // transform it 
Image newimg4 = image4.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img4 = new ImageIcon(newimg4);  // transform it back
label4=new JLabel();
label4.setIcon(img4);
pan4.add(label4);
pan4.setOpaque(false);
//pan4.setBackground(Color.blue);
pan4.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));
nbhot--;
this.add(pan4);
}
/***********pan5*****************/
if(nbhot>0)
{rs.next();
pan5=new JPanel();
pan5.setBounds(330,370,280,190);
img5= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image5 = img5.getImage(); // transform it 
Image newimg5 = image5.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img5 = new ImageIcon(newimg5);  // transform it back
label5=new JLabel();
label5.setIcon(img5);
pan5.add(label5);
pan5.setOpaque(false);
//pan5.setBackground(Color.blue);
pan5.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));
nbhot--;
this.add(pan5);
}
/***********pan6*****************/
if(nbhot>0)
{rs.next();
pan6=new JPanel();
pan6.setBounds(650,370,280,190);
img6= new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/1.jpg");
Image image6 = img6.getImage(); // transform it 
Image newimg6 = image6.getScaledInstance(280,190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
img6 = new ImageIcon(newimg6);  // transform it back
label6=new JLabel();
label6.setIcon(img6);
pan6.add(label6);
pan6.setOpaque(false);
pan6.addMouseListener(new voirhotel("/home/amir/Documents/tpjava/Hotel/src/Images/"+rs.getString(1)+"/"));
this.add(pan6);
nbhot--;
}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


this.setBackground(new Color(49, 140, 231));
this.add(pan_promo);
}
class Tilte extends JPanel{
	 public void paint(Graphics g) {
		    Dimension d = this.getPreferredSize();
		 
		    int fontSize = 70;

		    g.setFont(new Font("Helvetica", Font.ITALIC, fontSize));
		     
		    g.setColor(new Color(167, 103, 38));
		    //g.setColor(Color.white);
		    g.drawString("PROMOTIONS", 100, 90);
		  }
	}
/*public void paintComponent(Graphics g) {
    g.drawImage(bg1, 0, 0, getWidth(), getHeight(), this);
}*/
}
