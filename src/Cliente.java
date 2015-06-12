import java.io.PrintWriter;
import java.net.Socket;



public class Cliente extends  Thread{
	int Puerto,IdCliente;
	int Tiempo;
	static boolean boolClientes=true;
	
	String Ip,Mensage;
	
	public Cliente(String Ip,int IdCliente,String Mensage,int Puerto,int Tiempo,boolean boolClientes){
		
		this.Ip=Ip;
		this.Mensage=Mensage;	
		this.Puerto=Puerto;
		this.Tiempo=Tiempo;
		this.IdCliente=IdCliente;
		Cliente.boolClientes=boolClientes;
		
	}

	public void run() {
		
		
	while(boolClientes){
		try {
		    Thread.sleep(Tiempo*1000);
			Socket s=new Socket(Ip,Puerto);
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);	
			out.println(Mensage);
			System.out.println("Cliente :"+IdCliente+" envio mensaje: "+Mensage);
			s.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
		
	}
	
	
	

}
