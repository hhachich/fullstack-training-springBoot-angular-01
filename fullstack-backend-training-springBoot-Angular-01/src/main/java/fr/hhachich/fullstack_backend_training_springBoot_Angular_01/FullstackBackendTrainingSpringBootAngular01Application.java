package fr.hhachich.fullstack_backend_training_springBoot_Angular_01;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Payment;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentStatus;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentType;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Student;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.PaymentRepository;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class FullstackBackendTrainingSpringBootAngular01Application {

	public static void main(String[] args) {
		SpringApplication.run(FullstackBackendTrainingSpringBootAngular01Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository){
		return args -> {
			// creation des etudiants
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("user1").lastName("u1").code("1").programId("HHACH").build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("user2").code("2").programId("HHACH").build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("user3").code("3").programId("HHACH").build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("user4").code("4").programId("HHACH").build());
			studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("user5").code("5").programId("HHACH").build());

			PaymentType[] paymentTypes =PaymentType.values();
			Random random = new Random();
			studentRepository.findAll().forEach(st ->{
				int index = random.nextInt(paymentTypes.length);
				for (int i=0; i<10;i++){
					Payment payment = Payment
										.builder()
										.amount(1000+(int)(Math.random()*20000))
										.type(paymentTypes[index])
										.status(PaymentStatus.CREATED)
										.date(LocalDate.now())
										.student(st )
										.build();
					paymentRepository.save(payment);
				}
			});
		};
	}
}
