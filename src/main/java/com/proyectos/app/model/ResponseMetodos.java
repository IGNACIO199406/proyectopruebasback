package com.proyectos.app.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseMetodos {

	public ResponseGeneric createregistro() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se creo el registro con exito");
		return response;
	}
	
	public ResponseGeneric createregistroDuplicado() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("El registro esta duplicado");
		return response;
	}
	
	public ResponseGeneric createregistros() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se crearon los registros con exito");
		return response;
	}
	
	public ResponseGeneric deleteregistro() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se elimino el registro con exito");
		return response;
	}
	
	public ResponseGeneric updateregistro() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se actualizo el registro con exito");
		return response;
	}
	
	public ResponseGeneric updatectregistros() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se actualizaron los registros con exito");
		return response;
	}
	
	public ResponseGeneric deleteregistros() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se eliminaron los registros con exito");
		return response;
	}
	
	public ResponseGeneric selectregistros() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se obtuvieron los registros con exito");
		return response;
	}
	
	public ResponseGeneric selectregistro() {
		ResponseGeneric response = new ResponseGeneric();
		response.setCode(200);
		response.setReason("Success");
		response.setMessage("se obtuvo el registro con exito");
		return response;
	}
}
