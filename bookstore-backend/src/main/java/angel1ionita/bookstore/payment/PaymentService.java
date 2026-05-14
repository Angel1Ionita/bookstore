package angel1ionita.bookstore.payment;

import angel1ionita.bookstore.exception.ResourceNotFoundException;
import angel1ionita.bookstore.payment.dto.PaymentRequestDto;
import angel1ionita.bookstore.payment.dto.PaymentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    private Payment getOrThrow(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("payment", id));
    }

    public PaymentResponseDto getById(Long id) {
        Payment payment = getOrThrow(id);
        return mapper.toResponseDto(payment);
    }

    public List<PaymentResponseDto> getAll() {
        return mapper.toResponseDto(paymentRepository.findAll());
    }

    @Transactional
    public PaymentResponseDto create(PaymentRequestDto paymentRequestDto) {
        Payment payment = mapper.toEntity(paymentRequestDto);
        return mapper.toResponseDto(paymentRepository.save(payment));
    }

    @Transactional
    public PaymentResponseDto update(PaymentRequestDto paymentRequestDto, Long id) {
        Payment payment = getOrThrow(id);
        mapper.updateEntity(paymentRequestDto, payment);
        return mapper.toResponseDto(paymentRepository.save(payment));
    }

    @Transactional
    public void delete(Long id) {
        Payment payment = getOrThrow(id);
        paymentRepository.delete(payment);
    }
}
