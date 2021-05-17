package com.ksy.blog.domain.board.dto;

import lombok.Data;

@Data
public class CommonRespDto<T> {
private int statusCode; // 1:정상 -1 실패
private T data; //보내고 싶은 데이터 담아서 보내기
}
