package angel1ionita.bookstore.review;

import angel1ionita.bookstore.review.dto.ReviewRequestDto;
import angel1ionita.bookstore.review.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ReviewResponseDto getById(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    @GetMapping
    public List<ReviewResponseDto> getAll() {
        return reviewService.getAll();
    }

    @PostMapping
    public ReviewResponseDto create(@RequestBody ReviewRequestDto reviewRequestDto) {
        return reviewService.create(reviewRequestDto);
    }

    @PutMapping("/{id}")
    public ReviewResponseDto update(@RequestBody ReviewRequestDto reviewRequestDto, @PathVariable Long id) {
        return reviewService.update(reviewRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
