package com.tj.jst.inner.business.contractinfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.business.contractinfo.model.ContractInfo;

/**
 * 合同信息数据库类
 * 
 * @author Administrator
 *
 */
public class ContractInfoDaoImpl extends BaseDao implements IContractInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ContractInfo contract = new ContractInfo();
					contract.setConID(rs.getString("conID"));
					contract.setConMessage(rs.getString("conMessage"));
					contract.setConName(rs.getString("conName"));
					contract.setConType(rs.getString("conType"));
					contract.setCreateDate(rs.getDate("createDate"));
					contract.setInCommon(rs.getString("inCommon"));
					contract.setPNumber(rs.getInt("pNumber"));
					page.getData().add(contract);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 查询详细
	 */
	@Override
	public ContractInfo queryById(String conid) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_CONTRACTINFO where conId = '" + conid
				+ "'";
		ContractInfo contract = new ContractInfo();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contract.setConID(rs.getString("conID"));
				contract.setConMessage(rs.getString("conMessage"));
				contract.setConName(rs.getString("conName"));
				contract.setConType(rs.getString("conType"));
				contract.setCreateDate(rs.getDate("createDate"));
				contract.setPNumber(rs.getInt("pNumber"));
				contract.setInCommon(rs.getString("inCommon"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return contract;
	}

	/**
	 * 增加信息
	 */
	@Override
	public String addContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		String sql = "insert into TB_CONTRACTINFO(CONID,CONNAME,CONTYPE,CONMESSAGE,CREATEDATE,PNUMBER,INCOMMON) values(?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		String message = "";
		int check = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, contract.getConName());
			pstmt.setString(3, contract.getConType());
			pstmt.setString(4, contract.getConMessage());
			pstmt.setDate(5, new Date(new java.util.Date().getTime()));
			pstmt.setInt(6, contract.getPNumber());
			pstmt.setString(7, contract.getInCommon());
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "添加成功!";
			} else {
				message = "添加失败!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 修改信息
	 */
	@Override
	public String modifyContractInfo(ContractInfo contract) {
		// TODO Auto-generated method stub
		int check = 0;
		String message = "";
		String sql = "update TB_CONTRACTINFO set CONNAME=?,CONMESSAGE=?,CONTYPE=?,PNUMBER=?,INCOMMON=? where CONID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contract.getConName());
			pstmt.setString(2, contract.getConMessage());
			pstmt.setString(3, contract.getConType());
			pstmt.setInt(4, contract.getPNumber());
			pstmt.setString(5, contract.getInCommon());
			pstmt.setString(6, contract.getConID());
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "修改成功！";
			} else {
				message = "修改失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 删除信息
	 */
	@Override
	public String deleteContarctInfo(String conId) {
		// TODO Auto-generated method stub
		String message = "";
		int check = 0;
		String sql = "delete from TB_CONTRACTINFO where CONID=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, conId);
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "删除成功！";
			} else {
				message = "删除失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 查询合同类别名称
	 */
	@Override
	public List<DictionaryClass> queryConTypeName() {
		// TODO Auto-generated method stub
		String sql = "select * from TB_CONTARCTINFODIC ";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

}
