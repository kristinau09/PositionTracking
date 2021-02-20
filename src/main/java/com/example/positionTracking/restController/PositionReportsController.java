package com.example.positionTracking.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.positionTracking.DataRepository;
import com.example.positionTracking.PositionOfVehicle;
import com.example.positionTracking.VehicleNotFoundException;



@RestController
public class PositionReportsController 
{
	@Autowired
	private DataRepository data;
	
	@RequestMapping(method=RequestMethod.GET,value="/vehicles/{vehicleName}")
	public ResponseEntity<PositionOfVehicle> getLatestReportForVehicle(@PathVariable String vehicleName)
	{
		try 
		{
			PositionOfVehicle position = data.getLatestPositionFor(vehicleName);
			return new ResponseEntity<PositionOfVehicle>(position, HttpStatus.OK);
		} 
		catch (VehicleNotFoundException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}