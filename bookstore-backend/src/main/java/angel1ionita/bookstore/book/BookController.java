package angel1ionita.bookstore.book;

import angel1ionita.bookstore.book.dto.BookRequestDto;
import angel1ionita.bookstore.book.dto.BookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll();
    }

    @PostMapping
    public BookResponseDto create(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.create(bookRequestDto);
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@RequestBody BookRequestDto bookRequestDto, @PathVariable Long id) {
        return bookService.update(bookRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
