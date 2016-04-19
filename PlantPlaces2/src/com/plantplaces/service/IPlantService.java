package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

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

	/**
	 * save the plant and perform a validation check
	 * @param plant the plant w're persisting
	 * @throws Exception if unable to save
	 */
	void save(Plant plant) throws Exception;

	/**
	 * return a list of plants that match the given criteria
	 * @param plant a parameter that contains the search criteria 
	 * @return a list of matching plants
	 */
	List<Plant> fetchPlants(Plant plant);

	void save(Specimen specimen) throws Exception;

	/**
	 * load speecimens for a givenn plant
	 * @param plant is the plant in question
	 */
	public void loadSpecimens(Plant plant);

	void save(Photo photo, InputStream inputstream) throws Exception;

	List<Photo> fetchPhotos(Specimen specimen);

	
	
}
