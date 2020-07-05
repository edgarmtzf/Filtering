package com.filter.app.files.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.filter.app.files.model.FilterModel;
import com.filter.app.files.model.OutputModel;
import com.filter.app.files.processing.ReadInputFile;

/**
 * Controller that contains the main methods with the endpoint of the app-service.
 * 
 * @author Edgar
 * @since 05/07/2020
 */
@RestController
public class FilterFile {
	
	@Autowired
	private OutputModel om;
	
	@Autowired
	private ReadInputFile rif;
	
	@GetMapping("/filter")
	@ResponseStatus(HttpStatus.CREATED)
	public OutputModel filtering(@RequestBody FilterModel model){
		om.setDir(rif.readFile(model));
		return om;
	}
	
}
