package angel1ionita.bookstore.book.dto;

import angel1ionita.bookstore.author.dto.AuthorResponseDto;
import angel1ionita.bookstore.category.dto.CategoryResponseDto;
import angel1ionita.bookstore.publisher.dto.PublisherResponseDto;
import angel1ionita.bookstore.review.dto.ReviewResponseDto;

import java.util.List;

public record BookResponseDto(
        Long bookId,
        String isbn,
        PublisherResponseDto publisher,
        Integer publicationYear,
        String language,
        Integer pages,
        Float price,
        String description,
        Float averageRating,
        String image,
        List<AuthorResponseDto> authors,
        List<CategoryResponseDto> categories,
        List<ReviewResponseDto> reviews
) {
}
