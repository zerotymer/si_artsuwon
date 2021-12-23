package kr.or.artsuwon.board.model.service;

import java.util.HashMap;

public interface BoardService {

	HashMap<String,Object> selectAllPostList(int currentPage);
}
