import cl.ryc.monitor.comms.NetStatus;
import cl.ryc.monitor.comms.ServerMonitoring;
import cl.ryc.monitor.helper.UtilsHelper;


public class Main {
	
	static UtilsHelper Uh;
	
	
	public static void main (String [ ] args) 
	{
		 
        System.out.println("*******************************************");
        System.out.println("|     Comenzando Monitoreo de Motores     |");
        System.out.println("*******************************************");
        
        Uh= UtilsHelper.getInstance();
        
        System.out.println("Fecha Actual:"+Uh.getFechaActual());
        
        NetStatus ns= new NetStatus();
        
        ns.start();
        
        ServerMonitoring clm= new ServerMonitoring();
        
        clm.AcceptConnections();
        
       
        
        //Inicializamos el Reporte a la vista que informarà el estado de los motores
        
        
        //ReporterMonitor rm= new ReporterMonitor();
        
        //Iniciamos el monitoreo proactivo
        //ProActiveMonitoring pam= new ProActiveMonitoring(); 
        
        

	}

}
