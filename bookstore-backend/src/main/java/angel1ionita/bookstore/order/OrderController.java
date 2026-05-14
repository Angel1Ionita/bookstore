package angel1ionita.bookstore.order;

import angel1ionita.bookstore.order.dto.OrderRequestDto;
import angel1ionita.bookstore.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderResponseDto getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<OrderResponseDto> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public OrderResponseDto create(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.create(orderRequestDto);
    }

    @PutMapping("/{id}")
    public OrderResponseDto update(@RequestBody OrderRequestDto orderRequestDto, @PathVariable Long id) {
        return orderService.update(orderRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
