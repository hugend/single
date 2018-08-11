package local.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

import local.dto.LeDTO;

public interface LocalDAO {
	ArrayList<LeDTO> geteventlist(Connection con) throws SQLException;
}
