package com.plantplaces.ui;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class AddPlant {

	final static Logger logger = Logger.getLogger(AddPlant.class);

	@Inject
	private Plant plant;

	@Inject
	private IPlantService plantService;
	
	private String message = "foo";

	public String execute() {
		logger.info("entering the Execute method");
		String returnValue = "";
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		try {
			plantService.save(plant);

			logger.info("save is successfull " + plant.toString());
			// the messge that want to display
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "saved", "Plant saved");
			currentInstance.addMessage(null, fm);
		} catch (Exception e) {
			logger.error("error while saving plant. Message" + e.getMessage());

			e.printStackTrace();
			returnValue = "fail";

			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "unable to saved", "Plant not saved");
			currentInstance.addMessage(null, fm);
		}

		return returnValue;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
