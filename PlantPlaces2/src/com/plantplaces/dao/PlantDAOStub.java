package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import com.plantplaces.dto.Plant;
@Named("plantDAO")
public class PlantDAOStub implements IPlantDAO{

	static final Logger log=Logger.getLogger(PlantDAOStub.class);
	
	@Override
	public List<Plant> fetchPlants() {
		// TODO Auto-generated method stub
		List<Plant> allPlants=new ArrayList<Plant>();
		//create plants and add the to the collection 
		Plant redbud=new Plant();
		redbud.setCommon("redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		allPlants.add(redbud);
		
		Plant pawpaw=new Plant();
		pawpaw.setCommon("paw paw");
		pawpaw.setGenus("asimina");
		pawpaw.setSpecies("triloba");
		allPlants.add(pawpaw);
		
		Plant nasturtium=new Plant();
		nasturtium.setCommon("nasturium");
		nasturtium.setGenus("trapoleanum");
		nasturtium.setSpecies("spp");
		allPlants.add(nasturtium);
		
		Plant redMaple=new Plant();
		redMaple.setCommon("acer");
		redMaple.setGenus("rubrum");
		redMaple.setSpecies("redMaple");
		allPlants.add(redMaple);
		return allPlants;
	}

	@Override
	public void insert(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		log.warn("Inserting to stub, this does not persist the item");
		
	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
