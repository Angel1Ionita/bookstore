package angel1ionita.bookstore.order;

import angel1ionita.bookstore.exception.ResourceNotFoundException;
import angel1ionita.bookstore.order.dto.OrderRequestDto;
import angel1ionita.bookstore.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    private Order getOrThrow(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("order", id));
    }

    public OrderResponseDto getById(Long id) {
        Order order = getOrThrow(id);
        return mapper.toResponseDto(order);
    }

    public List<OrderResponseDto> getAll() {
        return mapper.toResponseDto(orderRepository.findAll());
    }

    @Transactional
    public OrderResponseDto create(OrderRequestDto orderRequestDto) {
        Order order = mapper.toEntity(orderRequestDto);
        return mapper.toResponseDto(orderRepository.save(order));
    }

    @Transactional
    public OrderResponseDto update(OrderRequestDto orderRequestDto, Long id) {
        Order order = getOrThrow(id);
        mapper.updateEntity(orderRequestDto, order);
        return mapper.toResponseDto(orderRepository.save(order));
    }

    @Transactional
    public void delete(Long id) {
        Order order = getOrThrow(id);
        orderRepository.delete(order);
    }
}
