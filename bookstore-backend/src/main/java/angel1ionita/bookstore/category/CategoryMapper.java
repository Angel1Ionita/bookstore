package angel1ionita.bookstore.category;

import angel1ionita.bookstore.category.dto.CategoryRequestDto;
import angel1ionita.bookstore.category.dto.CategoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequestDto categoryRequestDto);

    void updateEntity(CategoryRequestDto categoryRequestDto, @MappingTarget Category category);

    CategoryResponseDto toResponseDto(Category category);

    List<CategoryResponseDto> toResponseDto(List<Category> categories);

}
