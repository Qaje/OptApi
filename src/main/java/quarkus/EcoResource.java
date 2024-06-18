package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

import java.util.Optional;

@Path("/saludar")
public class EcoResource {
    @GET
    public String saludar(@QueryParam("mensaje") String mensaje){
      return Optional.ofNullable(mensaje)
              .map(n ->" > " + n)
              .orElse("Nose muy que deci aqui");
    }

    @GET
    @Path("/{nombre}")
    public String saludo(@PathParam("nombre")String nombre){
        return "Hola, "+ nombre;
    }

//    @GET
//    @Path("/dia")
//    public String dia(){
//        return "hey good day";
//    }
//
//    @GET
//    @Path("/tarde")
//    public String tarde(){
//        return "hey good afternon";
//    }
//
//    @GET
//    @Path("/noche")
//    public String noche(){
//        return "hey good night";
//    }

}
