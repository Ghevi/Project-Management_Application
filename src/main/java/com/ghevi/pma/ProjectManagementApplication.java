package com.ghevi.pma;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import com.ghevi.pma.springExample.Car;
import com.ghevi.pma.springExample.Doors;
import com.ghevi.pma.springExample.Engine;
import com.ghevi.pma.springExample.Tires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"com.ghevi.pma", "com.ghevi.utils"})
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository proRepo;


	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}


	// every where we use autwired for a Car car it will create an istance with this method that will be injected in Car car;
	/* Moved to manufactureConfig

	Down is done again cuz i watched the video 2 times xd

	@Bean
	public Car newCar(){
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();

		return  new Car(e, d, t);
	}*/


	/* This pre populate the app with data manually, but it belongs in a data file

	Spring scan all the children packages of com.x.x, this is called Spring Context

	// This is how we would set up the @Autowired car, we could write @Autowired then Car car below it, and
	// Spring will initiate this class. The Crud interfaces are already defined in Sring so we dont need to define them like this car.
	// This is called Dependency Injection
	@Bean
	public Car newCar(){
		Engine e = new Engine();
		Doors e = new Doors();
		Tires e = new Tires();

		return new Car(e, d, t);
	}

	Or a better way is to create a Configuration class inside the Car classes package:

	@Configuration
	public class ManufactureConfig {
			@Bean
			public Car newCar(){
				Engine e = new Engine();
				Doors e = new Doors();
				Tires e = new Tires();

				return new Car(e, d, t);
			}
	}




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
