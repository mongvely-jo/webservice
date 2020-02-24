package com.example.demod.controller;

import com.example.demod.model.Freeboard;
import com.example.demod.service.freeboard.FreeboardListService;
import com.example.demod.service.freeboard.FreeboardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class FreeboardController {

    @Autowired
    private FreeboardListService freeBoardListService;

    @Autowired
    private FreeboardWriteService freeboardWriteService;

    private int returnIntValue(String stringToInt){
        return Integer.parseInt(stringToInt);
    }

    @GetMapping("/freeboard")
    public String freeboard(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
        return freeBoardListService.freeBoardList(returnIntValue(pageNum));
    }

    @PostMapping("/freeboardWriteRequest")
    public String freeboardWriteRequest(@RequestParam Map<String, String> paramMap) {
        String title = paramMap.get("title");
        String content = paramMap.get("content");
        String writer = paramMap.get("writer");
        String phoneNumber = paramMap.get("phoneNumber");
        String account = paramMap.get("account");

        freeboardWriteService.write(title,content,account,writer,phoneNumber);

        return "redirect:/freeboard";   // /freeboard 매핑을 찾아서 호출을 하게됨 => @GetMapping("/freeboard")를 한번 더 호출 한다는 뜻
    }
}