package ws;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entidad.Credito;
import modelo.CreditoModelo;

public class CreditoRest {
	private CreditoModelo obj = new CreditoModelo();	

	@GET
	@Path("/FindAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Credito>  FindAll(){
		System.out.println(" FindAll  ");
		return this.obj.findAll();	
	}
	
	@GET
	@Path("/Find/{param}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Credito  Find(@PathParam("param") BigDecimal primarykey){
		return this.obj.find(primarykey);	
	}
	
	@POST
	@Path("/Create")
    @Consumes({"application/json"})
	public void  Create(Credito objeto){			
		System.out.println(this.obj.create(objeto));		
	}
	
	@POST
	@Path("/Update")
    @Consumes({"application/json"})
	public Response  Update(Credito objeto){			
		return Response.ok(objeto).build();
	}
	
	@DELETE
	@Path("/Delete")
    @Consumes({"application/json"})
	public void  Delete(Credito objeto){				
		System.out.println(this.obj.delete(objeto));	
	}		

}
