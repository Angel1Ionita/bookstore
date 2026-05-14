package angel1ionita.bookstore.publisher;

import angel1ionita.bookstore.publisher.dto.PublisherRequestDto;
import angel1ionita.bookstore.publisher.dto.PublisherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping("/{id}")
    public PublisherResponseDto getById(@PathVariable Long id) {
        return publisherService.getById(id);
    }

    @GetMapping
    public List<PublisherResponseDto> getAll() {
        return publisherService.getAll();
    }

    @PostMapping
    public PublisherResponseDto create(@RequestBody PublisherRequestDto publisherRequestDto) {
        return publisherService.create(publisherRequestDto);
    }

    @PutMapping("/{id}")
    public PublisherResponseDto update(@RequestBody PublisherRequestDto publisherRequestDto, @PathVariable Long id) {
        return publisherService.update(publisherRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherService.delete(id);
    }
}
