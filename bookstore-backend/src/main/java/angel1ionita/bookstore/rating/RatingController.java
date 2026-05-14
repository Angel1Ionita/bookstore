package angel1ionita.bookstore.rating;

import angel1ionita.bookstore.rating.dto.RatingRequestDto;
import angel1ionita.bookstore.rating.dto.RatingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @GetMapping("/{id}")
    public RatingResponseDto getById(@PathVariable Long id) {
        return ratingService.getById(id);
    }

    @GetMapping
    public List<RatingResponseDto> getAll() {
        return ratingService.getAll();
    }

    @PostMapping
    public RatingResponseDto create(@RequestBody RatingRequestDto ratingRequestDto) {
        return ratingService.create(ratingRequestDto);
    }

    @PutMapping("/{id}")
    public RatingResponseDto update(@RequestBody RatingRequestDto ratingRequestDto, @PathVariable Long id) {
        return ratingService.update(ratingRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ratingService.delete(id);
    }
}
