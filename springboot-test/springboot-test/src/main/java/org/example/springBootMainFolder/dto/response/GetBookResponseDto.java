package org.example.springBootMainFolder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springBootMainFolder.entity.Book;
import org.example.springBootMainFolder.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GetBookResponseDto {
    // 단건 조회
    private Long id;
    private String title;
    private String author;
    private Category category;

    public GetBookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();

    }
}
