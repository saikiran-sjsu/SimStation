package SimStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;

public class SimStationFactory implements AppFactory{

	@Override
	public Model makeModel() {
		return new SimStation();
	}

	@Override
	public String[] getEditCommands() {
		String[] result = new String[] {"Resume", "Start", "Stats", "Stop", "Suspend"};
		return result;
	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		if(type.toLowerCase().equals("resume")) {
			return new ResumeCommand(model);
		} else if(type.toLowerCase().equals("start")) {
			return new StartCommand(model);
		} else if(type.toLowerCase().equals("stats")) {
			return new StatsCommand(model);
		} else if(type.toLowerCase().equals("Stop")) {
			return new StopCommand(model);
		} else if(type.toLowerCase().equals("Suspend")) {
			return new SuspendCommand(model);
		}
		else {
			return null;
		}
	}

	@Override
	public String getTitle() {
		return "SimStation";
	}

	@Override
	public String[] getHelp() {
		String[] helps = new String[5];
		helps[0] = "Start to run";
		helps[1] = "Resume to continue the application";
		helps[2] = "Stats to retrieve the statistics";
		helps[3] = "Stop to quit the application";
		helps[4] = "Suspend application";
		return helps;
	}

	@Override
	public String about() {
		return "Sim Station version 1.0.";
	}

}
