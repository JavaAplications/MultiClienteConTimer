package BBDD;

import java.sql.*;

public class Conexion {
	Connection con=null;
public Conexion() {
		
	}

public  Connection Conectar(){
	
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/bdradiobases","root","");	
		
	} catch (Exception e) {
		System.out.println("No se pudo conectar");
	}
	return con;
	
}

public void InsertarBufferKA(String[] buffer,int LongitudBuffer){
	int IdRadio = 0;
	int i=0;
	int radiobases=0;
	con=Conectar();
	String ComandoSQL="(?)";
	PreparedStatement pst;
	
	for(i=0;i<LongitudBuffer;i++){
		
		
		IdRadio=Integer.parseInt(buffer[i]);
		
		System.out.print("IdRadio:"+IdRadio);
		radiobases++;
		
	}
	
	System.out.println();
	
	try {
		for(i=1;i<LongitudBuffer;i++){
			
			
			ComandoSQL=ComandoSQL+",(?)";
		}
		
		
		pst = con.prepareStatement("INSERT INTO keepalive (IdRadios) VALUES "+ComandoSQL);
		System.out.println("INSERT INTO keepalive (IdRadios) VALUES "+ComandoSQL);
		for(i=1;i<LongitudBuffer+1;i++){
		pst.setInt(i,Integer.parseInt(buffer[i-1]));
	
		}
		long inicio=System.currentTimeMillis();
		pst.execute();
		
		long fin =System.currentTimeMillis()-inicio;
		System.out.println("Es Grabaron "+radiobases+"KA en "+fin+" milisegundos");
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void InsertarEventos(int IdRadio,int IdAlarma){
	
	con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO eventos (IdRadios,IdAlarmas) VALUES (?,?)");
		
			pst.setInt(1,IdRadio);
			pst.setInt(2,IdAlarma);
			
			pst.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}

public void InsertarKeepAlive(int IdRadio){
	
	con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO keepalive (IdRadios) VALUES (?)");
		
			pst.setInt(1,IdRadio);
			
			pst.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

public void InsertarRadiobases(String NomRadio,String TelRadio,String LatRadio,String LongRadio,
		String LocRadio,String ProvRadio,String ContacRadio){
	
	con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO Radiobases (NomRadio,TelRadio,LatRadio,LongRadio,"
					+ "LocRadio, ProvRadio, ContacRadio) "
					+ "VALUES (?,?,?,?,?,?,?)");
		
			pst.setString(1,NomRadio);
			pst.setString(2,TelRadio);
			pst.setString(3,LatRadio);
			pst.setString(4,LongRadio);
			pst.setString(5,LocRadio);
			pst.setString(6,ProvRadio);
			pst.setString(7,ContacRadio);
			
			
			pst.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		

}

public ResultSet ListarNombres(int IdRadiobase)
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	String NombreRadio = null;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT `NomRadio` FROM `radiobases`");
	
		con.close();
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
	
	return rs;
}
	

public String ConsultarNombre(int IdRadiobase)
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	String NombreRadio = null;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT `NomRadio` FROM `radiobases` WHERE `IdRadios`='"+IdRadiobase+"'");
		while(rs.next()){
			NombreRadio=  rs.getString("NomRadio");
				
					
		}
		con.close();
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 NombreRadio="Desconocido";
	}
	
	return NombreRadio;
}
	


public int CantidadRadiobases()
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	int cantidad = 0 ;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT * FROM `radiobases`");
		
		rs.last();
		cantidad=rs.getRow();
		con.close();
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cantidad=0;
	}
	
	return cantidad;
}
	

}
