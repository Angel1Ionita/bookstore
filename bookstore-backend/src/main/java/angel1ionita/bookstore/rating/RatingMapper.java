package angel1ionita.bookstore.rating;

import angel1ionita.bookstore.rating.dto.RatingRequestDto;
import angel1ionita.bookstore.rating.dto.RatingResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    Rating toEntity(RatingRequestDto ratingRequestDto);

    void updateEntity(RatingRequestDto ratingRequestDto, @MappingTarget Rating rating);

    RatingResponseDto toResponseDto(Rating rating);

    List<RatingResponseDto> toResponseDto(List<Rating> ratings);
}
