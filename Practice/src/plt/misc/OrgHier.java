package plt.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrgHier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person bigBoss = null;

		Map<String, Person> personsMap = new HashMap<String, Person>();

		while (EmployeeRecordProvider.hasNext()) {

			Employee emp = EmployeeRecordProvider.getNextRecord();

			Person newPerson = personsMap.get(emp.SSN);

			if (newPerson == null) {
				newPerson = new Person(emp.name, emp.SSN, null);
				personsMap.put(emp.SSN, newPerson);
			}
			else {
				// update info
				newPerson.name = emp.name;
			}

			if (emp.managerSSN == null) {
				if (bigBoss != null) {
					// throw new MultipleBossesFoundException
					System.out.println("Multiple bosses found!");
					return;
				}
				bigBoss = newPerson;
			}
			else {
				Person boss = personsMap.get(emp.managerSSN);

				if (boss == null) {
					// create the boss
					boss = new Person(null, emp.managerSSN, null);
					personsMap.put(emp.managerSSN, boss);
				}

				if (boss.reports == null) {
					boss.reports = new ArrayList<Person>();
				}
				boss.reports.add(newPerson);
			}
		}

		System.out.println("Big Boss is: " + bigBoss.name);

		printTree(bigBoss, 1);

	}

	private static void printTree(Person person, int level) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < level * 2; i++) {
			sb.append("-");
		}

		System.out.println(sb.toString() + person.name);

		if (person.reports != null) {

			for (Person report : person.reports) {
				printTree(report, level + 1);
			}
		}

	}

	private static class Person {

		public String name;
		public String SSN;
		public List<Person> reports;

		public Person(String name, String SSN, List<Person> reports) {

			this.name = name;
			this.SSN = SSN;
			this.reports = reports;

		}

		// @Override
		// public boolean equals(Object obj) {
		//
		// return this.SSN.equals(((Person) obj).SSN);
		// }
	}

	private static class Employee {

		public String name;
		public String SSN;
		public String managerSSN;

		public Employee(String name, String SSN, String managerSSN) {

			this.name = name;
			this.SSN = SSN;
			this.managerSSN = managerSSN;

		}
	}

	private static class EmployeeRecordProvider {

		private static int recNo = 0;

		private static List<OrgHier.Employee> employees = null;

		public static boolean hasNext() {

			if (employees == null) {
				initEmployeeRecords();
			}

			if (recNo == employees.size()) {
				return false;
			}
			return true;
		}

		public static Employee getNextRecord() {

			if (employees == null) {
				initEmployeeRecords();
			}

			return employees.get(recNo++);
		}

		private static void initEmployeeRecords() {

			employees = new ArrayList<Employee>();

			// employees.add(new Employee("Patrick Tan", "9", "5"));
			// employees.add(new Employee("Emily Tan", "7", "4"));
			// employees.add(new Employee("Matt Shields", "4", "2"));
			// employees.add(new Employee("Carl Milano", "5", "2"));
			// employees.add(new Employee("Clint Cook", "2", "1"));
			// employees.add(new Employee("Sandi", "10", "3"));
			// employees.add(new Employee("Lorraine", "11", "3"));
			// employees.add(new Employee("Andy", "8", "5"));
			// employees.add(new Employee("Nick Wislocki", "1", null));
			// employees.add(new Employee("Laura G", "3", "1"));
			// employees.add(new Employee("Pavel Fusu", "6", "4"));

			// employees.add(new Employee("Nick Wislocki", "1", null));
			// employees.add(new Employee("Clint Cook", "2", "1"));
			// employees.add(new Employee("Laura G", "3", "1"));
			// employees.add(new Employee("Matt Shields", "4", "2"));
			// employees.add(new Employee("Carl Milano", "5", "2"));
			// employees.add(new Employee("Pavel Fusu", "6", "4"));
			// employees.add(new Employee("Emily Tan", "7", "4"));
			// employees.add(new Employee("Andy", "8", "5"));
			// employees.add(new Employee("Patrick Tan", "9", "5"));
			// employees.add(new Employee("Sandi", "10", "3"));
			// employees.add(new Employee("Lorraine", "11", "3"));

			employees.add(new Employee("Lorraine", "11", "3"));
			employees.add(new Employee("Sandi", "10", "3"));
			employees.add(new Employee("Patrick Tan", "9", "5"));
			employees.add(new Employee("Andy", "8", "5"));
			employees.add(new Employee("Emily Tan", "7", "4"));
			employees.add(new Employee("Pavel Fusu", "6", "4"));
			employees.add(new Employee("Carl Milano", "5", "2"));
			employees.add(new Employee("Matt Shields", "4", "2"));
			employees.add(new Employee("Laura G", "3", "1"));
			employees.add(new Employee("Clint Cook", "2", "1"));
			employees.add(new Employee("Nick Wislocki", "1", null));
		}

	}

}
