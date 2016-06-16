package cl.ryc.monitor.entities;

public class Status 
{
	
	
	String NameProcess;
	String StatusInternetComms;
	String ReporterTime;
	String LastTimeExecution;
	String StatusBDComms;
	String LastErrorDetected;
	
	
	public Status()
	{
		
	}


	public String getNameProcess() {
		return NameProcess;
	}


	public void setNameProcess(String nameProcess) {
		NameProcess = nameProcess;
	}


	public String getStatusInternetComms() {
		return StatusInternetComms;
	}


	public void setStatusInternetComms(String statusInternetComms) {
		StatusInternetComms = statusInternetComms;
	}


	public String getReporterTime() {
		return ReporterTime;
	}


	public void setReporterTime(String reporterTime) {
		ReporterTime = reporterTime;
	}


	public String getLastTimeExecution() {
		return LastTimeExecution;
	}


	public void setLastTimeExecution(String lastTimeExecution) {
		LastTimeExecution = lastTimeExecution;
	}


	public String getStatusBDComms() {
		return StatusBDComms;
	}


	public void setStatusBDComms(String statusBDComms) {
		StatusBDComms = statusBDComms;
	}


	public String getLastErrorDetected() {
		return LastErrorDetected;
	}


	public void setLastErrorDetected(String lastErrorDetected) {
		LastErrorDetected = lastErrorDetected;
	}
	
	
	
	

}
