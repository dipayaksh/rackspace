package rackspace.ws.service;


import java.math.BigInteger;
import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;



import rackspace.ws.ServerTest;
import rackspace.ws.model.ServerInfo;
import rackspace.ws.service.ServerService;


public class ServerServiceTest extends ServerTest {

	@Autowired
	private ServerService serverservice;
	
	@Before
	public void setUp(){
		//super.setUp();
		//serverservice.evictCache();
	}
	
	@Test
	public void testGetServers() throws Exception {
		Map<BigInteger,ServerInfo> servermap = serverservice.findAll();
		Assert.assertNotNull("FAILED - NULL ", servermap);
		Assert.assertEquals("FAILED - Wrong size ", 2, servermap.size());
		
	}
	 @Test 
	 public void testCreate() { 
	  
		 ServerInfo serverinfo = new ServerInfo(); 
		 serverinfo.setName("AddnewServer"); 
		 serverinfo.setCPUS(4);
		 serverinfo.setRAM(4);
		 serverinfo.setDiskspace(80);
	  
		 ServerInfo createdServer = serverservice.create(serverinfo); 
	  
	     Assert.assertNotNull("failure - expected not null", createdServer); 
	     Assert.assertNotNull("failure - expected id attribute not null", 
	    		 createdServer.getId()); 
	     Assert.assertEquals("failure - expected text attribute match", "AddnewServer", 
	    		 createdServer.getName()); 
	 
	  
	      
	     Map<BigInteger,ServerInfo> servermap = serverservice.findAll();
	     Assert.assertEquals("failure - expected size", 3, servermap.size()); 
	} 

	 @Test 
	 public void testUpdate() { 
		 	
	 
	  
		 	ServerInfo serverinfo = serverservice.findOne(BigInteger.ONE); 
		 	Assert.assertNotNull("failure - expected not null", serverinfo); 
		 	Integer updatedRAM = serverinfo.getRAM() + 4; 
		 	serverinfo.setRAM(updatedRAM); 
		 	ServerInfo updatedEntity = serverservice.update(serverinfo); 
	
	  
		 	Assert.assertNotNull("failure - expected not null", updatedEntity); 
		 	Assert.assertEquals("failure - expected id attribute match", BigInteger.ONE, 
		 				updatedEntity.getId()); 
		 	Assert.assertEquals("failure - expected text attribute match", 
		 			updatedRAM, updatedEntity.getRAM()); 

	  
	 	} 

}
