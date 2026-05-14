package angel1ionita.bookstore.author;

import angel1ionita.bookstore.author.dto.AuthorRequestDto;
import angel1ionita.bookstore.author.dto.AuthorResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorRequestDto authorRequestDto);

    void updateEntity(AuthorRequestDto authorRequestDto, @MappingTarget Author author);

    AuthorResponseDto toResponseDto(Author author);

    List<AuthorResponseDto> toResponseDto(List<Author> authors);

}
