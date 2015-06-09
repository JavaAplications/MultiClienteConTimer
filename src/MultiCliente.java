
public class MultiCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" MULTICLIENTE generando Clientes");

  int Tiempo = 15;
  int NumCliente=40;
  int Puerto=9002;
  String Ip="localhost";
  String Mensage="";
  Cliente c;
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
	  c=new Cliente(Ip, i, Mensage, Puerto, Tiempo);
	 c.start();
	
  }
  System.out.print("CLR");
  System.out.println(" MULTICLIENTE finalizado  con "+i+"clientes");

	}

}
