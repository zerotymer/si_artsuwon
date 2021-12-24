package kr.or.artsuwon.adminBoard.service;


import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.adminBoard.model.vo.Notice;


public interface BoardAdminService {


	// 글목록보기
	HashMap<String, Object> selectAllPostList(int currentPage);
	
	//게시글보기
	Notice selectOneContent(int noticeNo);

	//게시글 수정
	int updatePost(Notice notice);
	
	//게시글작성
	int insertPost(Notice notice);
	 
	int searchNoticeNo(Notice notice);
	//게시글찾기 
	int deletePost(int noticeNo);

	HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type);
	
}
