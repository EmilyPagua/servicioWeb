package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.UsuarioMoneda;
import modelo.UsuarioMonedaModelo;

import java.math.BigDecimal;
import java.util.*;

@Path("/servicio")
public class UsuarioMonedaRest {

	private UsuarioMonedaModelo cm = new UsuarioMonedaModelo();	
	
	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioMoneda> clientFindAll(){
		System.out.println("clientFindAll  ");
		return this.cm.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public UsuarioMoneda clientFind(@PathParam("param") BigDecimal primarykey){
		System.out.println("clientFind  " +primarykey);
		return this.cm.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void clientCreate(UsuarioMoneda objeto){			
		System.out.println("clientCreate  " );			
		System.out.println(this.cm.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response clientUpdate(UsuarioMoneda objeto){			
		System.out.println(this.cm.update(objeto));
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void clientDelete(UsuarioMoneda objeto){		
		System.out.println("clientDelete  " );		
		System.out.println(this.cm.delete(objeto));	
	}	
}