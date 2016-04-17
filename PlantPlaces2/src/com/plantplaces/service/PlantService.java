package com.plantplaces.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IFileDAO;
import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dao.ISpecimenDAO;
import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
public class PlantService implements IPlantService {

	@Inject
	private IFileDAO fileDAO;	
	@Inject
	IPlantDAO plantDAO;
	private List<Plant> allPlants;
	@Inject
	private ISpecimenDAO specimenDAO;
	public IPlantDAO getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDAO plantDAO) {
		this.plantDAO = plantDAO;
	}

	@Override
	public List<Plant> filterPlants(String filter) {
		if (allPlants == null) {
			allPlants = plantDAO.fetchPlants();
		}
		// filter the list
		ArrayList<Plant> returnPlants = new ArrayList<Plant>();
		// filter the list
		// interviw all the plants and add the filtered plants to the
		// conllection
		for (Plant plant : allPlants) {
			if (plant.toString().contains(filter)) {
				// add to the return collection
				returnPlants.add(plant);
			}
		}
		return returnPlants;
	}

	public void save(Plant plant) throws Exception {

		if(plant.getGenus()==null||plant.getGenus().isEmpty()){
			throw new Exception("benus required");
		}
		plantDAO.insert(plant);
	}

	public List<Plant> fetchPlants(Plant plant) {	
		List<Plant> plants = plantDAO.fetchPlants(plant);
		return plants;
	}
	@Override
	public void save(Specimen specimen) throws Exception{
		specimenDAO.insert(specimen);
	}

	public ISpecimenDAO getSpecimenDAO() {
		return specimenDAO;
	}

	public void setSpecimenDAO(ISpecimenDAO specimenDAO) {
		this.specimenDAO = specimenDAO;
	}

	@Override
	public void loadSpecimens(Plant plant) {
		// TODO Auto-generated method stub
		List<Specimen> specimens = specimenDAO.fetchByPlantId(plant.getGuid());
		plant.setSpecimens(specimens);
	}

	@Override
	public void savePhoto(Photo photo, InputStream inputstream) throws IOException {
		// TODO Auto-generated method stub
		File directory=new File("C:/git/PlantPlaces2/WebContent/images");
		String uniqueImageName=getUniqueImageName();
		File file=new File(directory,uniqueImageName);		
		fileDAO.save(inputstream, file);
		photo.setUri(uniqueImageName);
		//save the photo into the database
	}

	private String getUniqueImageName() {
		// TODO Auto-generated method stub
		String imagePrefix="plantPlaces";
		String imageSuffix=".jpg";
		String middle="";
		SimpleDateFormat sdf=new SimpleDateFormat("yy/MM/dd/HH/mm/ss");
		middle=sdf.format(new Date());
		return imagePrefix+middle+imageSuffix;
	}

	public IFileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(IFileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
}
