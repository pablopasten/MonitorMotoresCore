package cl.ryc.monitor.comms;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import cl.ryc.monitor.entities.Status;
import cl.ryc.monitor.helper.GlobalProcess;
import cl.ryc.monitor.helper.Outbound;


public class ReporterMonitor {
	
	//Esta clase permite informar a la Vista Cada N Minutos el Estado de los monitores
	
	protected Socket sk;
    protected DataOutputStream dos;
    protected DataInputStream dis;
    
    Outbound out;
	
	public ReporterMonitor()
	{
		
		
		 Timer timer;
		    timer = new Timer();

		    TimerTask task = new TimerTask() 
		    {
		        int tic=0;

		        @Override
		        public void run()
		        {
		            //acà hacemos correr el cliente
		        	Client();
		        }
		    };
		    // Empezamos dentro de 1 minuto y luego lanzamos la tarea cada 5 minutos
		    timer.schedule(task, 60000, 300000);
		    
		
	}
	
	
	public void Client(){
		
		
		try {
			
			out=Outbound.getInstance();
			List<Status> listado= out.getList();
			sk = new Socket("127.0.0.1", 5000);
			dos = new DataOutputStream(sk.getOutputStream());
	        dis = new DataInputStream(sk.getInputStream());
	        System.out.println(" envía saludo");
	        //Acà debo poner un json para enviar
	        
	        JSONObject jsonObject = new JSONObject(listado);
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
