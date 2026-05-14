package angel1ionita.bookstore.publisher;

import angel1ionita.bookstore.exception.ResourceNotFoundException;
import angel1ionita.bookstore.publisher.dto.PublisherRequestDto;
import angel1ionita.bookstore.publisher.dto.PublisherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper mapper;

    private Publisher getOrThrow(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author", id));
    }

    public PublisherResponseDto getById(Long id) {
        Publisher publisher = getOrThrow(id);
        return mapper.toResponseDto(publisher);
    }

    public List<PublisherResponseDto> getAll() {
        return mapper.toResponseDto(publisherRepository.findAll());
    }

    @Transactional
    public PublisherResponseDto create(PublisherRequestDto publisherRequestDto) {
        Publisher publisher = mapper.toEntity(publisherRequestDto);
        return mapper.toResponseDto(publisherRepository.save(publisher));
    }

    @Transactional
    public PublisherResponseDto update(PublisherRequestDto publisherRequestDto, Long id) {
        Publisher publisher = getOrThrow(id);
        mapper.updateEntity(publisherRequestDto, publisher);
        return mapper.toResponseDto(publisherRepository.save(publisher));
    }

    @Transactional
    public void delete(Long id) {
        Publisher publisher = getOrThrow(id);
        publisherRepository.delete(publisher);
    }
}
