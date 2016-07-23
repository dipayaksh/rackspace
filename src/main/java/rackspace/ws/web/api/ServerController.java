package rackspace.ws.web.api;



import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rackspace.ws.model.ServerInfo;
import rackspace.ws.service.ServerService;
import rackspace.ws.service.ServerServiceBean;

@RestController
public class ServerController {
	
	
	 @Autowired 
	 private ServerService serverService = new ServerServiceBean(); 

	
	@RequestMapping(
			value = "/api/serverinfo",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <Collection<ServerInfo>> getServers(){
	
		Collection<ServerInfo> mServers = 	serverService.findAll().values();
		 return new ResponseEntity<Collection<ServerInfo>> (mServers,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/api/serverinfo/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <ServerInfo> getServerInfo(@PathVariable("id") BigInteger id){
			ServerInfo mServerInfo = serverService.findOne(id);
			if (mServerInfo == null ){
				return new ResponseEntity<ServerInfo> (HttpStatus.NOT_FOUND);
			}
		 return new ResponseEntity<ServerInfo>(mServerInfo,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/api/serverinfo",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <ServerInfo> createServerfromrequest(@RequestBody ServerInfo mserverInfo){
			
			ServerInfo newServerInfo = serverService.create(mserverInfo);
			
		
		 return new ResponseEntity<ServerInfo>(newServerInfo,HttpStatus.CREATED);
	}
	
	@RequestMapping(
			value = "/api/serverinfo/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <ServerInfo> updateServerfromrequest(@PathVariable("id") BigInteger id,@RequestBody ServerInfo mserverInfo){
			
			mserverInfo.setId(id);
			ServerInfo updateServerInfo = serverService.create(mserverInfo);
			
			if (updateServerInfo == null)
				return new ResponseEntity<ServerInfo> (HttpStatus.INTERNAL_SERVER_ERROR);
			
		 return new ResponseEntity<ServerInfo>(updateServerInfo,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/api/serverinfo/{id}",
			method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <ServerInfo> destroyServer(@PathVariable("id") BigInteger id){
		
		
		ServerInfo mServerInfo= serverService.delete(id);
			if (mServerInfo == null)
				return new ResponseEntity<ServerInfo> (HttpStatus.INTERNAL_SERVER_ERROR);
			
		 return new ResponseEntity<ServerInfo>(mServerInfo,HttpStatus.OK);
	}
	
}
