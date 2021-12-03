package com.icia.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.repository.BoardRepository;



@Service
public class BoardServiceImpl  implements BoardService{

	
	@Autowired
	private BoardRepository br;
	
	@Override
	public void save(BoardDTO board) {
		br.save(board);
		
	}
	@Override
	public List<BoardDTO> findAll() {
		
		return br.findAll();
	}
	@Override
	public BoardDTO findById(long b_number) {
		// 1. 조회수 증가 2. 상세조회
		br.hits(b_number);
		return br.findById(b_number);
	}
	@Override
	public void delete(long b_number) {
		br.delete(b_number);
		
	}
	@Override
	public void update(BoardDTO board) {
		br.update(board);
		
	}
	// 페이징
	// 밑에 선언한건 상수(안변하는값), 보통 상수는 대문자
	private static final int PAGE_LIMIT = 3; // 한페이지에 보여질 글 개수 , 5개면 글 다섯개
	private static final int BLOCK_LIMIT = 3; // 한화면에 보여질 페이지 개수 ,밑에 보여지는 글 숫자 

	
	// 필요한 총 페이지 갯수 계산,
	// 현재 사용자가 요청한 페이지가 2페이지라면 화면에는 1,2,3,을 보여주고
	// 요청 페이지가 6페이지라면 화면에 4,5,6을 보여준다.
	// 요청 페이지가 7페이지라면 화면에 7을 보여준다.
	@Override
	public PageDTO paging(int page) {
		int boardCount = br.boardCount(); // 전체 글 갯수 조회,
		int maxPage = (int)(Math.ceil((double)boardCount / PAGE_LIMIT)); // 전페 페이지 계산 [ceil(ceil((double)boardCount / PAGE_LIMIT))은 반올림 해주는 메서드]
		// 2페이지를 요청했으면 1페이지, 4페이지를 요청했으면 4페이지, 8페이지를 요청했으면 7페이지의 값을 갖도록 계산
		int startPage = (((int)(Math.ceil((double)page / BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1; // 3, 6, 9 페이지
		if(endPage > maxPage)
			endPage = maxPage; 
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		System.out.println("paging.toString(): "+ paging.toString());
		
		return paging;
	}
	
	@Override
	public List<BoardDTO> pagingList(int page) {
		// TODO Auto-generated method stub
		// 1페이지 limit 0,3 2페이지 limit 3,3
		int pagingStart = (page-1) * PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
//		List<BoardDTO> pagingList = br.pagingList(pagingStart);
		List<BoardDTO> pagingList = br.pagingList1(pagingParam);
		for(BoardDTO b: pagingList) {
			System.out.println(b.toString());
		}
		return pagingList;
	}
	@Override
	public List<BoardDTO> search(String searchtype, String keyword) {
		Map<String,String> searchParam = new HashMap<String, String>();
		searchParam.put("type", searchtype);
		searchParam.put("word", keyword);
		List<BoardDTO> boardList = br.search(searchParam);
		return boardList;
	}
	

}
