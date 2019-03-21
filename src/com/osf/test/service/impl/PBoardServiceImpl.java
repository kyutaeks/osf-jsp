package com.osf.test.service.impl;

import java.util.List;
import java.util.Map;

import com.osf.test.dao.PBoardDAO;
import com.osf.test.dao.impl.PBoardDAOImpl;
import com.osf.test.service.PBoardService;

public class PBoardServiceImpl implements PBoardDAO, PBoardService {
	private PBoardDAO pbdao = new PBoardDAOImpl();

	@Override
	public int insertPBoard(Map<String, String> pBoard) {

		return pbdao.insertPBoard(pBoard);
	}

	@Override
	public List<Map<String, String>> selectPBoardList() {
		// TODO Auto-generated method stub
		return pbdao.selectPBoardList();
	}

	@Override
	public Map<String, String> selectPBoard(int pbNum) {
		// TODO Auto-generated method stub
		return pbdao.selectPBoard(pbNum);
	}

}
