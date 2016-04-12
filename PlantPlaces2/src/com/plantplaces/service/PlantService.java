package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

public class PlantService implements IPlantService{


@Inject
IPlantDAO plantDAO;
private List<Plant> allPlants;
public IPlantDAO getPlantDAO() {
	return plantDAO;
}
public void setPlantDAO(IPlantDAO plantDAO) {
	this.plantDAO = plantDAO;
}
@Override
public List<Plant> filterPlants(String filter) {
	 if(allPlants==null){
		 allPlants=plantDAO.fetchPlants();
	 }
	 //filter the list
	 ArrayList<Plant> returnPlants=new ArrayList<Plant>();
	 //filter the list
	 //interviw all the plants and add the filtered plants to the conllection
	 for (Plant plant : allPlants) {
		if(plant.toString().contains(filter)){
			//add to the return collection 
			returnPlants.add(plant);
		}
	}
	 return returnPlants;
	}
}
