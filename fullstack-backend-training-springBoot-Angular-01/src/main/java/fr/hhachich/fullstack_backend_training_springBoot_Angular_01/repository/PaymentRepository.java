package fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Payment;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentStatus;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
