package angel1ionita.bookstore.book;

import angel1ionita.bookstore.book.dto.BookRequestDto;
import angel1ionita.bookstore.book.dto.BookResponseDto;
import angel1ionita.bookstore.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper mapper;

    private Book getOrThrow(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book", id));
    }

    public BookResponseDto getById(Long id) {
        Book book = getOrThrow(id);
        return mapper.toResponseDto(book);
    }

    public List<BookResponseDto> getAll() {
        return mapper.toResponseDto(bookRepository.findAll());
    }

    @Transactional
    public BookResponseDto create(BookRequestDto bookRequestDto) {
        Book book = mapper.toEntity(bookRequestDto);
        return mapper.toResponseDto(bookRepository.save(book));
    }

    @Transactional
    public BookResponseDto update(BookRequestDto bookRequestDto, Long id) {
        Book book = getOrThrow(id);
        mapper.updateEntity(bookRequestDto, book);
        return mapper.toResponseDto(bookRepository.save(book));
    }

    @Transactional
    public void delete(Long id) {
        Book book = getOrThrow(id);
        bookRepository.delete(book);
    }
}
