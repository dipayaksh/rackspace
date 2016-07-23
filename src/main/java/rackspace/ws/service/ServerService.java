package rackspace.ws.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import rackspace.ws.model.ServerInfo;

public interface ServerService {

	Map<BigInteger,ServerInfo> findAll(); 
	 ServerInfo findOne(BigInteger id); 
	 ServerInfo create(ServerInfo serverinfo); 
	 ServerInfo update(ServerInfo serverinfo); 
	 ServerInfo delete(BigInteger id); 

}
