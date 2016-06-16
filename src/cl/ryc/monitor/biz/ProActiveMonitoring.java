package cl.ryc.monitor.biz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import cl.ryc.monitor.comms.ClientComms;
import cl.ryc.monitor.entities.Proc;
import cl.ryc.monitor.entities.ProcError;
import cl.ryc.monitor.helper.GlobalProcess;
import cl.ryc.monitor.helper.UtilsHelper;

public class ProActiveMonitoring {
	
	
	/*Esta Clase se encarga de monitorear proactivamente via PID windows si un proceso està 
	 * corriendo.
	 * Si un proceso no està corriendo alertarà a la vista para que se tomen las acciones
	 * necesarias.
	 */
	GlobalProcess gp;
	public ProActiveMonitoring ()
	{
		gp.getInstance();
		
		Timer timer;
	    timer = new Timer();

	    TimerTask task = new TimerTask() 
	    {
	        int tic=0;

	        @Override
	        public void run()
	        {
	        	Monitoring();
	        	
	        }
	    };
	    // Empezamos dentro 0 segundos y luego lanzamos la tarea cada 3 segundos
	    timer.schedule(task, 0, 30000);
		
	}
	
	
	public void Monitoring()
	{
		
		
		
			if(gp.getProcess()!=null && gp.getNumberOfProcess()>0)
			{
				
				List<Proc> procs=gp.getProcess();
				for (int cont=0;cont<gp.getNumberOfProcess();cont++ )
				{
					if(!isProcessIdRunningOnWindows(procs.get(cont).getPID()))
					{
						AlertError(procs.get(cont));
					}
				}
			}
		
			
			/*long pid=44036;
		if(!isProcessIdRunningOnWindows(pid))
		{
			System.out.println("No esta corriendo");
		}
		else
		{
			System.out.println("Esta corriendo");
		}*/
		
	}
	
	
	public static boolean isProcessIdRunningOnWindows(Long pid){
        //this queries tasklist if the pid passed in is running.
        //If the pid is running it returns true, else false.
        try {
            Runtime runtime = Runtime.getRuntime();
            String cmds[] = {"cmd", "/c", "tasklist /FI \"PID eq " + pid + "\""};
            Process proc = runtime.exec(cmds);

            InputStream inputstream = proc.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                if (line.contains(" " + pid + " ")){
                    return true;
                }
            }

            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Imposible consultar por el proceso "+ pid);
            System.exit(0);
        }

        return false;

    }
	
	
	public void AlertError(Proc p)
	{
		
		ProcError pe= new ProcError();
		
		pe.setType("Error");
		UtilsHelper uh= UtilsHelper.getInstance();
		pe.setDescription("El Proceso "+p.getName()+"no se encuentra disponible. Fecha del Error "+uh.getFechaActual());
		
		JSONObject jsonObject = new JSONObject(pe);
		 
		System.out.println(jsonObject.toString());
		 
		ClientComms ccm= new ClientComms();
		 
		ccm.Send(jsonObject);
		
	}
}
