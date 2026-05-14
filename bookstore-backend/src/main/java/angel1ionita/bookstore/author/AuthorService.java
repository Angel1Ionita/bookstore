package angel1ionita.bookstore.author;

import angel1ionita.bookstore.author.dto.AuthorRequestDto;
import angel1ionita.bookstore.author.dto.AuthorResponseDto;
import angel1ionita.bookstore.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;

    private Author getOrThrow(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author", id));
    }

    public AuthorResponseDto getById(Long id) {
        Author author = getOrThrow(id);
        return mapper.toResponseDto(author);
    }

    public List<AuthorResponseDto> getAll() {
        return mapper.toResponseDto(authorRepository.findAll());
    }

    @Transactional
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        Author author = mapper.toEntity(authorRequestDto);
        return mapper.toResponseDto(authorRepository.save(author));
    }

    @Transactional
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto, Long id) {
        Author author = getOrThrow(id);
        mapper.updateEntity(authorRequestDto, author);
        return mapper.toResponseDto(authorRepository.save(author));
    }

    @Transactional
    public void delete(Long id) {
        Author author = getOrThrow(id);
        authorRepository.delete(author);
    }

}
