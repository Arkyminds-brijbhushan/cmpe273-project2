package edu.sjsu.cmpe.isns.ui.views;

import com.yammer.dropwizard.views.View;


public class HomeView extends View {
    

    public HomeView() {
    	
	super("home.mustache");
	System.out.println("In Home View");
    }

   
}
