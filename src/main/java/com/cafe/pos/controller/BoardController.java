package com.cafe.pos.controller;

import com.cafe.pos.dto.BoardSearchDto;
import com.cafe.pos.entity.Board;
import com.cafe.pos.repository.BoardRepository;
import com.cafe.pos.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired private BoardRepository boardRepository;
    @Autowired private BoardService boardService;


    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 4) Pageable pageable,
                       BoardSearchDto boardSearchDto){

        //Page<Board> boards = boardService.boardList(pageable);
        Page<Board> boards = boardService.getSearchList(pageable,boardSearchDto);
        int startPage = Math.max(1,boards.getPageable().getPageNumber() - 4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("boards",boards);

        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam Long id){

        log.info(id);
        Board board = boardRepository.findById(id).orElse(null);
        boardService.updateView(id);
        model.addAttribute("board",board);

        return "board/detail";
    }


    @GetMapping("/write")
    public String write(Model model){

        model.addAttribute("board",new Board());

        return "board/write";
    }

    @PostMapping("/write")
    public String writing(@Valid Board board){

        board.setRegTime(LocalDate.now());

        log.info("------등록전-------");
        boardService.save(board);
        log.info("------등록 완료-------");

        return "redirect:/board/list";
    }



    @GetMapping("/delete")
    public String delete(@RequestParam(required = false) Long id){

        log.info("번호:",id);

        boardService.remove(id);

        return "redirect:/board/list";
    }

    @PostMapping("/update")
    public String modify(@Valid Board board){

        board.setRegTime(LocalDate.now());

        boardService.save(board);

        return "redirect:/board/list";
    }

}
