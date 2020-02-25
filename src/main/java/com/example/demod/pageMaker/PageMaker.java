package com.example.demod.pageMaker;

import lombok.Data;

@Data
public class PageMaker {

    private int totalCount; // 전체 게시물 개수

    private int pageNum; // 현재 페이지 번호

    private int contentNum = 10; // 한 페이지에 몇 개 표시할지

    private int startPage = 1; // 현재 페이지 블록의 시작페이지

    private int endPage = 5; // 현재 페이지 블록의 마지막 페이지

    private boolean prev = false; // 이전 페이지로 가는 화살표

    private boolean next; // 다음 페이지로 가는 화살표

    private int currentBlock; // 현재 페이지 블록

    private int lastBlock; // 마지막 페이지 블록

    public void prevNext(int pageNum) {
        if(pageNum > 0 && pageNum < 6) {
            setPrev(false);
            setNext(true);
        }
        else if(getLastBlock() == getCurrentBlock()) {
            setPrev(true);
            setNext(false);
        }
        else{
            setPrev(true);
            setNext(true);
        }
    }

    // 페이지 수 계산 : 총 페이지와 한 페이지 개수를 사용
    public int calcPage(int totalCount, int contentNum) {
        int totalPage = totalCount / contentNum;
        if(totalCount % contentNum > 0){
            totalPage++;
        }
        return totalPage;
    }

    public void getStartPage(int currentBlock) {
        this.startPage = (currentBlock * 5) - 4;
        // 1 2 3 4 5
        // 6 7 8 9 10
        // 11 12 13
    }

    public void setEndPage(int getLastBlock, int getCurrentBlock) {
        if(getLastBlock == getCurrentBlock) { // 현재 페이지 블록이 마지막 블록이면
            this.endPage = calcPage(getTotalCount(),getContentNum()); // 페이지 개수를 끝페이지로 지정
        }
        else {
            this.endPage = getStartPage() + 4;  // 시작 페이지 + 4를 끝페이지로 지정
        }
    }

    public boolean isPrev() {
        return prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setCurrentBlock(int pageNum) { // 페이지 번호 5 들어옴
        // 페이지 번호를 통해서 구한다.
        // 페이지 번호 / 페이지 그룹 안의 개수
        // 1p => 1 / 5 => 0.2
        // 5p => 5 / 5 => 1
        this.currentBlock = pageNum / 5;
        if(pageNum % 5 > 0) {
            this.currentBlock++;
        }
    }

    public void setLastBlock(int totalCount) {
        this.lastBlock = totalCount / (5 * this.contentNum);
        if(totalCount % (5 * this.contentNum) > 0){
            this.lastBlock++;
        }
    }
}

