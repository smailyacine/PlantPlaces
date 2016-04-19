package com.plantplaces.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Photo;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean // available in each html page
@Scope
@SessionScoped
public class SpecimenVO {

	FileUploadEvent event;
	private Plant plant;
	@Inject
	private Specimen specimen;
	@Inject
	private IPlantService plantService;
	private UploadedFile file;
	@Inject
	private Photo photo;
	private List<Photo> photos;
	
	public UploadedFile getFile() {
//		System.out.println("get file viens d'etre appelé");
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public String upload() throws Exception{
	
		if(specimen.getId()==0) {
			FacesMessage message = new FacesMessage("you have not selected a specimen");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else if (file != null) {
			try {

				InputStream inputstream = file.getInputstream();
				photo.setSpecimenId(specimen.getId());
				//pass the photo data and the photo metadata to our busniess logic layer
				plantService.save(getPhoto(),inputstream);
				FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			} catch (IOException ex) {
				FacesMessage message = new FacesMessage("there was a problem, your file was not upload");
				FacesContext.getCurrentInstance().addMessage(null, message);
				ex.printStackTrace();
			}
		
		}else {
		 System.out.println("file null");	
		}
		return "";
	}
    public void fileUploadListener(FileUploadEvent e){
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
    }
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
		loadSpecimens();
	}

	private void loadSpecimens() {
		// TODO Auto-generated method stub
		plantService.loadSpecimens(plant);

	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}

	public String save() {
		// set the foreign key to plant id before saving
		specimen.setPlantId(plant.getGuid());
		try {
			plantService.save(specimen);
			return "specimenSaved";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}

	public void onRowSelect(SelectEvent event) {
		Specimen specimen = ((Specimen) event.getObject());
		// push selected plant into epeciemenVO
		setSpecimen(specimen);
		//find the matching photos for that specimen
//		photos=plantService.fetchPhotos(specimen);
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect("specimen.xhtml");
			}catch(IOException ex){
				ex.printStackTrace();
			}
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}
