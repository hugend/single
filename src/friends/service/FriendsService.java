package friends.service;

import java.util.ArrayList;

import friends.dto.BdDTO;
import friends.dto.MsgDTO;
import member.dto.MemberDTO;

public interface FriendsService {
	
	int insertMsg(MsgDTO msg);	// 메시지 작성
	
	ArrayList<MsgDTO> readMsg(String option, String me_id);	// 메시지 목록
	
	int deleteMsg(String msg_no);	// 메시지 삭제
	
	int insertBd(BdDTO bd); // 친구 추가
	
	int deleteBd(BdDTO bd); // 친구 삭제

	ArrayList<String> friendsList(String me_id);	// 친구 목록

	ArrayList<MemberDTO> BckList(); // 블랙리스트 목록
	
	int deleteBlack(String me_id); // 블랙리스트 삭제
	
	ArrayList<MemberDTO> search(String search); // 블랙리스트 검색
	
}