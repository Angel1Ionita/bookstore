package angel1ionita.bookstore.publisher;

import angel1ionita.bookstore.publisher.dto.PublisherRequestDto;
import angel1ionita.bookstore.publisher.dto.PublisherResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher toEntity(PublisherRequestDto publisherRequestDto);

    void updateEntity(PublisherRequestDto publisherRequestDto, @MappingTarget Publisher publisher);

    PublisherResponseDto toResponseDto(Publisher publisher);

    List<PublisherResponseDto> toResponseDto(List<Publisher> publishers);
}
