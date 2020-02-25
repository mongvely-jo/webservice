package com.example.demod.service.freeboard;

import com.example.demod.model.Freeboard;
import com.example.demod.pageMaker.PageMaker;
import com.example.demod.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreeboardListService {

    @Autowired
    private FreeboardRepository freeboardRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private PageMakerService<Freeboard> pageMakerService;

    public String freeBoardList(int pageNum) {

        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 10, freeboardRepository);

        // 페이지당 10개씩 id순으로 내림차순해서 보여줌 => 최신글이 위로
        PageRequest pageRequest = PageRequest.of(pageNum-1,10, Sort.Direction.DESC,"freeId");
        Page<Freeboard> freeboardPage = freeboardRepository.findAll(pageRequest);

        if(freeboardPage.getSize() == 0) {
            session.setAttribute("boardList", new ArrayList<Freeboard>());
            session.setAttribute("pageMaker", pageMaker);
            return "freeboard";
        }

        List<Freeboard> freeboardList = freeboardPage.getContent();
        session.setAttribute("boardList", freeboardList);         // 게시판이 비어있지 않을 경우 세션에 게시글 목록 저장한 뒤 이동
        session.setAttribute("pageMaker", pageMaker);

        return "freeboard";
    }
}
