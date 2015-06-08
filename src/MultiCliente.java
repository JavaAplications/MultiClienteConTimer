
public class MultiCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(" MULTICLIENTE ON LINE");

  int Tiempo = 15;
  int NumCliente=46;
  int Puerto=9002;
  String Ip="localhost";
  String Mensage="";
  Cliente c;
  int randomNum =0;
  
  for(int i=1;i<=NumCliente;i++){
	  randomNum = 1 + (int)(Math.random()*100);
	 try {
		Thread.sleep(i*randomNum);
		  System.out.println(" randomNum: "+randomNum);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println(" Cliente N°:"+i);
	  Mensage=" "+i+" 1";
	  c=new Cliente(Ip, i, Mensage, Puerto, Tiempo);
	 c.start();
	
  }


	}

}
