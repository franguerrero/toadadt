package franguerrero.recurso;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import franguerrero.modelo.EstacionMeteorologica;
import franguerrero.modelo.EstacionMeteorologicaDao;

public class EstacionMeteorologicaRecurso {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
 
    public EstacionMeteorologicaRecurso(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }
  //para integracion con las aplicaciones
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EstacionMeteorologica getEstacionmeteo() {
    	System.out.println("getEstacionmeteo - APPLICATION_XML APPLICATION_JSON");
        EstacionMeteorologica todo = EstacionMeteorologicaDao.INSTANCE.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: EstacionMeteo con identificador " + id +  " no se encuentra");
        return todo;
    }

    // para integracion con navegadores
    @GET
    @Produces(MediaType.TEXT_XML)
    public EstacionMeteorologica getEstacionmeteoHTML() {
    	System.out.println("getEstacionmeteoHTML - TEXT_XML");
        EstacionMeteorologica todo = EstacionMeteorologicaDao.INSTANCE.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: EstacionMeteo con identificador " + id +  " no se encuentra");
        return todo;
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putEstacionmeteo(JAXBElement<EstacionMeteorologica> todo) {
    	System.out.println("putEstacionmeteo - APPLICATION_XML");
        EstacionMeteorologica c = todo.getValue();
        System.out.println(c.toString());
        return putAndGetResponse(c);
    }
  
    /*
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putEstacionmeteo(EstacionMeteorologica todo) {
    	System.out.println("putEstacionmeteo - APPLICATION_JSON");
        EstacionMeteorologica c = todo;
        return putAndGetResponse(c);
    }
    */

    @DELETE
    public void deleteEstacionmeteo() {
    	System.out.println("deleteEstacionmeteo");
        EstacionMeteorologica c = EstacionMeteorologicaDao.INSTANCE.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: EstacionMeteo con identificador " + id +  " no se encuentra");
    }
    private Response putAndGetResponse(EstacionMeteorologica todo) {
        Response res;
        if(EstacionMeteorologicaDao.INSTANCE.getModel().containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        EstacionMeteorologicaDao.INSTANCE.getModel().put(todo.getId(), todo);
        return res;
    }
}
