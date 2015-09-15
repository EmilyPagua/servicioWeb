package ws;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import entidad.Moneda;
import modelo.MonedaModelo;

import java.math.BigDecimal;
import java.util.*;

@Path("/servicio")
public class MonedaRest {

	private MonedaModelo obj = new MonedaModelo();		

	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Moneda>  FindAll(){
		System.out.println(" FindAll  ");
		return this.obj.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Moneda  Find(@PathParam("param") BigDecimal primarykey){
		return this.obj.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void  Create(Moneda objeto){			
		System.out.println(this.obj.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response  Update(Moneda objeto){			
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void  Delete(Moneda objeto){				
		System.out.println(this.obj.delete(objeto));	
	}		
}