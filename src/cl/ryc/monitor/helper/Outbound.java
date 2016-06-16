package cl.ryc.monitor.helper;

import java.util.ArrayList;
import java.util.List;

import cl.ryc.monitor.entities.Status;

public class Outbound {
	
	
	
	List<Status> listado;
	
	private static Outbound instance;
	
	public static Outbound getInstance()
    {
        if(instance==null)
        {
            instance=new Outbound();
            
        }


        return instance;
    }
	
	
	private Outbound()
	{
		listado= new ArrayList<Status>();
	}
	
	
	public void setList(Status in)
	{
		listado.add(in);
	}
	
	public List<Status> getList()
	{
		return listado;
	}
	
	public void ClearList()
	{
		listado.clear();
	}
	
	

}
