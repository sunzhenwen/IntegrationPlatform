package com.tj.jst.inner.corpfilings.queryCorpApply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案审批查询
 * @author Administrator
 *
 */
public class QueryCorpFilingsDaoImpl extends BaseDao implements IQueryCorpFilingsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
						Corp corp = new Corp();
						
						corp.setCorpId(rs.getString("corpId"));		//主键	
						corp.setCorpName(rs.getString("corpName"));	//企业名称
						corp.setCorpCode(rs.getString("corpCode")); 	//组织机构代码
						corp.setLicenseNum(rs.getString("licenseNum"));//工商营业执照注册号
						corp.setProvinceNum(rs.getString("provinceNum"));//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
						corp.setCityNum(rs.getString("cityNum"));		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
						corp.setCountyNum(rs.getString("countyNum"));	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
						corp.setAddress(rs.getString("address"));		//企业营业地址
						corp.setPostalCode(rs.getString("postalCode"));//企业营业地址邮政编码
						corp.setLegalMan(rs.getString("legalMan"));	//法定代表人姓名
						corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
						corp.setLegalManIdCard(rs.getString("legalManIdCard"));//法定代表人证件号码
						corp.setLegalManDuty(rs.getString("legalManDuty"));//法定代表人职务
						corp.setLegaManProtitle(rs.getString("legaManProtitle"));//法定代表人职称
						corp.setEconomicNum(rs.getString("economicNum"));	//企业登记注册类型(字典表：TBECONTYPEDIC)
						corp.setRegPrin(rs.getString("regPrin")); 		//注册资本(万元)
						corp.setFactRegPrin(rs.getString("factRegPrin"));	//实收资本(万元)
						corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//注册资本币种(字典表：TBPRINCIPALUNITDIC)
						corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//成立日期
						corp.setOfficePhone(rs.getString("officePhone"));//办公电话
						corp.setFax(rs.getString("fax"));				//传真号码
						corp.setLinkMan(rs.getString("linkMan")); 		//联系人姓名
						corp.setLinkTel(rs.getString("linkTel"));		//联系人办公电话
						corp.setLinkPhone(rs.getString("linkPhone"));	//联系人手机号码
						corp.setEmail(rs.getString("email"));			//联系邮箱
						corp.setUrl(rs.getString("url"));				//企业网址
						corp.setDescription(rs.getString("description"));	//备注
						corp.setAssets(rs.getString("assets"));	
						corp.setMachinery(rs.getString("machinery"));
						corp.setSpare1(rs.getString("spare1"));//企业归属地
						//corp.setForeignCorpName(rs.getString("foreignCorpName"));//外商投资者名称
						//corp.setNationNume(rs.getString("nationnum"));//国籍或地区(字典表：TBNATIONALDIC)
						//corp.setPercentTage(rs.getString("percentTage"));//外商投资所占比例(%)
						//corp.setForeignIvestor(rs.getString("foreignIvestor"));	//外商投资这类型         0:境外企业；1：境外自然人
						//corp.setCheckForeign(rs.getString("checkForeign"));//是否外商投资	   0:是；1：否
						corp.setEnterpriseType(rs.getString("enterpriseType"));
						
						corp.setApplyStaffId(rs.getString("applyStaffId"));//审批人Id
						corp.setApplyStaffName(rs.getString("applyStaffName"));//审批人姓名
						corp.setApplyDept(rs.getString("applyDept"));//审批部门Id
						corp.setApplyDeptName(rs.getString("applyDeptName"));//审批部门名称
						corp.setApplyOpinion(rs.getString("applyOpinion"));//审批建议
						corp.setAppType(rs.getString("appType"));//审批状态
						//corp.setCreateDate(rs.getDate("CREATEDATE"));//审批日期
						page.getData().add(corp);
				}
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
	
	/**
	 * 查询单条
	 * 
	 * @return
	 */
	public Corp queryCorpInfo(String corpId) {
		Corp corp = new Corp();
		String sql = "select * from V_TBCORPFOREIGNINFO where corpId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				corp.setCorpId(rs.getString("corpId")); // 主键
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));// 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum"));// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));// 企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// 法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));// 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// 法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本(万元)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// 成立日期
				corp.setOfficePhone(rs.getString("officePhone"));// 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));// 企业归属地
				corp.setForeignCorpName(rs.getString("foreignCorpName"));// 外商投资者名称
				corp.setNationNume(rs.getString("nationnum"));// 国籍或地区(字典表：TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));// 外商投资所占比例(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor")); // 外商投资这类型
				corp.setCheckForeign(rs.getString("checkForeign"));// 是否外商投资
				corp.setAppType(rs.getString("appType"));
				corp.setApplyOpinion(rs.getString("applyOpinion"));
				corp.setApplyDeptName(rs.getString("applyDeptName"));
				corp.setApplyDept(rs.getString("applyDept"));
				corp.setApplyStaffId(rs.getString("applyStaffId"));
				corp.setApplyStaffName(rs.getString("applyStaffName"));
				corp.setSpare1(rs.getString("spare1"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
}
