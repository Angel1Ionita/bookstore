package angel1ionita.bookstore.review;

import angel1ionita.bookstore.exception.ResourceNotFoundException;
import angel1ionita.bookstore.review.dto.ReviewRequestDto;
import angel1ionita.bookstore.review.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper mapper;

    private Review getOrThrow(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author", id));
    }

    public ReviewResponseDto getById(Long id) {
        Review review = getOrThrow(id);
        return mapper.toResponseDto(review);
    }

    public List<ReviewResponseDto> getAll() {
        return mapper.toResponseDto(reviewRepository.findAll());
    }

    @Transactional
    public ReviewResponseDto create(ReviewRequestDto reviewRequestDto) {
        Review review = mapper.toEntity(reviewRequestDto);
        return mapper.toResponseDto(reviewRepository.save(review));
    }

    @Transactional
    public ReviewResponseDto update(ReviewRequestDto reviewRequestDto, Long id) {
        Review review = getOrThrow(id);
        mapper.updateEntity(reviewRequestDto, review);
        return mapper.toResponseDto(reviewRepository.save(review));
    }

    @Transactional
    public void delete(Long id) {
        Review review = getOrThrow(id);
        reviewRepository.delete(review);
    }
}
