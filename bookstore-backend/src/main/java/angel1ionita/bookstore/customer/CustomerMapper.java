package angel1ionita.bookstore.customer;

import angel1ionita.bookstore.customer.dto.CustomerRequestDto;
import angel1ionita.bookstore.customer.dto.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequestDto customerRequestDto);

    void updateEntity(CustomerRequestDto customerRequestDto, @MappingTarget Customer customer);

    CustomerResponseDto toResponseDto(Customer customer);

    List<CustomerResponseDto> toResponseDto(List<Customer> customers);
}
