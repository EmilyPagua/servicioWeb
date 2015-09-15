package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.Token;
import modelo.TokenModelo;

import java.math.BigDecimal;
import java.util.*;

//http://localhost:8081/servicioWeb/role/servicio/FindAll
@Path("/servicio")
public class TokenRest {

	private TokenModelo obj = new TokenModelo();		

	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Token>  FindAll(){
		return this.obj.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Token  Find(@PathParam("param") BigDecimal primarykey){
		return this.obj.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void  Create(Token objeto){			
		System.out.println(this.obj.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response  Update(Token objeto){			
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void  Delete(Token objeto){				
		System.out.println(this.obj.delete(objeto));	
	}		
}