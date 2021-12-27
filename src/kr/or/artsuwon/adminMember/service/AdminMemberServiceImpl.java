package kr.or.artsuwon.adminMember.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.artsuwon.adminMember.dao.AdminMemberDAO;
import kr.or.artsuwon.board.model.dao.csBoard;
import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.member.model.vo.Member;

public class AdminMemberServiceImpl implements AdminMemberService {
	
	private AdminMemberDAO  adDAO = new AdminMemberDAO();
	@Override
	public ArrayList<Member> selectAllMemberList(int adminNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = adDAO.selectAllMemberList(adminNo,conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	@Override
	public void selectSearchPost(int currentPage, String keyword, String type) {

		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서  몇개의 목록으로 보여줄 것인지에 대한 값이 필요
		int recordCountPerPage = 5;
		
		ArrayList<csBoard> list = adDAO.selectSearchPostList(conn,currentPage,recordCountPerPage,keyword,type);
		
		
		/*확인코드
		 * System.out.println("검색 키워드 : "+ keyword);
		System.out.println("검색 타입 : " + type);
		
		for(Board board : list)
		{
			System.out.println("제목 : " + csboard.getSubject() + "/"+" 작성자 : "+ csboard.getUserName());
		}*/
		
		//하나의 pageNavi Bar에 보여질 navi 개수를 설정
		int naviCountPerPage = 5;
						
		String pageNavi = adDAO.getSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
				
		
	}

}
