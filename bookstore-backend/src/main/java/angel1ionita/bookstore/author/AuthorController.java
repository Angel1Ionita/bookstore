package angel1ionita.bookstore.author;

import angel1ionita.bookstore.author.dto.AuthorRequestDto;
import angel1ionita.bookstore.author.dto.AuthorResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorResponseDto getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.getAll();
    }


    @PostMapping
    public AuthorResponseDto create(@RequestBody AuthorRequestDto authorRequestDto) {
        return authorService.create(authorRequestDto);
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@RequestBody AuthorRequestDto authorRequestDto, @PathVariable Long id) {
        return authorService.update(authorRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
