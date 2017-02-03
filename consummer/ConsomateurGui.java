package consummer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jade.gui.GuiEvent;
import jade.util.leap.Map;

public class ConsomateurGui extends JFrame {
	private JLabel jlagent = new JLabel("Nom Agent:");
	private JTextField jtfaagent = new JTextField(12);
	private JLabel jlliver = new JLabel("Liver:");
	private JTextField jtfaliver = new JTextField(12);
    private JButton jbenvoyer = new JButton("Envoyer");
    private JTextArea jtarea = new JTextArea();
    
    private ConsomateurAgent consomateurAgent ;
    
	public ConsomateurGui(){
		jtarea.setFont(new Font("Arial", Font.BOLD, 20));
    	jtarea.setEditable(false);
		JPanel jpIn = new JPanel();
    	jpIn.setLayout(new FlowLayout());
    	jpIn.add(jlagent);
    	jpIn.add(jtfaagent);
    	jpIn.add(jlliver);
    	jpIn.add(jtfaliver);
    	jpIn.add(jbenvoyer);
    	this.setLayout(new BorderLayout());
    	this.add(jpIn ,BorderLayout.NORTH);
    	this.add(new JScrollPane(jtarea), BorderLayout.CENTER);
    	this.setSize(600,400);
    	this.setVisible(true);
    	
    	jbenvoyer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String agentName = jtfaagent.getText();
				String liver = jtfaliver.getText();
				GuiEvent gev = new GuiEvent(this, 1);
				//Map params = (Map) new HashMap();
				//params.put("agentAcheteur", agentName);
				//params.put("liver", liver);
				gev.addParameter(agentName);
				gev.addParameter(liver);
				
				consomateurAgent.onGuiEvent(gev);
			}
		});
    }
	
	public ConsomateurAgent getConsomateurAgent() {
		return consomateurAgent;
	}
	public void setConsomateurAgent(ConsomateurAgent consomateurAgent) {
		this.consomateurAgent = consomateurAgent;
	}
	
	public void showMesssage(String msg, boolean append){
		if(append == true){
			jtarea.append(msg+"\n");
		}
		else
			jtarea.setText(msg);
	}
}
