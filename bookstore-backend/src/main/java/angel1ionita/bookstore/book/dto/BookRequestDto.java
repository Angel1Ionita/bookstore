package angel1ionita.bookstore.book.dto;

public record BookRequestDto(
        String isbn,
        String title,
        Long publisherId,
        Integer publicationYear,
        String language,
        Integer pages,
        Float price,
        String description,
        Float averageRating,
        Integer stock,
        String image
) {
}
