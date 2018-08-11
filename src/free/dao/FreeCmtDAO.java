package free.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import free.dto.FreeCmtDTO;

public interface FreeCmtDAO {
	int insert(FreeCmtDTO cmt,Connection con) throws SQLException; // ´ñ±Û µî·Ï
	int delete(int fr_cmt_no,Connection con) throws SQLException; // ´ñ±Û »èÁ¦
	ArrayList<FreeCmtDTO> getCmtList(int fr_no, Connection con) throws SQLException;	// ´ñ±Û ¸ñ·Ï
	
}
