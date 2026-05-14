package angel1ionita.bookstore.review;

import angel1ionita.bookstore.review.dto.ReviewRequestDto;
import angel1ionita.bookstore.review.dto.ReviewResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewRequestDto reviewRequestDto);

    void updateEntity(ReviewRequestDto reviewRequestDto, @MappingTarget Review review);

    ReviewResponseDto toResponseDto(Review review);

    List<ReviewResponseDto> toResponseDto(List<Review> review);
}
