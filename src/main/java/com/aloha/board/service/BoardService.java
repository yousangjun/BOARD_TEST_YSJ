package com.aloha.board.service;

import java.util.List;

import com.aloha.board.dto.Board;

public interface BoardService {

        // 목록
        public List<Board> list() throws Exception;

        // 삭제
        public int delete(int no) throws Exception;
        // 수정
        public int update(Board board) throws Exception;
        // 조회
        public Board select(int no) throws Exception;
        // 등록
        public int insert(Board board) throws Exception;
    
}
