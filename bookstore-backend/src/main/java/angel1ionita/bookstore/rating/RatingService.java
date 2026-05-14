package angel1ionita.bookstore.rating;

import angel1ionita.bookstore.exception.ResourceNotFoundException;
import angel1ionita.bookstore.rating.dto.RatingRequestDto;
import angel1ionita.bookstore.rating.dto.RatingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper mapper;

    private Rating getOrThrow(Long id) {
        return ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("rating", id));
    }

    public RatingResponseDto getById(Long id) {
        Rating rating = getOrThrow(id);
        return mapper.toResponseDto(rating);
    }

    public List<RatingResponseDto> getAll() {
        return mapper.toResponseDto(ratingRepository.findAll());
    }

    @Transactional
    public RatingResponseDto create(RatingRequestDto ratingRequestDto) {
        Rating rating = mapper.toEntity(ratingRequestDto);
        return mapper.toResponseDto(ratingRepository.save(rating));
    }

    @Transactional
    public RatingResponseDto update(RatingRequestDto ratingRequestDto, Long id) {
        Rating rating = getOrThrow(id);
        mapper.updateEntity(ratingRequestDto, rating);
        return mapper.toResponseDto(ratingRepository.save(rating));
    }

    @Transactional
    public void delete(Long id) {
        Rating rating = getOrThrow(id);
        ratingRepository.delete(rating);
    }
}
