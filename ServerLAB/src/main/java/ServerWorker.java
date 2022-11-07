import java.io.*;
import java.net.*;

//classe thread che svolge task client
public class ServerWorker extends Thread{

	private Socket socket;
	
	private ObjectInput in;
	private ObjectOutput out;
	
	public ServerWorker(Socket socket) {
		
		try {
			this.socket = socket;
			this.out = new ObjectOutputStream(this.socket.getOutputStream());
			this.in = new ObjectInputStream(this.socket.getInputStream());
			
		} catch (IOException e) {}
		
		start(); //lancia i thread per permettere di eseguire metodo run()
	}
	
	//ereditato dalla classe thread --> metodo che gestisce le task del client
	public void run() {
		
		
		
	}
	


}
