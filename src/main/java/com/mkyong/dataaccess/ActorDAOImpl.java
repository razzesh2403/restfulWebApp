package com.mkyong.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ActorDAOImpl implements ActorDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveActor(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor getActorById(int id) {
		// TODO Auto-generated method stub
		String sql = "select actor_id,first_name,last_name from Actor where actor_id=?";
        Actor actor = (Actor) jdbcTemplate.queryForObject(sql, new Object[]
        { id }, new RowMapper<Actor>()
        {
            @Override
            public Actor mapRow(ResultSet rs, int rowNum) throws SQLException
            {
            	Actor actor = new Actor();
            	actor.setId(rs.getInt(1));
            	actor.setFirstName(rs.getString(2));
            	actor.setLastName(rs.getString(3));
                return actor;
            }
        });
        return actor;
	}

	@Override
	public void updateActor(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActor(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		String sql = "select * from actor limit 10";

        List<Actor> actorList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Actor>>()
        {
            @Override
            public List<Actor> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Actor> list = new ArrayList<Actor>();
                while (rs.next())
                {
                	Actor actor = new Actor();
                	actor.setId(rs.getInt(1));
                	actor.setFirstName(rs.getString(2));
                	actor.setLastName(rs.getString(3));
                    list.add(actor);
                }
                return list;
            }

        });
        return actorList;
	}

}
