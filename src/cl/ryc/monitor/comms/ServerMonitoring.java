package cl.ryc.monitor.comms;

import java.net.*;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.*;

public class ServerMonitoring {
	
	
	/*Esta clase es un servidor   para esperar las conexiones entrantes
	 * de los diferentes motores
	 */
	
	
	final int PUERTO=5000;
	final int maxConnections=100;
	ServerSocket sc;
	Socket so;
	
	DataOutputStream salida;
	String mensajeRecibido;

	
	public  ServerMonitoring(){
		
	}
	
	public void AcceptConnections()
	{
		try 
		{
			sc = new ServerSocket(PUERTO );
			System.out.println("Aceptando Nuevas Conexiones");
			 int idSession = 0;
	            while (true) {
	                Socket socket;
	                socket = sc.accept();
	                System.out.println("Nueva conexión entrante: "+socket);
	                ThreadServer th= new ThreadServer(socket, idSession);
				    th.run();
	                idSession++;
	            }
			
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error "+e.getMessage());
		}

		

	}
	
	
	
	
	

}
