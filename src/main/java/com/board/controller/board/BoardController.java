package com.board.controller.board;

import com.board.domain.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/post")
    public boolean createPost(@RequestBody BoardDTO board) {
        boolean result = boardService.registerBoard(board);

        return result;
    }

    @GetMapping("/{idx}")
    public BoardDTO getPost(@PathVariable("idx") Long idx) {
        return boardService.getBoardDetail(idx);
    }
}