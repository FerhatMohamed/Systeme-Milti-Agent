package consummer;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class ConsummerContainer {

	public static void main(String[] args) {
		try {
			Runtime rt = Runtime.instance();
			ProfileImpl pc = new ProfileImpl(false);
			pc.setParameter(ProfileImpl.MAIN_HOST, "localhost"); 
			AgentContainer consomateur = rt.createAgentContainer(pc);
			AgentController agentController = consomateur.createNewAgent("consommateur", ConsomateurAgent.class.getName(), new Object[]{});
			agentController.start();
		} catch (ControllerException e) {
			e.printStackTrace();
		}
        
	}

}
