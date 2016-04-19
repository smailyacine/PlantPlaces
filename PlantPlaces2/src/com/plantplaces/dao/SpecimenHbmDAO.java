package com.plantplaces.dao;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.event.SelectEvent;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
/**
 * a hibernate persistence implementation specimen
 * @author ysmail
 *
 */
@Named
public class SpecimenHbmDAO extends PlantPlacesHbmDAO<Specimen> implements ISpecimenDAO {


public List<Specimen> fetchByPlantId(int plantId){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("from Specimen where plantId = :plantId");
	query.setParameter("plantId",plantId);
//	query.setProperties(plant);
	@SuppressWarnings("rawtypes")
	List list = query.list();
	List<Specimen> specimens = Collections.checkedList(list, Specimen.class);
	return specimens;
}
@Override
public void insert(Session session, Specimen dto) throws Exception {
	// TODO Auto-generated method stub
	session.save(dto);
}
}
