package fr.hhachich.fullstack_backend_training_springBoot_Angular_01.services;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.dtos.NewPaymentDTO;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Payment;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentStatus;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Student;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.PaymentRepository;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class PaymentService {
    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;

    public Payment savePayment(MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"data","payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName= UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"data","payments",fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Student student=studentRepository.findByCode(newPaymentDTO.getStudentCode());
        Payment payment=Payment.builder()
                .type(newPaymentDTO.getType())
                .status(PaymentStatus.CREATED)
                .date(newPaymentDTO.getDate())
                .student(student)
                .amount(newPaymentDTO.getAmount())
                .file(filePath.toUri().toString())
                .build();
        return paymentRepository.save(payment);
    }

    public Payment updatePaymentStatus(PaymentStatus status, Long id){
        Payment payment = paymentRepository.findById(id).orElseThrow();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public byte[] getPayementFile(Long paymentId) throws IOException {
        Payment payment = paymentRepository.findById(paymentId).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}
