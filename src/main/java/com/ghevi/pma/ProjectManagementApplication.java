package com.ghevi.pma;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository proRepo;


	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

	/* This pre populate the app with data manually, but it belongs in a data file
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Employee emp1 = new Employee("Ghevi", "Sartor", "ghevi96@gmail.com");
			Employee emp2 = new Employee("Marco", "Ubaldi", "marcoubaldi@gmail.com");
			Employee emp3 = new Employee("Cristo", "Foro", "cristoforo@yahoo.com");

			Employee emp4 = new Employee("Ramona", "Balaschi", "romanabalaschi@msn.com");
			Employee emp5 = new Employee("Giulia", "Crisemo", "giuliacrisemo@gmail.com");
			Employee emp6 = new Employee("Klessio", "Fatopo", "klessiofatopo@virgilio.com");

			Employee emp7 = new Employee("Melino", "Zaleno", "melinozaleno@yandex.com");
			Employee emp8 = new Employee("Chiara", "Pascal", "chiarapscal@mail.com");
			Employee emp9 = new Employee("Sara", "Frunolo", "sarafrunolo@hotmail.com");

			Project pro1 = new Project("Large Production Deploy", "NOTSTARTED", "Bring to nation");
			Project pro2 = new Project("Small Production Deploy", "COMPLETED", "Deploy in town");
			Project pro3 = new Project("National Production Deploy", "INPROGRESS", "Hell yeah murica");
			Project pro4 = new Project("World wide Production Deploy", "INPROGRESS", "It comes to the world");

			// need to set both sides of the relationship manually
			pro1.addEmployee(emp1);
			pro1.addEmployee(emp2);
			pro2.addEmployee(emp3);
			pro3.addEmployee(emp1);
			pro4.addEmployee(emp1);
			pro4.addEmployee(emp3);

			// need to set both sides of the relationship manually
			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
			emp2.setProjects(Arrays.asList(pro1));
			emp3.setProjects(Arrays.asList(pro2, pro4));

			// save projects in database
			empRepo.save(emp1);
			empRepo.save(emp2);
			empRepo.save(emp3);
			empRepo.save(emp4);
			empRepo.save(emp5);
			empRepo.save(emp6);
			empRepo.save(emp7);
			empRepo.save(emp8);
			empRepo.save(emp9);

			// save projects in database
			proRepo.save(pro1);
			proRepo.save(pro2);
			proRepo.save(pro3);
			proRepo.save(pro4);

		};
	}
	*/
}
