package edu.sjsu.cmpe.isns.api.resources;

import java.net.UnknownHostException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.sjsu.cmpe.isns.domain.User;
import edu.sjsu.cmpe.isns.dto.UserDto;


@Path("isns/v1/users")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {           
    public UserResource() 
    {
        // do nothing
    }
    
    @POST
    //@Consumes(MediaType.TEXT_HTML)
    public Response addUser(@FormParam("firstname") String firstname,
    		@FormParam("lastname") String lastname) throws UnknownHostException 
    {
    	
    	User request=new User();
    	request.setFirstName(firstname);
    	request.setLastName(lastname);
    	//ObjectMapper mapper = new ObjectMapper();
    	//JsonGenerator jgen;
		//mapper.writeValue(jgen, request);
    	UserDto ud=new UserDto(request);
        ud.makeConnection();
        ud.createUser(request);
        return Response.status(200)
    			.entity("User Registered Successfully")
    			.build();
    }

   
        
   }
