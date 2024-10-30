package org.example.springBootMainFolder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

// @Data
// : Lombok 라이브러리 애너테이션 (getter, setter, toString 등을 생성)
@Data
// @AllArgsConstructor
// : 모든 필드 값을 매개변수로 받는 생성자를 자동 생성
// - staticName="set"
//      :  set()이라는 이름의 정적 메서드를 제공
@AllArgsConstructor(staticName="set")
public class ResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data) {
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message) {
        return ResponseDto.set(false, message, null);
    }
}