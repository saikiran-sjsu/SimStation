package Plague;

import SimStation.Agent;
import SimStation.Simulation;
import mvc.*;

import java.awt.*;
import java.util.LinkedList;

public class PlagueView extends View{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlagueView(Model model){
        super(model);
        setPreferredSize(new Dimension(Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
    }

    @Override
    protected void paintComponent(Graphics gc) {

        Color oldColor = gc.getColor();
        PlagueSimulation plague = (PlagueSimulation) model;
        LinkedList<Agent>agents = plague.getAgents();

        for(Agent a: agents){
            Plague p = (Plague) a;
            if(p.isInfected()){
                gc.setColor(Color.RED);

            }else{
                gc.setColor(Color.GREEN);
            }
            gc.fillOval(a.getX(), a.getY(), Simulation.SHAPE_SIZE, Simulation.SHAPE_SIZE);
        }
        gc.setColor(oldColor);

        //if your infected then green else red
    }
}
