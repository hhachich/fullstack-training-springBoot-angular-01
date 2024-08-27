package fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,String> {
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);
}
