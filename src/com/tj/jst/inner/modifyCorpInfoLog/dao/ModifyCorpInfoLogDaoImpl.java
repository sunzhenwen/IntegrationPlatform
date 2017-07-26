package com.tj.jst.inner.modifyCorpInfoLog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.modifyCorpInfoLog.condition.ModifyCorpInfoLogCondition;
import com.tj.jst.inner.modifyCorpInfoLog.model.ModifyCorpInfoLog;

public class ModifyCorpInfoLogDaoImpl extends BaseDao implements IModifyCorpInfoLogDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public Page queryPage(ModifyCorpInfoLogCondition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			
			while(rs.next()) {
				ModifyCorpInfoLog modifyCorpInfoLog = new ModifyCorpInfoLog();
				modifyCorpInfoLog.setAddress(rs.getString("address"));
				modifyCorpInfoLog.setAddress1(rs.getString("address1"));
				modifyCorpInfoLog.setAssets(String.valueOf(rs.getDouble("assets")));
				modifyCorpInfoLog.setAssets1(String.valueOf(rs.getDouble("assets1")));
				modifyCorpInfoLog.setCheckForeign(rs.getString("checkForeign"));
				modifyCorpInfoLog.setCityNum(rs.getString("cityNum"));
				modifyCorpInfoLog.setCityNum1(rs.getString("cityNum1"));
				modifyCorpInfoLog.setCorpBirthDate(rs.getDate("corpBirthDate"));
				modifyCorpInfoLog.setCorpBirthDate1(rs.getDate("corpBirthDate1"));
				modifyCorpInfoLog.setCorpCode(rs.getString("corpCode"));
				modifyCorpInfoLog.setCorpId(rs.getString("corpId"));
				modifyCorpInfoLog.setCorpName(rs.getString("corpName"));
				modifyCorpInfoLog.setCorpName1(rs.getString("corpName1"));
				modifyCorpInfoLog.setCountyNum(rs.getString("countyNum"));
				modifyCorpInfoLog.setCountyNum1(rs.getString("countyNum1"));
				modifyCorpInfoLog.setCreatDate(rs.getDate("creatDate"));
				modifyCorpInfoLog.setDataSource(rs.getString("dataSource"));
				modifyCorpInfoLog.setDescription(rs.getString("description"));
				modifyCorpInfoLog.setEconomicNum(String.valueOf(rs.getInt("economicNum")));
				modifyCorpInfoLog.setEconomicnum1(String.valueOf(rs.getInt("economicnum1")));
				modifyCorpInfoLog.setCountyNum1(rs.getString("countyNum1"));
				modifyCorpInfoLog.setEmail(rs.getString("email"));
				modifyCorpInfoLog.setEnterpriseType(rs.getString("enterpriseType"));
				modifyCorpInfoLog.setFactRegprin(String.valueOf(rs.getDouble("factRegprin")));
				modifyCorpInfoLog.setFactRegprin1(String.valueOf(rs.getDouble("factRegprin1")));
				modifyCorpInfoLog.setFax(rs.getString("fax"));
				modifyCorpInfoLog.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				modifyCorpInfoLog.setIdcardtypeNum1(rs.getString("idcardtypeNum1"));
				modifyCorpInfoLog.setLegalMan(rs.getString("legalMan"));
				modifyCorpInfoLog.setLegalMan1(rs.getString("legalMan1"));
				modifyCorpInfoLog.setLegalManDuty(rs.getString("legalManDuty"));
				modifyCorpInfoLog.setLegalManDuty1(rs.getString("legalManDuty1"));
				modifyCorpInfoLog.setLegalManIdCard(rs.getString("legalManIdCard"));
				modifyCorpInfoLog.setLegalManIdCard1(rs.getString("legalManIdCard1"));
				modifyCorpInfoLog.setLegaManProTitle(rs.getString("legaManProTitle"));
				modifyCorpInfoLog.setLegaManProTitle1(rs.getString("legaManProTitle1"));
				modifyCorpInfoLog.setLicenseNum(rs.getString("licenseNum"));
				modifyCorpInfoLog.setLicenseNum1(rs.getString("licenseNum1"));
				modifyCorpInfoLog.setLinkMan(rs.getString("linkMan"));
				modifyCorpInfoLog.setLinkPhone(rs.getString("linkPhone"));
				modifyCorpInfoLog.setLinkTel(rs.getString("linkTel"));
				modifyCorpInfoLog.setLogid(rs.getString("logid"));
				modifyCorpInfoLog.setMachinery(rs.getString("machinery"));
				modifyCorpInfoLog.setModifyDate(rs.getDate("modifyDate"));
				modifyCorpInfoLog.setOfficePhone(rs.getString("officePhone"));
				modifyCorpInfoLog.setOldorNew(rs.getString("oldorNew"));
				modifyCorpInfoLog.setPostalCode(rs.getString("postalCode"));
				modifyCorpInfoLog.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				modifyCorpInfoLog.setProvinceNum(rs.getString("provinceNum"));
				modifyCorpInfoLog.setProvinceNum1(rs.getString("provinceNum1"));
				modifyCorpInfoLog.setRegprin(String.valueOf(rs.getDouble("regprin")));
				modifyCorpInfoLog.setRegprin1(String.valueOf(rs.getDouble("regprin1")));
				modifyCorpInfoLog.setSpare1(rs.getString("spare1"));
				modifyCorpInfoLog.setSpare11(rs.getString("spare11"));
				modifyCorpInfoLog.setUpdateTime(rs.getDate("updateTime"));
				modifyCorpInfoLog.setModifyingLocation(rs.getString("modifyingLocation"));
				page.getData().add(modifyCorpInfoLog);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		
		return page;
	}

	//查询省
		@Override
		public List<DictionaryClass> queryProvince() {
			String sql = "select * from TBXZQDMDIC where code like '%0000'";
			List<DictionaryClass> list = new ArrayList<DictionaryClass>();
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setName(rs.getString("name"));
					dictionaryClass.setCode(rs.getString("code"));
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
			
			return list;
		}

		//查询市
		@Override
		public List<DictionaryClass> queryCity(String provinceId) {
			String star = provinceId.substring(0, 2);
			String end = provinceId.substring(4, provinceId.length());
			String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
			List<DictionaryClass> list = new ArrayList<DictionaryClass>();
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setCode(rs.getString("code"));
					dictionaryClass.setName(rs.getString("name"));
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
			
			return list;
		}
		
		//查询区
		@Override
		public List<DictionaryClass> queryArea(String cityId) {
			String star = cityId.substring(0, 4);
			String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
			List<DictionaryClass> list = new ArrayList<DictionaryClass>();
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setCode(rs.getString("code"));
					dictionaryClass.setName(rs.getString("name"));
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
			return list;
		}

	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 详细
	 */
	@Override
	public ModifyCorpInfoLog queryInfo(String logId) {
		// TODO Auto-generated method stub
		String sql = "select * from MODIFYCORPINFO_LOG where logId=?" ;
		ModifyCorpInfoLog modifyCorpInfoLog = new ModifyCorpInfoLog();
		
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				modifyCorpInfoLog.setAddress(rs.getString("address"));
				modifyCorpInfoLog.setAddress1(rs.getString("address1"));
				modifyCorpInfoLog.setAssets(String.valueOf(rs.getDouble("assets")));
				modifyCorpInfoLog.setAssets1(String.valueOf(rs.getDouble("assets1")));
				modifyCorpInfoLog.setCheckForeign(rs.getString("checkForeign"));
				modifyCorpInfoLog.setCityNum(rs.getString("cityNum"));
				modifyCorpInfoLog.setCityNum1(rs.getString("cityNum1"));
				modifyCorpInfoLog.setCorpBirthDate(rs.getDate("corpBirthDate"));
				modifyCorpInfoLog.setCorpBirthDate1(rs.getDate("corpBirthDate1"));
				modifyCorpInfoLog.setCorpCode(rs.getString("corpCode"));
				modifyCorpInfoLog.setCorpId(rs.getString("corpId"));
				modifyCorpInfoLog.setCorpName(rs.getString("corpName"));
				modifyCorpInfoLog.setCorpName1(rs.getString("corpName1"));
				modifyCorpInfoLog.setCountyNum(rs.getString("countyNum"));
				modifyCorpInfoLog.setCountyNum1(rs.getString("countyNum1"));
				modifyCorpInfoLog.setCreatDate(rs.getDate("creatDate"));
				modifyCorpInfoLog.setDataSource(rs.getString("dataSource"));
				modifyCorpInfoLog.setDescription(rs.getString("description"));
				modifyCorpInfoLog.setEconomicNum(String.valueOf(rs.getInt("economicNum")));
				modifyCorpInfoLog.setEconomicnum1(String.valueOf(rs.getInt("economicnum1")));
				modifyCorpInfoLog.setCountyNum1(rs.getString("countyNum1"));
				modifyCorpInfoLog.setEmail(rs.getString("email"));
				modifyCorpInfoLog.setEnterpriseType(rs.getString("enterpriseType"));
				modifyCorpInfoLog.setFactRegprin(String.valueOf(rs.getDouble("factRegprin")));
				modifyCorpInfoLog.setFactRegprin1(String.valueOf(rs.getDouble("factRegprin1")));
				modifyCorpInfoLog.setFax(rs.getString("fax"));
				modifyCorpInfoLog.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				modifyCorpInfoLog.setIdcardtypeNum1(rs.getString("idcardtypeNum1"));
				modifyCorpInfoLog.setLegalMan(rs.getString("legalMan"));
				modifyCorpInfoLog.setLegalMan1(rs.getString("legalMan1"));
				modifyCorpInfoLog.setLegalManDuty(rs.getString("legalManDuty"));
				modifyCorpInfoLog.setLegalManDuty1(rs.getString("legalManDuty1"));
				modifyCorpInfoLog.setLegalManIdCard(rs.getString("legalManIdCard"));
				modifyCorpInfoLog.setLegalManIdCard1(rs.getString("legalManIdCard1"));
				modifyCorpInfoLog.setLegaManProTitle(rs.getString("legaManProTitle"));
				modifyCorpInfoLog.setLegaManProTitle1(rs.getString("legaManProTitle1"));
				modifyCorpInfoLog.setLicenseNum(rs.getString("licenseNum"));
				modifyCorpInfoLog.setLicenseNum1(rs.getString("licenseNum1"));
				modifyCorpInfoLog.setLinkMan(rs.getString("linkMan"));
				modifyCorpInfoLog.setLinkPhone(rs.getString("linkPhone"));
				modifyCorpInfoLog.setLinkTel(rs.getString("linkTel"));
				modifyCorpInfoLog.setLogid(rs.getString("logid"));
				modifyCorpInfoLog.setMachinery(rs.getString("machinery"));
				modifyCorpInfoLog.setModifyDate(rs.getDate("modifyDate"));
				modifyCorpInfoLog.setOfficePhone(rs.getString("officePhone"));
				modifyCorpInfoLog.setOldorNew(rs.getString("oldorNew"));
				modifyCorpInfoLog.setPostalCode(rs.getString("postalCode"));
				modifyCorpInfoLog.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				modifyCorpInfoLog.setProvinceNum(rs.getString("provinceNum"));
				modifyCorpInfoLog.setProvinceNum1(rs.getString("provinceNum1"));
				modifyCorpInfoLog.setRegprin(String.valueOf(rs.getDouble("regprin")));
				modifyCorpInfoLog.setRegprin1(String.valueOf(rs.getDouble("regprin1")));
				modifyCorpInfoLog.setSpare1(rs.getString("spare1"));
				modifyCorpInfoLog.setSpare11(rs.getString("spare11"));
				modifyCorpInfoLog.setUpdateTime(rs.getDate("updateTime"));
				modifyCorpInfoLog.setModifyingLocation(rs.getString("modifyingLocation"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return modifyCorpInfoLog;
	}

}
