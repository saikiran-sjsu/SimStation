package Plague;

import SimStation.*;
import mvc.Utilities;

import java.util.Random;

public class Plague extends Agent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
    private boolean infected;
    private boolean immunity;
    public int speed;
    public Plague neighbor;

    public Plague(Simulation thisSimulation) {

        super("Plague", thisSimulation);
        int safezone = Utilities.rng.nextInt(100);
        immunity = safezone < PlagueSimulation.RESISTANCE; //safe from virus
        speed = rand.nextInt(8) + 1;
        infection();
    }

    public boolean isImmunity() { return immunity; }

    public void setInfected(boolean change){
        this.infected = change;

    }

    public boolean isInfected() {return infected;}

    public void infection(){
        if(!isImmunity()){
            int safezone = Utilities.rng.nextInt(100);
            this.infected = safezone < PlagueSimulation.VIRULENCE;
        }
    }

    public void cured() {
        if(this.isInfected()){
            int safezone = Utilities.rng.nextInt(100);
            this.infected = !(safezone < PlagueSimulation.CURE);
        }
    }

    @Override
    public void update() {
        Random rand = new Random();
        this.setHeading(Heading.getRandomHeading());
        neighbor = (Plague) this.getWorld().getNeighbor(this, 20);
        if(neighbor.isInfected() && !(this.isInfected())){
            this.infection();

//            if(this.isInfected()){
//                neighbor.setInfected(false);
//            }
        }

        cured();



        this.move(speed);

    }
}
