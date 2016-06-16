package cl.ryc.monitor.comms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import org.json.JSONObject;

import cl.ryc.monitor.entities.Status;
import cl.ryc.monitor.helper.Outbound;

public class ClientComms {
	
	//Esta Clase Permite comunicar el mensaje que necesitemos hacia la vista
	
		
	protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    
    
    
    public ClientComms(){
    	
    }
    
    public void Send(JSONObject jsonObject)
    {
		try {
			
			
			sk = new Socket("127.0.0.1", 5000);
			dos = new DataOutputStream(sk.getOutputStream());
	        dis = new DataInputStream(sk.getInputStream());
	        System.out.println(" envía saludo"); 
	        dos.writeUTF(jsonObject.toString());
	        String respuesta="";
	        respuesta = dis.readUTF();
	        System.out.println(" Servidor devuelve saludo: " + respuesta);
	        dis.close();
	        dos.close();
	        sk.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

}
