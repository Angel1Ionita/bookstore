package angel1ionita.bookstore.book;

import angel1ionita.bookstore.book.dto.BookRequestDto;
import angel1ionita.bookstore.book.dto.BookResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toEntity(BookRequestDto bookRequestDto);

    void updateEntity(BookRequestDto bookRequestDto, @MappingTarget Book book);

    BookResponseDto toResponseDto(Book book);

    List<BookResponseDto> toResponseDto(List<Book> books);
}
