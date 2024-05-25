package com.proyectos.app.controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.proyectos.app.component.ApiKey;
import com.proyectos.app.config.LogPattern;
import com.proyectos.app.entity.Proveedor;
import com.proyectos.app.model.SuccessResponses;
import com.proyectos.app.service.ProveedorService;
import com.proyectos.app.util.Constants;

@RestController
@RequestMapping(path = "/proveedor")
public class ProveedorController implements ErrorController, WebMvcConfigurer {

	private static final Logger LOGGER = LogManager.getLogger(ProveedorController.class);
	private final LogPattern logPattern = new LogPattern(Constants.domainCode, Constants.solutioNameCode,
			Constants.platform, Constants.tower, this.getClass().getName());
	private final String lHeaders=" headers= ";
	private final String lUrl=" InfoUrl= ";
	private final String lBody=" body= ";
	
	@Autowired
	ProveedorService service;
	
	@Autowired
	ApiKey apikey;
	
	
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProveedors(@RequestHeader(required = false) Map<?,?> headers) {
    	//apikey.getApiKey();
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), null,
				startTime));
        return SuccessResponses.ok(service.getAllProveedors());
    }
    
    @GetMapping(path = "/id/{proveedorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProveedorById(@RequestHeader(required = false) Map<?,?> headers,@PathVariable Long proveedorId) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), lUrl+proveedorId.toString(),
				startTime));
        return SuccessResponses.ok(service.getProveedorById(proveedorId));
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createdProveedor(@RequestHeader(required = false) Map<?,?> headers,@Validated @RequestBody Proveedor empleados) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), lBody+empleados.toString(),
				startTime));
        return SuccessResponses.ok(service.createProveedor(empleados));
    }
    
    @DeleteMapping(path = "/id/{proveedorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProveedor(@RequestHeader(required = false) Map<?,?> headers,@PathVariable Long proveedorId) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), lUrl+proveedorId.toString(),
				startTime));
        return SuccessResponses.ok(service.deleteProveedor(proveedorId));
    }
    
    
        
    @PatchMapping(path = "/id/{proveedorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProveedor(@RequestHeader(required = false) Map<?,?> headers,@PathVariable Integer proveedorId, @Validated @RequestBody Proveedor empleados) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		Long startTime = System.currentTimeMillis();
		String idTransaction = String.valueOf(startTime);
        LOGGER.info(logPattern.buildPattern(methodName, idTransaction,lHeaders+headers.toString(), lUrl+proveedorId.toString() +" body="+empleados.toString(),
				startTime));
    	return SuccessResponses.ok(service.updateProveedor(proveedorId, empleados));
    }
    

    
    
}
