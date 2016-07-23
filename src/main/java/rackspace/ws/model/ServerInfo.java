package rackspace.ws.model;

import java.math.BigInteger;





public class ServerInfo {
	
	
	private BigInteger id;
	private String name;
	private Integer cpus;
	private Integer ram;
	private Integer diskSpace;
	private Status status;
	public enum Status {
		   Building, Running, Destroyed
		}


	public BigInteger getId(){
		return id;
	}
	public void setId(BigInteger id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
		
	}
	public Integer getCPUS(){
		return cpus;
	}
	public void setCPUS(Integer cpus){
		this.cpus=cpus;
		
	}
	public Integer getRAM(){
		return ram;
	}
	public void setRAM(Integer ram){
		this.ram=ram;
		
	}
	public Integer getDiskspace(){
		return diskSpace;
	}
	public void setDiskspace(Integer diskSpace){
		this.diskSpace=diskSpace;
		
	}
	
	public Status getStatus(){
		return status;
	}
	public void setStatus(Status value){
		this.status=value;
		
	}
}
