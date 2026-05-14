package angel1ionita.bookstore.payment;

import angel1ionita.bookstore.payment.dto.PaymentRequestDto;
import angel1ionita.bookstore.payment.dto.PaymentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentResponseDto getById(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    @GetMapping
    public List<PaymentResponseDto> getAll() {
        return paymentService.getAll();
    }

    @PostMapping
    public PaymentResponseDto create(@RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentService.create(paymentRequestDto);
    }

    @PutMapping("/{id}")
    public PaymentResponseDto update(@RequestBody PaymentRequestDto paymentRequestDto, @PathVariable Long id) {
        return paymentService.update(paymentRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
