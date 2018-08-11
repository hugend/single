package friends.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import friends.dto.BdDTO;
import friends.dto.MsgDTO;
import member.dto.MemberDTO;
 
public interface FriendsDAO {
	
	int insertMsg(MsgDTO msg, Connection con) throws SQLException; 	// 메시지 작성
	
	ArrayList<MsgDTO> readMsg(String option, String me_id, Connection con) throws SQLException;	// 메시지 목록

	int insertBd(BdDTO bd, Connection con) throws SQLException; // 친구 추가
	
	int deleteBd(BdDTO bd, Connection con) throws SQLException; // 친구 삭제
	
	
	ArrayList<String> friendsList(String me_id, Connection con) throws SQLException;	// 친구 목록
	
	ArrayList<MemberDTO> BckList(Connection con) throws SQLException;	// 블랙리스트 목록
}
