package quarkus;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;

@Path("/temperaturas")
public class TemperaturaResource {
    private TemperaturaService temperaturas;
    //ES::Injection de dependencias
    public TemperaturaResource(TemperaturaService temperaturas){
        this.temperaturas = temperaturas;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura nueva(Temperatura temp)
    {
        temperaturas.addTemperatura(temp);
        return temp;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list(){
        return temperaturas.obtenerTemperaturas();
    }

    @Path("/medicion")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura medicion()
    {
        return new Temperatura("Oruro", 4,17);
    }

    @Path("/maxima")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima(){
        if(temperaturas.isEmpty()){
            return Response.status(404)
                    .entity("No hay temperaturas")
                    .build();
        }else{
            int  temperaturaMaxima = temperaturas.maxima();
            return Response.ok(Integer.toString(temperaturaMaxima))
                    .language("es-ES")
                    .header("X-Hola","Buenas tardes")
                    .build();
        }
    }

    @GET
    @Path("{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura sacar(@PathParam("ciudad") String ciudad){
        return temperaturas.sacarTemperatura(ciudad)
                .orElseThrow(() ->
                new NoSuchElementException("No hay registro dentro de la ciudad " + ciudad));
    }

}
