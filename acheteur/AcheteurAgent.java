package acheteur;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class AcheteurAgent extends Agent {
	
	@SuppressWarnings("serial")
	@Override
	protected void setup() {
		ParallelBehaviour behaviour = new ParallelBehaviour();
		
		addBehaviour(behaviour); 
		behaviour.addSubBehaviour(new CyclicBehaviour() {
			@Override
			public void action() {
				jade.lang.acl.ACLMessage aclMessage = receive();
				if (aclMessage != null){
					String livre = aclMessage.getContent();
					System.out.println("demend d'achat d'un livre :"+livre);
					
					// transactions
					jade.lang.acl.ACLMessage aclMesg2 = aclMessage.createReply();
					aclMesg2.setPerformative(jade.lang.acl.ACLMessage.INFORM);
					aclMesg2.setContent("vente");
					aclMesg2.setContent("demande reçue, traitement en cours");
					send(aclMesg2);
					
					
				}else block();
				
			}
		});
	}

}
