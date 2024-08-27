package fr.hhachich.fullstack_backend_training_springBoot_Angular_01.dtos;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentStatus;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentType;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor 
@ToString
@Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}
