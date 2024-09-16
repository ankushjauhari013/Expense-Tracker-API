package com.in.ankush.mappers;

import com.in.ankush.dto.CategoryDto;
import com.in.ankush.dto.UserDto;
import com.in.ankush.entity.CategoryEntity;
import com.in.ankush.entity.User;
import com.in.ankush.io.CategoryRequest;
import com.in.ankush.io.CategoryResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
//
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T23:58:32+0530",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 21.0.3 (Eclipse Adoptium)"
)
//@Component
//public class CategoryMapperImpl implements CategoryMapper {
//
//    @Override
//    public CategoryEntity mapToCategoryEntity(CategoryDto categoryDto) {
//        if ( categoryDto == null ) {
//            return null;
//        }
//
//        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();
//
//        categoryEntity.categoryId( categoryDto.getCategoryId() );
//        categoryEntity.name( categoryDto.getName() );
//        categoryEntity.description( categoryDto.getDescription() );
//        categoryEntity.categoryIcon( categoryDto.getCategoryIcon() );
//        categoryEntity.user( userDtoToUser( categoryDto.getUser() ) );
//
//        return categoryEntity.build();
//    }
//
//    @Override
//    public CategoryDto mapToCategoryDto(CategoryEntity entity) {
//        if ( entity == null ) {
//            return null;
//        }
//
//        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();
//
//        categoryDto.categoryId( entity.getCategoryId() );
//        categoryDto.name( entity.getName() );
//        categoryDto.description( entity.getDescription() );
//        categoryDto.categoryIcon( entity.getCategoryIcon() );
//        categoryDto.createdAt( entity.getCreatedAt() );
//        categoryDto.updatedAt( entity.getUpdatedAt() );
//        categoryDto.user( userToUserDto( entity.getUser() ) );
//
//        return categoryDto.build();
//    }
//
//    @Override
//    public CategoryDto mapToCategoryDto(CategoryRequest request) {
//        if ( request == null ) {
//            return null;
//        }
//
//        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();
//
//        categoryDto.categoryIcon( request.getIcon() );
//        categoryDto.name( request.getName() );
//        categoryDto.description( request.getDescription() );
//
//        return categoryDto.build();
//    }
//
//    @Override
//    public CategoryResponse mapToCategoryResponse(CategoryDto categoryDto) {
//        if ( categoryDto == null ) {
//            return null;
//        }
//
//        CategoryResponse categoryResponse = new CategoryResponse();
//
//        categoryResponse.setCategoryId( categoryDto.getCategoryId() );
//        categoryResponse.setName( categoryDto.getName() );
//        categoryResponse.setDescription( categoryDto.getDescription() );
//        categoryResponse.setCreatedAt( categoryDto.getCreatedAt() );
//        categoryResponse.setUpdatedAt( categoryDto.getUpdatedAt() );
//
//        return categoryResponse;
//    }
//
//    protected User userDtoToUser(UserDto userDto) {
//        if ( userDto == null ) {
//            return null;
//        }
//
//        User user = new User();
//
//        user.setName( userDto.getName() );
//        user.setEmail( userDto.getEmail() );
//
//        return user;
//    }
//
//    protected UserDto userToUserDto(User user) {
//        if ( user == null ) {
//            return null;
//        }
//
//        UserDto.UserDtoBuilder userDto = UserDto.builder();
//
//        userDto.email( user.getEmail() );
//        userDto.name( user.getName() );
//
//        return userDto.build();
//    }
//}






@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity mapToCategoryEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity.CategoryEntityBuilder categoryEntity = CategoryEntity.builder();

        categoryEntity.categoryId( categoryDto.getCategoryId() );
        categoryEntity.name( categoryDto.getName() );
        categoryEntity.description( categoryDto.getDescription() );
        categoryEntity.categoryIcon( categoryDto.getCategoryIcon() );
        categoryEntity.user( userDtoToUser( categoryDto.getUser() ) );

        return categoryEntity.build();
    }

    @Override
    public CategoryDto mapToCategoryDto(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();

        categoryDto.categoryId( entity.getCategoryId() );
        categoryDto.name( entity.getName() );
        categoryDto.description( entity.getDescription() );
        categoryDto.categoryIcon( entity.getCategoryIcon() );
        categoryDto.createdAt( entity.getCreatedAt() );
        categoryDto.updatedAt( entity.getUpdatedAt() );
        categoryDto.user( userToUserDto( entity.getUser() ) );

        return categoryDto.build();
    }

    @Override
    public CategoryDto mapToCategoryDto(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        CategoryDto.CategoryDtoBuilder categoryDto = CategoryDto.builder();

        System.out.println("Mapping icon: " + request.getIcon());
        categoryDto.categoryIcon( request.getIcon() );
        categoryDto.name( request.getName() );
        categoryDto.description( request.getDescription() );

        CategoryDto dto = categoryDto.build();
        System.out.println("Mapped CategoryDto: " + dto);

        return dto;
    }

    @Override
    public CategoryResponse mapToCategoryResponse(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setCategoryId( categoryDto.getCategoryId() );
        categoryResponse.setName( categoryDto.getName() );
        categoryResponse.setDescription( categoryDto.getDescription() );
        categoryResponse.setCreatedAt( categoryDto.getCreatedAt() );
        categoryResponse.setUpdatedAt( categoryDto.getUpdatedAt() );

        return categoryResponse;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDto.getName() );
        user.setEmail( userDto.getEmail() );

        return user;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.email( user.getEmail() );
        userDto.name( user.getName() );

        return userDto.build();
    }
}
