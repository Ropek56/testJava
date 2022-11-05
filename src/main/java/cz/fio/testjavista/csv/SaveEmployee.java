package cz.fio.testjavista.csv;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import cz.fio.testjavista.entity.Employee;

public class SaveEmployee {

	public static void save(Employee employee) {
		Charset cs = Charset.forName("Cp1250");
		Path path = Paths.get(System.getProperty("java.io.tmpdir") + "contacts.csv");
		File file = new File(path.toString());
		ArrayList<Employee> employees = new ArrayList<Employee>();

		try {
			if (!file.exists())
				file.createNewFile();

			List<String> lines = Files.readString(path, cs).lines().toList();
			lines.forEach(line -> employees.add(createEmployee(line.split(","))));

			if (!employees.contains(employee)) {
				String text = employee.getFirstName() + "," + employee.getLastName() + "," + employee.getEmail() + "\n";
				Files.writeString(path, text, cs, StandardOpenOption.APPEND);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private static Employee createEmployee(String[] data) {
		if (data.length != 3)
			return null;

		String firstName = data[0];
		String lastName = data[1];
		String email = data[2];

		// create and return book of this metadata
		return new Employee(firstName, lastName, email);
	}

}
