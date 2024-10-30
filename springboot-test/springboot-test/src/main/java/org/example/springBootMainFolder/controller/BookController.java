package org.example.springBootMainFolder.controller;

import lombok.RequiredArgsConstructor;
import org.example.springBootMainFolder.common.constant.ApiMappingPattern;
import org.example.springBootMainFolder.dto.response.GetBookListResponseDto;
import org.example.springBootMainFolder.dto.response.GetBookResponseDto;
import org.example.springBootMainFolder.dto.response.PostBookResponseDto;
import org.example.springBootMainFolder.dto.response.ResponseDto;
import org.example.springBootMainFolder.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.BOOK)
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    public static final String Book_POST = "/";

    public static final String Book_GET_MENU_ID = "/{id}";
    public static final String Book_GET_LIST = "/list";


    @PostMapping(Book_POST)
    public ResponseEntity<ResponseDto<PostBookResponseDto>> createBook(@RequestBody PostBookResponseDto requestDto) {
        ResponseDto<PostBookResponseDto> result = bookService.createBook(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping(Book_GET_LIST)
    public ResponseEntity<ResponseDto<List<GetBookListResponseDto>>> getAllBooks() {
        ResponseDto<List<GetBookListResponseDto>> result = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping(Book_GET_MENU_ID)
    public ResponseEntity<ResponseDto<GetBookResponseDto>> getMenuById(@PathVariable Long id) {
        ResponseDto<GetBookResponseDto> result = bookService.getBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
