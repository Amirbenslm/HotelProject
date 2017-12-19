package promotionsPack;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class voirhotel extends JFrame implements MouseListener,ActionListener{
String path;
int i=1;
//ImageIcon img = new ImageIcon(path+"1.jpg");
ImageIcon imageIcon; 
JLabel imgLbl =	new JLabel();
JButton btnNext	=	new JButton("Next>>");
JButton btnPrevious	=	new JButton("<<Previous");	
public voirhotel(String s)
{this.path=s;

	}
@Override
public void mouseClicked(MouseEvent e) {
	//setSize(650,585);
	setBounds(100,50, 650, 585);
	setLayout(null);
	add(imgLbl);
	imgLbl.setBackground(Color.blue);
	imgLbl.setOpaque(true);
	imgLbl.setBounds(20,10,600,500);
	add(btnNext);
	add(btnPrevious);
	btnNext.setBounds(320,520,115,30);
	btnPrevious.setBounds(200,520,115,30);
	btnNext.addActionListener(this);
	btnPrevious.addActionListener(this);
	//img = new ImageIcon(path+11+".jpg");
	
	ImageIcon imageIcon = new ImageIcon(path+1+".jpg"); // load the image to a imageIcon
	Image image = imageIcon.getImage(); // transform it 
	Image newimg = image.getScaledInstance(600,500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	imageIcon = new ImageIcon(newimg);  // transform it back
	
	imgLbl.setIcon(imageIcon);
	setVisible(true);	
}
public void next(){
	System.out.println("next i="+i);

	if(i>=8){	
i=1;
}
else{
i++;
}
/*img = new ImageIcon(path+i+".jpg");
imgLbl.setIcon(img);*/
 imageIcon = new ImageIcon(path+i+".jpg"); // load the image to a imageIcon
Image image = imageIcon.getImage(); // transform it 
Image newimg = image.getScaledInstance(600,500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon = new ImageIcon(newimg);  // transform it back

imgLbl.setIcon(imageIcon);

}
public void previous(){
System.out.println("previous i="+i);
if (i <= 1) {
i = 8;

}
else
{
i--;
}
/*img = new ImageIcon(path+i+".jpg");
imgLbl.setIcon(img);*/
 imageIcon = new ImageIcon(path+i+".jpg"); // load the image to a imageIcon
Image image = imageIcon.getImage(); // transform it 
Image newimg = image.getScaledInstance(600,500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon = new ImageIcon(newimg);  // transform it back

imgLbl.setIcon(imageIcon);
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
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
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnNext){
		next();
		}
		if(e.getSource()==btnPrevious){
		previous();
		}
		}
	
}
	


