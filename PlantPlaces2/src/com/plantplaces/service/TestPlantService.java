package com.plantplaces.service;

import org.junit.Test;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

import junit.framework.TestCase;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class TestPlantService extends TestCase{

	private PlantService plantService;
	private List<Plant> filterPlants;
	private IPlantDAO plantDAO;

	@Test
	public void testFilterPlants(){
		givenThatPlantServiceIsPopulatedWithPlantDAO();
		whenFilterWithRed();
		thenVerifyTwoResults();
		
	}

	private void thenVerifyTwoResults() {
		// TODO Auto-generated method stub
		assertEquals(2, filterPlants.size());
	}

	private void whenFilterWithRed() {
		// TODO Auto-generated method stub
		filterPlants = plantService.filterPlants("red");
		verify(plantDAO,times(1)).fetchPlants();
	}

	private void givenThatPlantServiceIsPopulatedWithPlantDAO() {
		plantService = new PlantService();
		plantDAO = mock(IPlantDAO.class);
		//a known set of hardcoded plants 
		List<Plant> plantList=  constructPlantList();
		//tell the mock object to return our known set of hardcoded plants, when requested
		when(plantDAO.fetchPlants()).thenReturn(plantList);
		
		// associate the mock object with the object we are testing
		plantService.setPlantDAO(plantDAO);
	}
	private List<Plant> constructPlantList(){
		List<Plant> allPlants=new ArrayList<Plant>();
		
		//create plants and addthem to the collection
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
}
