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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modelo.UsuarioModelo;

import entidad.Usuario;

//http://localhost:8081/servicioWeb/user/servicio/FindAll
@Path("/servicio")
public class UsuarioRest {
	
	private UsuarioModelo userm = new UsuarioModelo();
	
		@GET
		@Path("/FindAll")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Usuario> userFindAll(){
			return this.userm.findAll();	
		}
		
		@GET
		@Path("/Find/{param}")
		@Produces(MediaType.APPLICATION_JSON) 
		public Usuario userFind(@PathParam("param") BigDecimal primarykey){
			return this.userm.find(primarykey);	
		}
			
		@POST
		@Path("/Create")
	    @Consumes({"application/json"})
		public Response userCreate(Usuario objeto){		
			if (this.userm.create(objeto))
				return Response.ok(objeto).build();
			else
				return Response.ok().build();			
		}
		
		@POST
		@Path("/Update")
	    @Consumes({"application/json"})
		public Response userUpdate(Usuario objeto){			
			System.out.println(this.userm.update(objeto));
			return Response.ok(objeto).build();
		}
		
		@DELETE
		@Path("/Delete")
	    @Consumes({"application/json"})
		public Response userDelete(Usuario objeto){		
			System.out.println(this.userm.delete(objeto));
			return Response.ok("Eliminado").build();
		}	

		@GET   
	    @Path("/login")
	    @Produces(MediaType.APPLICATION_JSON) 
	    public String doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd){
	        String response = "";
	        System.out.println(uname +"  "+ pwd);
	        if(checkCredentials(uname, pwd)){
	            response = Utitlity.constructJSON("login",true);
	        }else{
	            response = Utitlity.constructJSON("login", false, "Incorrect Email or Password");
	        }
	    return response;        
	    }
		
		 private boolean checkCredentials(String uname, String pwd){
		        boolean result = false;
		    	UsuarioModelo userm = new UsuarioModelo();
		    	
		        if(Utitlity.isNotNull(uname) && Utitlity.isNotNull(pwd)){
		            try {
		            	result = userm.checkLogin(uname, pwd);
		                System.out.println("Inside checkCredentials try "+result);
//		                generarToken();
		            } catch (Exception e) {
		                System.out.println("Inside checkCredentials catch");
		                result = false;
		            }
		        }else{
		            System.out.println("Inside checkCredentials else");
		            result = false;
		        }
		 
		        return result;
		    }

//		 public static void generarToken() {
//
//			    String header = "{\"alg\":\"RS256\"}";
//			    String claimTemplate = "'{'\"iss\": \"{0}\", \"sub\": \"{1}\", \"aud\": \"{2}\", \"exp\": \"{3}\"'}'";			    
//
//			    try {
//			      StringBuffer token = new StringBuffer();
//
//			      //Encode the JWT Header and add it to our string to sign
//			      token.append(Base64.encodeBase64URLSafeString(header.getBytes("UTF-8")));
//
//			      //Separate with a period
//			      token.append(".");
//
//			      //Create the JWT Claims Object
//			      String[] claimArray = new String[4];
//			      claimArray[0] = "3MVG99OxTyEMCQ3gNp2PjkqeZKxnmAiG1xV4oHh9AKL_rSK.BoSVPGZHQukXnVjzRgSuQqGn75NL7yfkQcyy7";
//			      claimArray[1] = "my@email.com";
//			      claimArray[2] = "https://login.salesforce.com";
//			      claimArray[3] = Long.toString( ( System.currentTimeMillis()/1000 ) + 300);
//			      MessageFormat claims;
//			      claims = new MessageFormat(claimTemplate);
//			      String payload = claims.format(claimArray);
//
//			      //Add the encoded claims object
//			      token.append(Base64.encodeBase64URLSafeString(payload.getBytes("UTF-8")));
//
//			      //Load the private key from a keystore
//			      KeyStore keystore = KeyStore.getInstance("JKS");
//			      String keystoreFilename = "my.keystore";
//			      FileInputStream fIn = new FileInputStream(keystoreFilename);
//			      keystore.load(fIn, "keystorepassword".toCharArray());
//			      PrivateKey privateKey = (PrivateKey) keystore.getKey("certalias", "privatekeypassword".toCharArray());
//
//			      //Sign the JWT Header + "." + JWT Claims Object
//			      Signature signature = Signature.getInstance("SHA256withRSA");
//			      signature.initSign(privateKey);
//			      signature.update(token.toString().getBytes("UTF-8"));
//			      String signedPayload = Base64.encodeBase64URLSafeString(signature.sign());
//
//			      //Separate with a period
//			      token.append(".");
//
//			      //Add the encoded signature
//			      token.append(signedPayload);
//
//			      System.out.println(token.toString());
//
//			    } catch (Exception e) {
//			    	System.out.println(e.getMessage());
//			        e.printStackTrace();
//			    }
//			  }

}
