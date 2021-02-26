package com.example.positionTracking.domain;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class PositionOfVehicle implements Comparable<PositionOfVehicle>{
	
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="UTC")
	private Date timeStamp;
	
	public PositionOfVehicle() {}
	
	

	public PositionOfVehicle(String latitude, String longitude, String timeStamp) {
		this.latitude = new BigDecimal(latitude);
		this.longitude = new BigDecimal(longitude);
		DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		try {
			this.timeStamp = format.parse(timeStamp);
		} 
		catch (ParseException e) 
		{
			// code error
			throw new RuntimeException(e);
		} 
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public int compareTo(PositionOfVehicle o) {
		return o.timeStamp.compareTo(this.timeStamp);
	}
	
	

}
