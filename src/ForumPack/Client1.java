package ForumPack;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Reservationpack.Connect_base;

	public class Client1 extends JPanel{
		 Image bg1 = new ImageIcon("/home/amir/Documents/tpjava/Hotel/src/Images/Background/17.jpg").getImage();

		JPanel panel;
		JTextField NewMsg;
		JTextArea ChatHistory;
		JButton Send;
		Remote r;
		Registry reg;
		private ServiceChat chat;
		JButton envf;
		JButton recuf;
		String id;
JScrollPane jsp,jspliste;
JList liste;
		
	public	Client1()
		{initGraphe();
		System.out.println("client connecté");

			try {
				reg = LocateRegistry.getRegistry("127.0.0.1",2003);
				 r=reg.lookup("chat");
			} catch (RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(r instanceof ServiceChat)
				{chat=((ServiceChat)r);
				 new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					while(true){try {
						ChatHistory.setText(chat.getAllMessage());
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					}}).start();
				}else System.out.println("ce n'est une instance du service");
	
		
			
		}
	public static void main(String [] args )
	{
		Client1 c=new Client1();
		
			
		
	}
		
		public void initGraphe(){
			//id=JOptionPane.showInputDialog(null,"saisir votre id","id",1);
			 
			id="SMH-Nabeul";
			
			NewMsg = new JTextField();
			ChatHistory = new JTextArea();
			ChatHistory.setEditable(false);
			ChatHistory.setLineWrap(true);
			Send = new JButton("Send");
		ChatHistory.setOpaque(false);
			this.setLayout(null);
			jsp=new JScrollPane(ChatHistory);
			ChatHistory.setBounds(20, 40, 850, 360);
			jsp.setBounds(20, 40, 650, 360);
			jsp.setOpaque(false);
			jsp.getViewport().setOpaque(false);
			envf=new JButton("envoyer fichier");
			recuf=new JButton("recevoir fichier");
			this.add(jsp);
			NewMsg.setBounds(20, 420, 340, 50);
			this.add(NewMsg);
			Send.setBounds(375, 420, 95, 30);
			Send.setBackground(new Color(115, 194, 251));
			this.add(Send);
			envf.setBounds(30, 490, 150, 30);
			envf.setBackground(new Color(115, 194, 251));
			this.add(envf);
			recuf.setBounds(190, 490, 150, 30);
			recuf.setBackground(new Color(115, 194, 251));
			this.add(recuf);
			DefaultListModel<String> dlm=new DefaultListModel<String>();
			
			Connect_base cb=new Connect_base();
			 cb.connect();
			 ResultSet rs=cb.affiche();
			 try {
				while(rs.next())
				 {
					 dlm.addElement(rs.getString(1));
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			 
			 liste=new JList(dlm);
             liste.setOpaque(false);
             liste.setSelectedIndex(0);
             //liste.addListSelectionListener(this);
             System.out.println(dlm.getElementAt(liste.getSelectedIndex()).toString());

             jspliste=new JScrollPane(liste);
             jspliste.setBounds(800,50,150,360);
 			jspliste.getViewport().setOpaque(false);
 			jspliste.setOpaque(false);
 			liste.setOpaque(false);
		this.add(jspliste);
			Send.addActionListener(new ActionListener() {
				

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						chat.ajoutMessage(new Message(id,NewMsg.getText()));
						NewMsg.setText("");
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			});
			envf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					File f=new File("C:/Users/Chakib/Desktop/starbucks.psd");
					try {
						FileInputStream fis=new FileInputStream(f);
						byte[] b=new byte[(int) f.length()]; 
						fis.read(b);
						fis.close();
						chat.addFile(b);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			recuf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					byte[] b;
					try {
						b = chat.getFile();
						FileOutputStream f=new FileOutputStream(new File("C:/Users/Chakib/Desktop/JavaUpDowLoad/JavaServer/starbucks.psd"));
						f.write(b);
						f.flush();
						f.close();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		
		}
		 public void paintComponent(Graphics g) {
		        g.drawImage(bg1, 0, 0, getWidth(), getHeight(), this);
		    }
	}