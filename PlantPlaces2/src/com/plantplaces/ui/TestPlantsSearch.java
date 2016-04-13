package com.plantplaces.ui;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantsSearch  extends TestCase{

	private SearchPlants searchPlants;
	private String execute;

	@Test
	public void testSearchPlantExecute(){
		givenSearchPlantsCreatedWithRedbud();
		whenInvokedExecute();
		thenVerifyReturnSuccess();
	}

	@Test
	public void testSearchWithoutRedbud(){
		givenSearchPlantsCreatedWithoutRedbud();
		whenInvokedExecute();
		thenVerifyReturnNoResults();
	}
	@Test
	public void testSeachPlantsNull(){
		givenSearchPlantsCreatedWithNullPlant();
		whenInvokedExecute();
		thenVerifyReturnNoResults();
	}
	
	
	private void givenSearchPlantsCreatedWithNullPlant() {

		searchPlants=new SearchPlants();
	}

	private void givenSearchPlantsCreatedWithoutRedbud() {
		
		searchPlants = new SearchPlants();
		Plant plant=new Plant();
		plant.setCommon("Pawpaw");
		searchPlants.setPlant(plant);
	}

	private void thenVerifyReturnNoResults() {
		assertEquals("search", execute);
		
	}

	private void thenVerifyReturnSuccess() {

		assertEquals("search", execute);
		
	}

	private void givenSearchPlantsCreatedWithRedbud() {
		searchPlants = new SearchPlants();
		Plant plant=new Plant();
		plant.setCommon("Redbud");
		searchPlants.setPlant(plant);
		
	}

	private void whenInvokedExecute() {
	
		execute = searchPlants.execute();
	
	}
}
