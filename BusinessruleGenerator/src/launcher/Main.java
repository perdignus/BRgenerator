package launcher;

import data.BusinessRuleService;
import task.GeneratorController;

public class Main {
	public static void main(String[] args) {
		BusinessRuleService brc = new BusinessRuleService();
		GeneratorController gener = new GeneratorController(brc);
		gener.generate();
		for (String s : gener.getCode()) {
			gener.excecute(s);
			//s
		}

	}
}
