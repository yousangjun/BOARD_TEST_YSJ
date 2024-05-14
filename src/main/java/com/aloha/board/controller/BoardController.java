package com.aloha.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.board.dto.Board;
import com.aloha.board.service.BoardService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;





@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 목록
    @GetMapping("/list")
    public String list(Model model) throws Exception {

        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";

    }
    // 등록 
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception{

        int result = boardService.insert(board);
        if (result > 0) {
            return "redirect:/board/list";
        }
        
        return "";
    }
    
    // 등록 페이지로 이동
    @GetMapping("insert")
    public String insert() {

        return "/board/insert";
    }

    // 수정 페이지로 이동
    @GetMapping("/update")
    public String update(@RequestParam("no") int no, Model model)throws Exception{

        Board board = boardService.select(no);
        model.addAttribute("board", board);
        return "/board/update";
    }
    
    
    // 조회
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model)throws Exception {

        Board board = boardService.select(no);
        model.addAttribute("board", board);

        return "/board/read";

    }
    
    
    

    // 수정
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception{

        int result = boardService.update(board);
        if (result > 0) {
            return "redirect:/board/list";
        }
        
        return "";
    }
    // 삭제
    @PostMapping("/delete")
    public String delete(int no) throws Exception{

        int result = boardService.delete(no);
        
        if (result > 0) {
            return "redirect:/board/list";
        }
        
        return "";
    }
    
    
}
