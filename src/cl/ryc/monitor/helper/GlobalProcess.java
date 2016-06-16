package cl.ryc.monitor.helper;

import java.util.ArrayList;
import java.util.List;

import cl.ryc.monitor.entities.Proc;

public class GlobalProcess {
	
	
	//Esta Clase tiene y guarda los procesos que debo monitorear;
	private List<Proc> Proc;
	private static GlobalProcess instance;
	
	
	public static GlobalProcess getInstance()
    {
        if(instance==null)
        {
            instance=new GlobalProcess();
            
        }


        return instance;
    }
	
	private  GlobalProcess()
	{
		Proc= new ArrayList<Proc>();
	}
	
	
	public int getNumberOfProcess()
	{
		return Proc.size();
	}
	
	
	public void setProcess(Proc process){
		
		Proc.add(process);
		
	}
	
	
	public List<Proc> getProcess()
	{
		return Proc;
	}
	
	public void ClearProcess(){
		
		Proc.clear();
	}

}
