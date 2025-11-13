package com.new_Project.AddToCart;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.HomeNeeds;
import utility.AndroidDriverUtilty;
import utility.GestureUtility;

@Listeners(utility.ListnerImplementaion.class)

public class AddProduct_Cart extends BaseClass {

	@Test
	public void addToCart()
	{
		
		gutility.clickByCoordinates(988, 158);
		hn=new HomeNeeds(driver);
	   driverUtilty.waitTillVisibilty(hn.getHomeNeedsToggle());
	   hn.getHomeNeedsToggle().click();
	  
	   
	    
	    
		
	}
	
}
