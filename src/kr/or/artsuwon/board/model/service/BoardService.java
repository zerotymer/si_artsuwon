package kr.or.artsuwon.board.model.service;

import java.util.HashMap;

import javax.servlet.jsp.tagext.PageData;

import kr.or.artsuwon.board.model.vo.Board;

public interface BoardService {

	HashMap<String,Object> NoticeSelect(int currentPage);

	Board NoticeSelectOnePost(int boardNo);

	HashMap<String, Object> NoticeSearchPost(int currentPage, String keyword, String type);

	HashMap<String, Object> NewsSelect(int currentPage);

	Board NewsSelectOnePost(int boardNo);

	HashMap<String, Object> NewsSearchPost(int currentPage, String keyword, String type);

	int noticePostWrite(Board board);

	int noticeSearchBoardNo(Board board);

	HashMap<String, Object> PhotoSelect(int currentPage);

	Board PhotoSelectOnePost(int boardNo);

	HashMap<String, Object> PhotoSearchPost(int currentPage, String keyword, String type);

	HashMap<String, Object> VideoSelect(int currentPage);

	Board VideoSelectOnePost(int boardNo);

	HashMap<String, Object> VideoSearchPost(int currentPage, String keyword, String type);



}
