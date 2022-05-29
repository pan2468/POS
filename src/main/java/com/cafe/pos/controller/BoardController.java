package com.cafe.pos.controller;

import com.cafe.pos.dto.BoardFormDto;
import com.cafe.pos.entity.Board;
import com.cafe.pos.repository.BoardRepository;
import com.cafe.pos.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;



    @GetMapping("/list")
    public String list(Model model){

        List<Board> boards = boardService.boardList();

        model.addAttribute("boards",boards);

        return "board/list";
    }

    @GetMapping("/write")
    public String write(Model model, @RequestParam(required = false)  Long id){

        if(id == null){
            model.addAttribute("board",new Board());
        }else if(id != null){
            log.info(id);
            Board board = boardRepository.findById(id).orElse(null);
            boardService.updateView(id);
            model.addAttribute("board",board);
        }

        return "board/write";
    }

    @PostMapping("/write")
    public String writing(@Valid Board board){

        board.setRegTime(LocalDate.now());

        boardService.save(board);

        return "redirect:/board/list";
    }

}
