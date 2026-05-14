package angel1ionita.bookstore.category;

import angel1ionita.bookstore.category.dto.CategoryRequestDto;
import angel1ionita.bookstore.category.dto.CategoryResponseDto;
import angel1ionita.bookstore.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    private Category getOrThrow(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author", id));
    }

    public CategoryResponseDto getById(Long id) {
        Category category = getOrThrow(id);
        return mapper.toResponseDto(category);
    }

    public List<CategoryResponseDto> getAll() {
        return mapper.toResponseDto(categoryRepository.findAll());
    }

    @Transactional
    public CategoryResponseDto create(CategoryRequestDto categoryRequestDto) {
        Category category = mapper.toEntity(categoryRequestDto);
        return mapper.toResponseDto(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponseDto update(CategoryRequestDto categoryRequestDto, Long id) {
        Category category = getOrThrow(id);
        mapper.toEntity(categoryRequestDto);
        return mapper.toResponseDto(categoryRepository.save(category));
    }

    @Transactional
    public void delete(Long id) {
        Category category = getOrThrow(id);
        categoryRepository.delete(category);
    }
}
