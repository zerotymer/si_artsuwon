package kr.or.artsuwon.adminMember.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.artsuwon.adminMember.dao.AdminMemberDAO;
import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.csBoard.vo.csBoard;
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
	public HashMap<String,Object> selectSearchPost(int currentPage, String keyword, String type) {

		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서  몇개의 목록으로 보여줄 것인지에 대한 값이 필요
		int recordCountPerPage = 10;
		
		ArrayList<csBoard> list = adDAO.selectSearchPostList(conn,currentPage,recordCountPerPage,keyword,type);
		
		
		/*//확인코드
		System.out.println("검색 키워드 : "+ keyword);
		System.out.println("검색 타입 : " + type);
		
		for(csBoard csboard : list)
		{
			System.out.println("제목 : " + csboard.getCsTitle() + "/"+" 작성자 : "+ csboard.getCsWriter());
		}
		*/
		//하나의 pageNavi Bar에 보여질 navi 개수를 설정
		int naviCountPerPage = 5;
						
		String pageNavi = adDAO.getSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
			
		//DB연결 해제
		JDBCTemplate.close(conn);
				
		//리턴을 하기 위하여 HashMap 객체 만들어서 리턴
		HashMap<String,Object> map = new HashMap<String,Object>();
				
		map.put("list", list);
		map.put("pageNavi", pageNavi);
				
		return map;
		
	}
	@Override
	public int updateMemberEndYN(int memberNo, char memberStatus) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = adDAO.updateMemberEndYN(memberNo,memberStatus,conn);
		
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return result;
	}

}
