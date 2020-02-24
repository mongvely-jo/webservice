package com.example.demod.service.freeboard;

import com.example.demod.pageMaker.PageMaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PageMakerService<Model> {

    public PageMaker generatePageMaker(int pageNum, int contentNum, JpaRepository<Model, Long> repository) {
        PageMaker pageMaker = new PageMaker();

        int totalCount = (int) repository.count();
        pageMaker.setTotalCount(totalCount); // 전체 게시글 수를 지정함
        pageMaker.setPageNum(pageNum - 1); // 현재 페이지를 페이지 객체에 지정함.  -1을 해야 쿼리에서 사용할 수 있음
        pageMaker.setContentNum(contentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 지정
        pageMaker.setCurrentBlock(pageNum); // 현재 페이지 블록이 몇 번인지 현재 페이지 번호를 통해서 지정
        pageMaker.setLastBlock(pageMaker.getTotalCount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        pageMaker.prevNext(pageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        pageMaker.setStartPage(pageMaker.getCurrentBlock()); // 시작 페이지를 페이지 블록 번호로 정함
        pageMaker.setEndPage(pageMaker.getLastBlock(), pageMaker.getCurrentBlock()); // 마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록 번호로 정함

        return pageMaker;
    }
}
