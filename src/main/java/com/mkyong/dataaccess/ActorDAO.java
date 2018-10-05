package com.mkyong.dataaccess;

import java.util.List;

public interface ActorDAO {

	 public void saveActor(Actor actor);
	    public Actor getActorById(int id);
	    public void updateActor(Actor actor);
	    public void deleteActor(int id);
	    public List<Actor> getAllActors();
}
