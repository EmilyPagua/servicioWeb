package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.Rol;
import modelo.RolModelo;

import java.math.BigDecimal;
import java.util.*;

//http://localhost:8081/servicioWeb/role/servicio/FindAll
@Path("/servicio")
public class RolRest {

	private RolModelo obj = new RolModelo();		

	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Rol>  FindAll(){
		return this.obj.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Rol  Find(@PathParam("param") BigDecimal primarykey){
		return this.obj.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void  Create(Rol objeto){			
		System.out.println(this.obj.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response  Update(Rol objeto){			
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void  Delete(Rol objeto){				
		System.out.println(this.obj.delete(objeto));	
	}		
}