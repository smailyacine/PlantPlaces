package com.plantplaces.dto;


import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;


@Named
@ManagedBean
@Scope("session")
public class Plant {

	
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	private int guid;
	
	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCultivar() {
		return cultivar;
	}

	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}


	@Override//we overide the tostring method of the Object class to 
	//get a more readable output 
	public String toString() {
		return  common;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}
	
	
	
}
