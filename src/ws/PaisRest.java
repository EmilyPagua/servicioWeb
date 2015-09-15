package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.Pais;
import modelo.PaisModelo;

import java.math.BigDecimal;
import java.util.*;

@Path("/servicio")
public class PaisRest {

	private PaisModelo obj = new PaisModelo();		

	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pais>  FindAll(){
		return this.obj.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Pais  Find(@PathParam("param") BigDecimal primarykey){
		return this.obj.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void  Create(Pais objeto){			
		System.out.println(this.obj.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response  Update(Pais objeto){			
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void  Delete(Pais objeto){				
		System.out.println(this.obj.delete(objeto));	
	}		
}