package com.plantplaces.service;

import java.util.List;

import com.plantplaces.dto.Plant;

/**
 * IPlant Service ncludes all business related functions for a plant and related entities
 * @author yacine smail
 *
 */
public interface IPlantService {

	/**
	 * Return a collection of plant objects that contain the given filter text
	 * @param filter a substring that should be contained  in returned plants.
	 * @return a collection of matching plants 
	 */
	public List<Plant> filterPlants(String filter);
	
}
