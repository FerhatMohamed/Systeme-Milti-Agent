package main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties; 
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {
	public static void main(String[] args){
		try {
			Runtime rt = Runtime.instance();
			Properties p = new ExtendedProperties();
			p.setProperty(Profile.GUI, "true");
			ProfileImpl pc = new ProfileImpl(p);
			AgentContainer mainContainer = rt.createMainContainer(pc);
			mainContainer.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
				
	}
}
