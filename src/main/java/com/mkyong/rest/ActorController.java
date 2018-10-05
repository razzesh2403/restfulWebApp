package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.dataaccess.Actor;
import com.mkyong.dataaccess.ActorDAO;

@Path("/myservice")
public class ActorController {
	
	@Autowired
    private ActorDAO actorDAO;
	
	@Path("/actor/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public String getActor(@PathParam("id") Integer id)
    {   
        Actor actor = actorDAO.getActorById(id);
        System.out.println(actor);
        
        return actor.toString();
    }
	
	 @Path(value = "/actors")
	 @GET
	    public ModelAndView listActors(@ModelAttribute Actor actor)
	    {
	        ModelAndView model = new ModelAndView("actors");
	        
	        List<Actor> actorList = actorDAO.getAllActors();
	        System.out.println(actorList);
	        model.addObject("actorList", actorList);
	        
	        return model;
	    }

}
