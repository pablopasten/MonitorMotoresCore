package cl.ryc.monitor.comms;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreadServer extends Thread{
	
	 Socket socket;
     DataOutputStream dos;
     String accion;
      DataInputStream dis;
    private int idSessio;
    
    public ThreadServer(Socket socket, int id) {
        this.socket = socket;
        this.idSessio = id;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accion=dis.readUTF();
            
            System.out.println("Estoy inicializando el thread "+accion);
        } catch (IOException ex) {
            System.out.println("Error inicializando el Thread "+ex.getMessage());
        }
    }
    
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
        	System.out.println("Error "+ex.getMessage());
        }
    }
    
    @Override
    public void run() {
       
        System.out.println("llegue al run 1 "+accion);
        try {
        	
            //accion = dis.readUTF();
            System.out.println("llegue al run");
            if(!accion.equals("")){
                System.out.println("El cliente con idSesion "+this.idSessio+" saluda");
                dos.writeUTF("adios");
                ProcessingJson(accion);
                
            }
            else{
            	System.out.println("Test");
            }
        } catch (IOException ex) {
        	System.out.println("Error en el run "+ex.getMessage());
        }
        desconnectar();
    }
    
    
    
    
    public void ProcessingJson(String js)
    {
    	 if(!js.startsWith("["))
         {
             js="["+js.toString()+"]";
             System.out.println("Agregué corchetes");
             System.out.println(js);
         }
    	 
    	 try {
			JSONArray jsonArray = new JSONArray(js);
			
			for(int cont=0;cont<jsonArray.length();cont++) 
			{
				JSONObject json_data = null;

                try {
                    json_data = jsonArray.getJSONObject(cont);
                    System.out.println("Tipo de Json ="+json_data.getString("type"));
                    

                }
                catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    // ViewsHelper.setStatusComms(JsonProblem);
                    e.printStackTrace();
                }
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
