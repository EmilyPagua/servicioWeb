package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.UsuarioDetalle;
import modelo.UsuarioDetalleModelo;

import java.math.BigDecimal;
import java.util.*;

@Path("/servicio")
public class UsuarioDetalleRest {

	private UsuarioDetalleModelo cm = new UsuarioDetalleModelo();	
	
	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDetalle> clientFindAll(){
		System.out.println("clientFindAll  ");
		return this.cm.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public UsuarioDetalle clientFind(@PathParam("param") BigDecimal primarykey){
		System.out.println("clientFind  " +primarykey);
		return this.cm.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void clientCreate(UsuarioDetalle objeto){			
		System.out.println("clientCreate  " );			
		System.out.println(this.cm.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response clientUpdate(UsuarioDetalle objeto){			
		System.out.println(this.cm.update(objeto));
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void clientDelete(UsuarioDetalle objeto){		
		System.out.println("clientDelete  " );		
		System.out.println(objeto.getNombre());
		System.out.println(this.cm.delete(objeto));	
	}	
	
	
	//----------------------------------login------------------------------
	@GET
	@Path("/doregister")
	@Produces(MediaType.APPLICATION_JSON)
	public Response doLogin(@QueryParam("name") String name, @QueryParam("username") String username, @QueryParam("password") String password){
		return Response.ok("hola").build();
	}	
}