package angel1ionita.bookstore.payment;

import angel1ionita.bookstore.payment.dto.PaymentRequestDto;
import angel1ionita.bookstore.payment.dto.PaymentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toEntity(PaymentRequestDto paymentRequestDto);

    void updateEntity(PaymentRequestDto paymentRequestDto, @MappingTarget Payment payment);

    PaymentResponseDto toResponseDto(Payment payment);

    List<PaymentResponseDto> toResponseDto(List<Payment> payments);
}
