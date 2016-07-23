package rackspace.ws.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rackspace.ws.model.ServerInfo;
//import rackspace.ws.repository.ServerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 


@Service
public class ServerServiceBean implements ServerService {

	@Autowired 
	//private ServerRepository serverRepository; 
	private static BigInteger nextId;
	private static ServerInfo mServer;
	private static Map<BigInteger,ServerInfo>  servermap;
	


	static {
		ServerInfo mServerInfo = new ServerInfo();
		mServerInfo.setName("testServer");
		mServerInfo.setCPUS(4);
		mServerInfo.setRAM(4);
		mServerInfo.setDiskspace(40);
		mServerInfo.setStatus(ServerInfo.Status.Building);
		
		createServer(mServerInfo);
		
		mServerInfo = new ServerInfo();
		mServerInfo.setName("newtestServer");
		mServerInfo.setStatus(ServerInfo.Status.Building);
		mServerInfo.setCPUS(6);
		mServerInfo.setRAM(6);
		mServerInfo.setDiskspace(60);
		createServer(mServerInfo);
		
	}
	private static ServerInfo createServer(ServerInfo serverInfo){
		
		if (servermap == null) {
			servermap = new HashMap<BigInteger,ServerInfo>();
			nextId = BigInteger.ONE;
		}
		if (serverInfo.getId()!=null){
			
			ServerInfo oldServer = servermap.get(serverInfo.getId());
			if (oldServer == null){
				return null;
			}
			
			servermap.remove(serverInfo.getId());
			servermap.put(serverInfo.getId(), serverInfo);
			return serverInfo;
		}
		serverInfo.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		servermap.put(serverInfo.getId(), serverInfo);
		mServer = serverInfo;
		return mServer;
		
	}
	
	private static ServerInfo deleteServer(BigInteger id){
		return servermap.remove(id);
	
	}
	@Override
	public Map<BigInteger,ServerInfo> findAll() {
		
		return servermap;
	}

	@Override
	public ServerInfo findOne(BigInteger id) {
		
		ServerInfo server = servermap.get(id); 
		return server; 
	}

	@Override
	public ServerInfo create(ServerInfo serverinfo) {
	
		
		ServerInfo serverInfo = createServer(serverinfo); 
		return serverInfo; 
	}

	@Override
	public ServerInfo update(ServerInfo serverinfo) {
		ServerInfo serverToUpdate = findOne(serverinfo.getId()); 
		 if (serverToUpdate == null) { 
			 return null; 
		 } 
		 serverToUpdate.setRAM(serverinfo.getRAM()); 
		 
		 ServerInfo updatedServer = createServer(serverToUpdate); 
		 return updatedServer; 

	}

	@Override
	public ServerInfo delete(BigInteger id) {
		return deleteServer(id);
		
	}

}
