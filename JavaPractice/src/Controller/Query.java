package Controller;

import java.util.Scanner;

import Model.DAO;

public class Query implements Command {

	@SuppressWarnings("resource")
	@Override
	public void execute(String Command) {
		String[] cmdArray = Command.split(" ");
		String commandOperator = getCommandOperator(cmdArray);
		String commandParameter = getCommandParameter(cmdArray);
		DAO dao = readXML(commandOperator, commandParameter);

		while (true) {
			System.out.print("?> ");
			Command = new Scanner(System.in).nextLine();
			cmdArray = Command.split(" ");
			if (cmdArray.length >= 2) {
				commandOperator = getCommandOperator(cmdArray);
				commandParameter = getCommandParameter(cmdArray);
				switch (commandOperator) {
				case "LOAD":
					dao = readXML(commandOperator, commandParameter);
					break;
				case "PERSON":
					dao.searchPerson(commandParameter);
					break;
				case "SUBJECT":
					dao.searchSubject(commandParameter);
					break;
				case "PMAX":
					dao.pMax(commandParameter);
					break;
				case "PMIN":
					dao.pMin(commandParameter);
					break;
				case "PAVG":
					dao.pAvg(commandParameter);
					break;
				case "SMAX":
					dao.sMax(commandParameter);
					break;
				case "SMIN":
					dao.sMin(commandParameter);
					break;
				case "SAVG":
					dao.sAvg(commandParameter);
					break;
				case "EXIT":
					System.out.println("Bye! Bye!");
					return;
				default:
					System.out.println("잘못된 명령어입니다.");
					break;
				}
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}

	private String getCommandParameter(String[] cmdArray) {
		String commandParameter = cmdArray[1];
		return commandParameter;
	}

	private String getCommandOperator(String[] cmdArray) {
		String commandOperator = cmdArray[0];
		return commandOperator;
	}

	private DAO readXML(String commandOperator, String commandParameter) {
		DAO dao = new DAO(commandParameter);
		dao.readXML();
		return dao;
	}
}
