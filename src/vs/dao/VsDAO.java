package vs.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import vs.dto.VsCmtDTO;
import vs.dto.VsDTO;

public interface VsDAO {
	
	int insert(VsDTO post, Connection con) throws SQLException; 	// vs게시글 작성
	
	ArrayList<VsDTO> read(Connection con) throws SQLException;	// vs게시글 목록
	
	int update(int vs_no, String option, Connection con) throws SQLException;	// 투표수 업데이트
	
	int voting(int vs_no, String me_id, String opt, Connection con) throws SQLException;	// 중복 투표 방지
	
	int insert(VsCmtDTO comment, Connection con) throws SQLException; 	// vs댓글 작성
	
	ArrayList<VsCmtDTO> read(int vs_no, Connection con) throws SQLException;	// vs댓글 목록
}