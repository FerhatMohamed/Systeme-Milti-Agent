package consummer;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.introspection.ACLMessage;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.MessageTemplate;
import jade.tools.sniffer.Message;
import jade.util.leap.Map;

public class ConsomateurAgent extends GuiAgent{
    private ConsomateurGui gui;
    
	@Override
     protected void setup() {
        gui = new ConsomateurGui();
        gui.setConsomateurAgent(this);
		System.out.println("demarage de l'agent consomateur");
         
		
		
		addBehaviour(new CyclicBehaviour() {
			private int counter;
			@Override
			public void action() {
				++counter;
			 	gui.showMesssage("cyclic behaviour"+counter,true);
			 	/*
			 	MessageTemplate megtem = MessageTemplate.and(MessageTemplate.MatchPerformative(jade.lang.acl.ACLMessage.INFORM),
			 			                                     MessageTemplate.MatchOntology("vente")) ;
			 	*/
			 	jade.lang.acl.ACLMessage aclMessage = receive();
			 	if (aclMessage != null){
			 		gui.showMesssage("sender:"+aclMessage.getSender(), true);
			 		gui.showMesssage("acte de communication :"+jade.lang.acl.ACLMessage.getPerformative(aclMessage.getPerformative()), true);
			 		gui.showMesssage("content :"+aclMessage.getContent(), true);
			 		gui.showMesssage("langue :"+aclMessage.getLanguage(), true);
			 		gui.showMesssage("ontology :"+aclMessage.getOntology(),true);
			 	}
			 	else block();
			}
		});
		
		
     }
     
	
	@Override
	protected void onGuiEvent(GuiEvent ev) {
		switch (ev.getType()) {
		case 1:
			
		    //Map params= (Map)ev.getParameter(0);
			//String liver = (String) params.get("liver");
			//String agentAcheteur = (String) params.get("agentAcheteur");
		    String livre = (String) ev.getParameter(0);
		    String agentAcheteur = (String) ev.getParameter(0);
			
			jade.lang.acl.ACLMessage aclMessag = new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.REQUEST);
			aclMessag.addReceiver(new AID(agentAcheteur,AID.ISLOCALNAME));
			aclMessag.setContent(livre);
			aclMessag.setOntology("achat-vente");
			send(aclMessag);
			break;

		default:
			break;
		}
		
	}
     
     
}
