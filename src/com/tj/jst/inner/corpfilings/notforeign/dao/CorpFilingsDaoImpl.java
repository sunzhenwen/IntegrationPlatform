package com.tj.jst.inner.corpfilings.notforeign.dao;

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
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 企业备案
 * 
 * @author Administrator
 *
 */
public class CorpFilingsDaoImpl extends BaseDao implements ICorpFilingsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {

		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Corp corp = new Corp();
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
					corp.setEconomicName(rs.getString("corpRegType"));
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
					corp.setAssets(rs.getString("assets"));
					corp.setMachinery(rs.getString("machinery"));
					corp.setSpare1(rs.getString("spare1"));// 企业归属地
					corp.setAppType(rs.getString("appType"));// 审批状态
					corp.setCreateDate(rs.getDate("CREATDATE"));// 申请日期
					page.getData().add(corp);
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
	 * 新企业添加
	 * 
	 * @return
	 */
	@Override
	public void addCorp(Corp corp) {
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
				+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
				+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
			pstmt.setString(19, corp.getOfficePhone());// 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 添加时间
			pstmt.setString(28, corpId); // 主键
			pstmt.setString(29, "1"); // 新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets()); // 净资产
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());// 企业归属地
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
							+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,"
							+ "appType,spare1,CREATEDATE) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getApplyOpinion());
			pstmt.setString(5, corp.getApplyStaffId());
			pstmt.setString(6, corp.getApplyStaffName());
			pstmt.setString(7, corp.getApplyDept());
			pstmt.setString(8, corp.getApplyDeptName());
			pstmt.setString(9, "1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11, new Date(new java.util.Date().getTime())); // 创建时间
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 保存外商企业
	 */
	@Override
	public void addForeignCorp(Corp corp) {
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
			pstmt.setString(19, corp.getOfficePhone());// 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 添加时间
			pstmt.setString(28, corpId); // 主键
			pstmt.setString(29, "1"); // 新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());// 企业归属地
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
							+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,"
							+ "FOREIGNIVESTOR,CREATEDATE) values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getForeignCorpName());
			pstmt.setString(5, corp.getNationNume());
			pstmt.setString(6, corp.getPrincipalUnitNum());
			pstmt.setString(7, corp.getRegPrin());
			pstmt.setString(8, corp.getPercentTage());
			pstmt.setString(9, corp.getForeignIvestor());
			pstmt.setDate(10, new Date(new java.util.Date().getTime())); // 创建时间
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
							+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,"
							+ "appType,spare1,CREATEDATE) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getApplyOpinion());
			pstmt.setString(5, corp.getApplyStaffId());
			pstmt.setString(6, corp.getApplyStaffName());
			pstmt.setString(7, corp.getApplyDept());
			pstmt.setString(8, corp.getApplyDeptName());
			pstmt.setString(9, "1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11, new Date(new java.util.Date().getTime())); // 创建时间
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 查询单条
	 * 
	 * @return
	 */
	public Corp queryCorpForId(String corpId) {
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
																		// 0:境外企业；1：境外自然人
				corp.setCheckForeign(rs.getString("checkForeign"));// 是否外商投资
																	// 0:是；1：否
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

	/**
	 * 企业修改
	 * 
	 * @return
	 */
	@Override
	public void modifyCorp(Corp corp) {
		String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?"
				+ " where CORPID=? ";

		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
			pstmt.setString(19, corp.getOfficePhone());// 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 修改时间
			pstmt.setString(28, corp.getAssets()); // 净资产
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCorpId()); // 主键
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 审批通过
	 * 
	 * @return
	 */
	public void applythrough(Corp corp) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update T_TBCORPBUSINESS set APPLYOPINION=?,"
							+ "APPLYSTAFFID=?,APPLYSTAFFNAME=?,APPLYDEPT=?,APPLYDEPTNAME=?,appType=?"
							+ " where corpId=?");

			pstmt.setString(1, corp.getApplyOpinion());
			pstmt.setString(2, corp.getApplyStaffId());
			pstmt.setString(3, corp.getApplyStaffName());
			pstmt.setString(4, corp.getApplyDept());
			pstmt.setString(5, corp.getApplyDeptName());
			pstmt.setString(6, "1");
			pstmt.setString(7, corp.getCorpId());
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 审批未通过
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);

			pstmt = conn
					.prepareStatement("update T_TBCORPBUSINESS set APPLYOPINION=?,"
							+ "APPLYSTAFFID=?,APPLYSTAFFNAME=?,APPLYDEPT=?,APPLYDEPTNAME=?,appType=?"
							+ " where corpId=?");

			pstmt.setString(1, corp.getApplyOpinion());
			pstmt.setString(2, corp.getApplyStaffId());
			pstmt.setString(3, corp.getApplyStaffName());
			pstmt.setString(4, corp.getApplyDept());
			pstmt.setString(5, corp.getApplyDeptName());
			pstmt.setString(6, "2");
			pstmt.setString(7, corp.getCorpId());
			pstmt.executeUpdate();

			String sql = "delete from TBCorpBasicinfo where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpId());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("delete from TBCorpForeigninfo where CORPID=?");
			pstmt.setString(1, corp.getCorpId());
			pstmt.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	// 查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
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

	// 查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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

	// 查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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

	/**
	 * 组织机构代码证重复判断
	 */
	@Override
	public String queryCorpCode(String corpCode) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBCorpBasicinfo where corpCode=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "重复";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}
