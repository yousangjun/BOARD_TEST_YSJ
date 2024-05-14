package com.aloha.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board {

    private int no;
    private String content;
    private String writer;
    private String title;
    private Date regDate;
    private Date updDate;
    
    
}
