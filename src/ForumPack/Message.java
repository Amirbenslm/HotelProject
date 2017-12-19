package ForumPack;
import java.io.Serializable;


public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id,msg;

	public Message(String id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
