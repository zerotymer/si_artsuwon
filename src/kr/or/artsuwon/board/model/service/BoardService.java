package kr.or.artsuwon.board.model.service;

import java.util.HashMap;

import javax.servlet.jsp.tagext.PageData;

import kr.or.artsuwon.board.model.vo.Board;

public interface BoardService {

	HashMap<String,Object> NoticeSelect(int currentPage);

	Board NoticeSelectOnePost(int boardNo);

	HashMap<String, Object> NoticeSearchPost(int currentPage, String keyword, String type);

	HashMap<String, Object> NewsSelect(int currentPage);;

}
