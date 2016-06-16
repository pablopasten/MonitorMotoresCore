package cl.ryc.monitor.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class UtilsHelper {
	
	private static UtilsHelper instance;
	
	
	

	
	public static UtilsHelper getInstance()
    {
        if(instance==null)
        {
            instance=new UtilsHelper();
            
        }


        return instance;
    }
	
	private UtilsHelper()
    {

    }
	
	public static String getFechaActual() {
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
	    return formateador.format(ahora);
	}
	
	
}


