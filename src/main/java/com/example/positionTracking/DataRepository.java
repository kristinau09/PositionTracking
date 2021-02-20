package com.example.positionTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Repository;

/*
 * Just a standin for a proper database
 */
@Repository
public class DataRepository {
	
	Map<String,Queue<PositionOfVehicle>> positionQueues;
	
	public DataRepository()
	{
		positionQueues = new HashMap<>();
	}
	
	/*
	 * This method is going to take a map of strings for keys and strings for values 
	 * and this exactly the map we will get from the messages that we will be reading from the queue
	 * and stores data in the memory
	 */
	public void updatePosition(Map<String,String> data)
	{
		String vehicleName = data.get("vehicle");
		Queue<PositionOfVehicle> positions = positionQueues.get(vehicleName);
		if (positions == null) 
		{
			positions = new PriorityQueue<PositionOfVehicle>();
			positionQueues.put(vehicleName, positions);
		}
		PositionOfVehicle newPosition = new PositionOfVehicle(data.get("lat"), data.get("long"), data.get("time"));
		positions.add(newPosition);
	}
	
	/*
	 * Get position for a particular vehicle which will be used by rest end point
	 */
	
	public PositionOfVehicle getLatestPositionFor(String vehicleName) throws VehicleNotFoundException
	{
		Queue<PositionOfVehicle> queue = positionQueues.get(vehicleName);
		if (queue == null) throw new VehicleNotFoundException();
		return queue.peek();
	}

}
