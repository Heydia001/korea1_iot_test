package org.example.springBootMainFolder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springBootMainFolder.entity.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PostBookRequestDto {
    private String title;
    private String author;
    private Category category;
}
