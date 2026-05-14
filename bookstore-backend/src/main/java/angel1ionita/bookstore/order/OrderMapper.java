package angel1ionita.bookstore.order;

import angel1ionita.bookstore.order.dto.OrderRequestDto;
import angel1ionita.bookstore.order.dto.OrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderRequestDto orderRequestDto);

    void updateEntity(OrderRequestDto orderRequestDto, @MappingTarget Order order);

    OrderResponseDto toResponseDto(Order order);

    List<OrderResponseDto> toResponseDto(List<Order> orders);
}
