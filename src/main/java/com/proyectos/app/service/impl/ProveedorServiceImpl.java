package com.proyectos.app.service.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.proyectos.app.entity.Database;
import com.proyectos.app.entity.Proveedor;
import com.proyectos.app.excepcion.ResourceNotFoundException;
import com.proyectos.app.model.ResponseGeneric;
import com.proyectos.app.model.ResponseMetodos;
import com.proyectos.app.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	

	@Autowired
	private ResponseMetodos responsegeneric;
	
	
	@Override
	public ResponseGeneric getAllExtras() {

		

		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("bd.json");
			 Database person = gson.fromJson(reader, Database.class);
			 ResponseGeneric response = responsegeneric.selectregistros();
			 response.setData(person.getTablas().extras);
		  return response;
		}catch (Exception e) {
			System.out.println(e);
			throw new ResourceNotFoundException("No hay registros");
		}
			
	}
	
	@Override
	public ResponseGeneric getAllProveedors() {

		

		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("bd.json");
			 Database person = gson.fromJson(reader, Database.class);
			 ResponseGeneric response = responsegeneric.selectregistros();
			 response.setData(person.getTablas().proveedor);
		  return response;
		}catch (Exception e) {
			System.out.println(e);
			throw new ResourceNotFoundException("No hay registros");
		}
			
	}
	
	

	@Override
	public ResponseGeneric getProveedorById(Long empleadoId) {
		
		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("bd.json");
			 Database person = gson.fromJson(reader, Database.class);
			 ResponseGeneric response = responsegeneric.selectregistros();
			 
			 
			 List<Proveedor> listProv = new ArrayList<>();
			 for(Proveedor prov : person.getTablas().proveedor) {
				 if(prov.getId().equals(empleadoId)) {
					 listProv.add(prov);
				 }
			 }
			 response.setData(listProv);
			 
		  return response;
		}catch (Exception e) {
			System.out.println(e);
			throw new ResourceNotFoundException("No hay registros");
		}

	}

	@Override
	public ResponseGeneric createProveedor(Proveedor empleados) {

		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("bd.json");
			 Database person = gson.fromJson(reader, Database.class);
			 ResponseGeneric response = responsegeneric.createregistros();			 
			 List<Proveedor> listProv = new ArrayList<>();
			 for(Proveedor prov : person.getTablas().proveedor) {
				 if(prov.getNombre().equals(empleados.getNombre())) {
					 listProv.add(prov);
			 }
				 
				 
			}
				 
				if(listProv.isEmpty()) {
					
					long epochSeconds = Instant.now().toEpochMilli();
					empleados.setId(epochSeconds);
					person.getTablas().proveedor.add(empleados);
					 String json = gson.toJson(person);			 
					 FileWriter file = new FileWriter("bd.json");
					 file.write(json);
					 file.flush();
					 file.close();
					}else {
						response = responsegeneric.createregistroDuplicado();
					}
				
			 response.setData(listProv);
			 
		  return response;
		}catch (Exception e) {
			System.out.println(e);
			throw new ResourceNotFoundException("No hay registros");
		}
	}

	
	
	
	
	
	@Override
	public ResponseGeneric deleteProveedor(Long empleadoId) {

		try {
			Gson gson = new Gson();
			Reader reader = new FileReader("bd.json");
			 Database person = gson.fromJson(reader, Database.class);
			 ResponseGeneric response = responsegeneric.deleteregistro();		 
			 List<Proveedor> listProv = new ArrayList<>();
			 List<Proveedor> listProv2 = new ArrayList<>();
			 for(Proveedor prov : person.getTablas().proveedor) {
				 if(prov.getId().equals(empleadoId)) {
					 listProv.add(prov);
			 }else {
				 listProv2.add(prov);
			 }
				 
				 
			}
				 
				if(!listProv.isEmpty()) {		
					person.getTablas().proveedor=listProv2;
					 String json = gson.toJson(person);			 
					 FileWriter file = new FileWriter("bd.json");
					 file.write(json);
					 file.flush();
					 file.close();
					}
							 
		  return response;
		}catch (Exception e) {
			System.out.println(e);
			throw new ResourceNotFoundException("No hay registros");
		}
	}
	
	
	
	@Override
	public ResponseGeneric updateProveedor(Integer empleadoId, Proveedor empleado) {
		/*
		empleado.setId(empleadoId);
		repository.save(empleado);

		ResponseGeneric response = responsegeneric.updateregistro();
		return response;
		*/
		 ResponseGeneric response = responsegeneric.selectregistros();
		 return response;
	}



}
