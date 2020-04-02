package SimStation;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import mvc.AppFactory;
import mvc.AppPanel;

public class SimStationPanel extends AppPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton startBtn, stopBtn, suspendBtn, statsBtn, resumeBtn;
	
	public SimStationPanel(AppFactory factory) {
		super(factory);
		startBtn = new JButton("Start");
		stopBtn = new JButton("Stop");
		suspendBtn = new JButton("Suspend");
		statsBtn = new JButton("Stats");
		resumeBtn = new JButton("Resume");
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		suspendBtn.addActionListener(this);
		statsBtn.addActionListener(this);
		resumeBtn.addActionListener(this);
		init();
	}
	
	public void init() {
		this.setLayout(new GridLayout(1, 2));
		
		JPanel allBtnPanel = new JPanel();
		allBtnPanel.setLayout(new GridLayout(5, 1));
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		
		btnPanel.add(startBtn);
		allBtnPanel.add(btnPanel);
		
		btnPanel = new JPanel();
		btnPanel.add(suspendBtn);
		allBtnPanel.add(btnPanel);
		
		btnPanel = new JPanel();
		btnPanel.add(resumeBtn);
		allBtnPanel.add(btnPanel);
		
		btnPanel = new JPanel();
		btnPanel.add(stopBtn);
		allBtnPanel.add(btnPanel);
		
		btnPanel = new JPanel();
		btnPanel.add(statsBtn);
		allBtnPanel.add(btnPanel);
		
		this.add(allBtnPanel);
		
		JPanel view = new JPanel();
		view.add(new SimStationView((SimStation) model));
		this.add(view);
		
	}
	
	public static void main(String[] args) {
		AppFactory factory = new SimStationFactory();
		SimStationPanel simPanel = new SimStationPanel(factory);
		simPanel.display();
	}

}
