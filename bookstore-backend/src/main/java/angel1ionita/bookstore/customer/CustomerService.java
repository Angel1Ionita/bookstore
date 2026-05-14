package angel1ionita.bookstore.customer;

import angel1ionita.bookstore.customer.dto.CustomerRequestDto;
import angel1ionita.bookstore.customer.dto.CustomerResponseDto;
import angel1ionita.bookstore.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    private Customer getOrThrow(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer", id));
    }

    public CustomerResponseDto getById(Long id) {
        Customer customer = getOrThrow(id);
        return mapper.toResponseDto(customer);
    }

    public List<CustomerResponseDto> getAll() {
        return mapper.toResponseDto(customerRepository.findAll());
    }

    @Transactional
    public CustomerResponseDto create(CustomerRequestDto customerRequestDto) {
        Customer customer = mapper.toEntity(customerRequestDto);
        return mapper.toResponseDto(customerRepository.save(customer));
    }

    @Transactional
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto, Long id) {
        Customer customer = getOrThrow(id);
        mapper.updateEntity(customerRequestDto, customer);
        return mapper.toResponseDto(customerRepository.save(customer));
    }

    @Transactional
    public void delete(Long id) {
        Customer customer = getOrThrow(id);
        customerRepository.delete(customer);
    }
}
