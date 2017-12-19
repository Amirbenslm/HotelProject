package ForumPack;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public interface ServiceChat extends Remote{

	public Message getMessage()throws RemoteException;
	public void setMessage(Message m)throws RemoteException;
	public void ajoutMessage(Message m)throws RemoteException;
	public String getAllMessage()throws RemoteException;
	public byte[] getFile()throws RemoteException;
	public void addFile(byte[] b)throws RemoteException;
	
}
