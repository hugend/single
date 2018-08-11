package free.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import free.dto.FreeCmtDTO;
import free.dto.FreeDTO;

public interface FreeDAO {
	int insert(FreeDTO post,Connection con) throws SQLException; // 게시글 등록
	
	int update(FreeDTO post,Connection con) throws SQLException; // 게시글 수정
	
	int delete(int fr_no,Connection con) throws SQLException; // 게시글 삭제
	
	FreeDTO read(int fr_no,Connection con) throws SQLException; // 게시글 읽기

	ArrayList<FreeDTO> getPostList(Connection con) throws SQLException;	// 게시글 전체 목록
	
	ArrayList<FreeDTO> getCtgList(String fr_ctg, Connection con) throws SQLException;		// 게시글 카테고리별 목록

	int report(String me_id, Connection con) throws SQLException; // 유저 신고
	
	ArrayList<FreeDTO> search(String column, String search, Connection con) throws SQLException;	// 게시글 검색

}
