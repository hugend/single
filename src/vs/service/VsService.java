package vs.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import vs.dto.VsCmtDTO;
import vs.dto.VsDTO;

public interface VsService {
	
	int insert(VsDTO post);	// vs게시글 작성
	
	ArrayList<VsDTO> read();	// vs게시글 목록
	
	int update(int vs_no, String option);	// 투표수 업데이트
	
	int voting(int vs_no, String me_id, String opt);	// 중복 투표 방지
	
	int insert(VsCmtDTO comment);	// vs댓글 작성
	
	ArrayList<VsCmtDTO> read(int vs_no);	// vs댓글 목록
}
