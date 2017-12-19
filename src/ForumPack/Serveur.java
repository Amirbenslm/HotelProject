package ForumPack;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class Serveur extends UnicastRemoteObject implements ServiceChat{
	//always add throws ,it's necessary
	Message msg;
	ArrayList<Message> data=new ArrayList<Message>();
	ArrayList<byte[]> file=new ArrayList<byte[]>();
	 Serveur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		if(System.getSecurityManager()==null)
			{Registry reg=LocateRegistry.createRegistry(2003);
			reg.rebind("chat", this);
			System.out.println("serveur lancé...");
			}
		
	}

	@Override
	public Message getMessage() throws RemoteException {
		// TODO Auto-generated method stub
		return msg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Serveur s=new Serveur();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	@Override
	public void setMessage(Message m) throws RemoteException {
		// TODO Auto-generated method stub
		msg=m;
	}

	@Override
	public void ajoutMessage(Message m) throws RemoteException {
		// TODO Auto-generated method stub
		data.add(m);
	}

	@Override
	public String getAllMessage() throws RemoteException {
		// TODO Auto-generated method stub
		 	String ch="";
			for(int i=0;i<data.size();i++)
			ch+=data.get(i).getId()+" : "+data.get(i).getMsg()+"\n";
		 	return ch;
	}

	@Override
	public byte[] getFile() throws RemoteException {
		// TODO Auto-generated method stub
		return file.get(0);
	}

	@Override
	public void addFile(byte[] b) throws RemoteException {
		// TODO Auto-generated method stub
		file.add(b);
	}
}
