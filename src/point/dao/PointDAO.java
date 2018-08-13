package point.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import point.dto.PointDTO;

public interface PointDAO {
	int po_insert(PointDTO dto, Connection con) throws SQLException;
	ArrayList<PointDTO> po_list(Connection con)throws SQLException;
	PointDTO po_read(int po_no, Connection con)throws SQLException;
	int po_delete(String po_no, Connection con) throws SQLException;
	int po_update(PointDTO prd, Connection con) throws SQLException;
	int count_update(int po_no, Connection con) throws SQLException;
	int po_state_update(int po_state, int po_no, Connection con) throws SQLException;
}
