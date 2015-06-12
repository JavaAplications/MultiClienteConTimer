
public class MultiCliente extends Thread{

	static Ventanaclientes ventana;

	  int Tiempo = 15;
	  int NumCliente=40;
	  int Puerto=9002; 
	  String Ip="localhost";
	  String Mensage="";
	  Cliente c;

	public MultiCliente(int Tiempo,int NumCliente){
	
		this.NumCliente=NumCliente;
		this.Tiempo=Tiempo;
		
		
	}
	
	public void run(){	
		// TODO Auto-generated method stub
System.out.println(" MULTICLIENTE generando Clientes");

  int randomNum =0;
  int i;
  for(i=1;i<=NumCliente;i++){
	  randomNum = 1 + (int)(Math.random()*10);
	 try {
		Thread.sleep(i*randomNum);
		 // System.out.println(" randomNum: "+randomNum);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//  System.out.println(" Cliente N°:"+i+" creado");
	  Mensage=" "+i+" 1";
	  c=new Cliente(Ip, i, Mensage, Puerto, Tiempo,true);
	 c.start();
	
  }
  System.out.print("CLR");
  System.out.println(" MULTICLIENTE finalizado  con "+i+"clientes");

	}

}
