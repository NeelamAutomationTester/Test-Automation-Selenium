package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPojo;

public class FakerUtility {
	
	public static AddressPojo getFakeAddress() {
	
		Faker faker = new Faker(Locale.US);
		
		AddressPojo address = new AddressPojo(faker.company().name(), faker.address().buildingNumber(),faker.address().streetAddress(), faker.address().cityName(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "additionalInfo", "Home Address", faker.address().state());
		
		return address;
		
	}

}
