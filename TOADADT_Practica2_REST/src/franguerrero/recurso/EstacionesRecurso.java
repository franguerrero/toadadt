package franguerrero.recurso;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import franguerrero.modelo.EstacionMeteorologica;
import franguerrero.modelo.EstacionMeteorologicaDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

@Path("/estaciones")
public class EstacionesRecurso {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<EstacionMeteorologica> getEstacionesBrowser() {
		System.out.println("getEstacionesBrowser - TEXT_XML");
		List<EstacionMeteorologica> todos = new ArrayList<EstacionMeteorologica>();
		todos.addAll(EstacionMeteorologicaDao.INSTANCE.getModel().values());
		return todos;
	}
	
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<EstacionMeteorologica> getEstaciones() {
		System.out.println("getEstaciones - APPLICATION_XML APPLICATION_JSON");
		List<EstacionMeteorologica> todos = new ArrayList<EstacionMeteorologica>();
		todos.addAll(EstacionMeteorologicaDao.INSTANCE.getModel().values());
		return todos;
	}
	@GET
	@Path("cont")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int cont = EstacionMeteorologicaDao.INSTANCE.getModel().size();
		return String.valueOf(cont);
	}
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newEstacion(@FormParam("id") String id,	@FormParam("localizacion") String localizacion, @FormParam("descripcion") String descripcion,
			@FormParam("temperatura") double temperatura, @FormParam("humedad") double humedad, @FormParam("vientoVelocidad") double vientoVelocidad, @FormParam("presionAtmosferica") double presionAtmosferica, 
			@FormParam("fechalectura") Date fechalectura, @Context HttpServletResponse servletResponse) throws IOException {
		
		
		EstacionMeteorologica todo = new EstacionMeteorologica(id, localizacion);
		if (descripcion != null) {
			todo.setDescripcion(descripcion);
		}
		if (temperatura != 0) {
			todo.setTemperatura(temperatura);
		}
		if (humedad != 0) {
			todo.setHumedad(humedad);
		}
		if (vientoVelocidad != 0) {
			todo.setVientoVelocidad(vientoVelocidad);
		}
		if (presionAtmosferica != 0) {
			todo.setPresionAtmosferica(presionAtmosferica);
		}
		if (fechalectura != null) {
			todo.setFechalectura(fechalectura);
		}
		
		EstacionMeteorologicaDao.INSTANCE.getModel().put(id, todo);
		
		
		servletResponse.sendRedirect("../crear_estacion.html");
		
		/*
		String text = "some text";

		servletResponse.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		servletResponse.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		servletResponse.getWriter().write(text);
		*/
	}
	@Path("{estacion}")
	public EstacionMeteorologicaRecurso getEstaciones(@PathParam("estacion") String id) {
		return new EstacionMeteorologicaRecurso(uriInfo, request, id);
	}
}
