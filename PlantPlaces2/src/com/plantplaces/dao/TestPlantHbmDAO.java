package com.plantplaces.dao;

import java.util.List;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {

	private PlantDAOStub plantHbmDAO;
	private List<Plant> plants;

	@Test
	public void verifyFetchByCommonName(){
		givenPlantDAOInstantiated();
		whenCommonNameIsRedbud();
		thenVerifyResults();
	}

	private void thenVerifyResults() {
		// TODO Auto-generated method stub
		assertTrue(plants.size()>0);
		for (Plant plant : plants) {
			assertEquals("redbud", plant.getCommon());
		}
	}

	private void whenCommonNameIsRedbud() {
		// TODO Auto-generated method stub
		Plant p = new Plant();
		p.setCommon("redbud");
		plants=plantHbmDAO.fetchPlants(p);
	}

	private void givenPlantDAOInstantiated() {
		// TODO Auto-generated method stub
		plantHbmDAO=new PlantDAOStub();
		
	}
	
}
