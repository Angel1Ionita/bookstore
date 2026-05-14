package angel1ionita.bookstore.customer;

import angel1ionita.bookstore.customer.dto.CustomerRequestDto;
import angel1ionita.bookstore.customer.dto.CustomerResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @GetMapping
    public List<CustomerResponseDto> getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerResponseDto create(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.create(customerRequestDto);
    }

    @PutMapping("/{id}")
    public CustomerResponseDto update(@RequestBody CustomerRequestDto customerRequestDto, @PathVariable Long id) {
        return customerService.update(customerRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.delete(id);
    }
}
