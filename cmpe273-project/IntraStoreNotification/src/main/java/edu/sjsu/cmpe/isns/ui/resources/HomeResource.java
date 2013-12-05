package edu.sjsu.cmpe.isns.ui.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.sjsu.cmpe.isns.ui.views.HomeView;


@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

  @GET
  public HomeView index() {
	  System.out.println("To Get");
    return new HomeView();
  }
}