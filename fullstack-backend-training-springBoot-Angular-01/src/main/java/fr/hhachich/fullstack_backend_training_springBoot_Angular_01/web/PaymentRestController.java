package fr.hhachich.fullstack_backend_training_springBoot_Angular_01.web;

import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.dtos.NewPaymentDTO;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Payment;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentStatus;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.PaymentType;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.entities.Student;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.PaymentRepository;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.repository.StudentRepository;
import fr.hhachich.fullstack_backend_training_springBoot_Angular_01.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class PaymentRestController {
    private final StudentRepository studentRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;

    @GetMapping(path = "/payments")
    public List<Payment> allPayments(){
        return paymentRepository.findAll();
    }
    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> paymentsByStudents(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path = "/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).get();
    }
    @PutMapping(path = "/payments/{id}")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status ,@PathVariable Long id){
        return paymentService.updatePaymentStatus(status,id);
    }
    @GetMapping(path = "/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    @GetMapping(path = "/students/{code}")
    public Student getStudentByCode(@PathVariable String code){
        return studentRepository.findByCode(code);
    }
    @GetMapping(path = "/studentsByProgramId")
    public List<Student> getStudentByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }
    @PostMapping(path = "/payments",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam("file") MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        System.out.println("savePayment"+ newPaymentDTO.toString());
        return paymentService.savePayment(file, newPaymentDTO);
    }
    @GetMapping(path = "/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPayementFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPayementFile(paymentId);
    }
}
