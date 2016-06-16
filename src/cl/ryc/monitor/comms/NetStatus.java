package cl.ryc.monitor.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class NetStatus extends Thread{
	
	String ip;
	//Para saber el estado de la red haremos ping cada 1 minuto a Google
	public NetStatus(){
		ip = "google.com";
		
		System.out.println("Holass");
		
	}
	
	
	public static void runSystemCommand(String command) {
		System.out.println("Estoy aqui");
		try {
			System.out.println("Estoy aqui");
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader inputStream = new BufferedReader(
					new InputStreamReader(p.getInputStream()));

			String s = "";
			// reading output stream of the command
			
			System.out.println("Soy el s: "+inputStream.readLine()+";"+inputStream.readLine()+";"+inputStream.readLine());
			
			s = inputStream.readLine()+";"+inputStream.readLine()+";"+inputStream.readLine();
			
			
				
				if(!s.contains("La solicitud"))
				{
					if(!s.contains("Tiempo de espera"))
					{
						System.out.println("Conectado");
					}
					else
					{
						System.out.println("no conectado");
					}
				}
				else
				{
					System.out.println("no conectado");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
	       
		Timer timer;
	    timer = new Timer();

	    TimerTask task = new TimerTask() 
	    {
	        int tic=0;

	        @Override
	        public void run()
	        {
	        	runSystemCommand("ping " + ip);
	        	
	        }
	    };
	    // Empezamos dentro de 0segundos y luego lanzamos la tarea cada 1 minuto
	    timer.schedule(task, 0, 60000);
	        
   }

}
