package acheteur;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class AcheteurContainer {

	public static void main(String[] args) {
		try {
			Runtime rt = Runtime.instance();
			ProfileImpl pc = new ProfileImpl(false);
			pc.setParameter(ProfileImpl.MAIN_HOST, "localhost"); 
			AgentContainer Acheteur = rt.createAgentContainer(pc);
			AgentController agentController = Acheteur.createNewAgent("acheteur", AcheteurAgent.class.getName(), new Object[]{});
			agentController.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
        
	}

}
