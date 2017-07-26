package com.tj.jst.outside.business.quality.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.quality.model.ContractCorpQual;
import com.tj.jst.outside.business.quality.model.ContractRecord;
public class ContractRecordDaoImpl  extends BaseDao implements ContractRecordDao{

	@Override
	public Page pageContractRecordQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while (rs.next()) 
				{
					ContractRecord contractRecord = new ContractRecord();
					contractRecord.setRECORDNUM(rs.getString("RECORDNUM"));//合同备案编号
					contractRecord.setCONTRACTTYPENUM(rs.getString("CONTRACTTYPENUM"));//合同类别
					contractRecord.setCONTRACTTYPENAME(rs.getString("CONTRACTTYPENAME"));//合同类别名称
					contractRecord.setTENDERNUM(rs.getString("TENDERNUM"));//中标通知书编号
					contractRecord.setSECTIONNAME(rs.getString("SECTIONNAME"));//标段名称
					
					contractRecord.setCONTRACTMONEY(rs.getString("CONTRACTMONEY"));//标段名称
					contractRecord.setPROJECTADDRESS(rs.getString("PROJECTADDRESS"));//工程地址
					contractRecord.setPROJECTCOST(rs.getString("PROJECTCOST"));//工程造价
					contractRecord.setAREA(rs.getString("AREA"));//建筑面积
					contractRecord.setPRJNUM(rs.getString("PRJNUM"));//项目编号
					contractRecord.setPRJNAME(rs.getString("PRJNAME"));//项目名称
					contractRecord.setBUILDCORPNAME(rs.getString("BUILDCORPNAME"));//建设单位名称
					contractRecord.setCONTRACTORCORPNAME(rs.getString("CONTRACTORCORPNAME"));//承包单位名称
					contractRecord.setCONTRACTORCORPCODE(rs.getString("CONTRACTORCORPCODE"));//承包单位组织机构代码
					contractRecord.setBDATE(rs.getString("BDATE"));//计划开工日期
					contractRecord.setEDATE(rs.getString("EDATE"));//计划竣工验收日期
					
					contractRecord.setTITLELEVE(rs.getString("TITLELEVE"));//等级
					contractRecord.setCONSTRUCTORNAME(rs.getString("CONSTRUCTORNAME"));//项目经理
					contractRecord.setPHONE(rs.getString("PHONE"));//电话
					
					contractRecord.setPROJECTMANAGER(rs.getString("PROJECTMANAGER"));//建设单位项目负责人
					contractRecord.setUNITPHONE(rs.getString("UNITPHONE"));//建设单位联系电话

					contractRecord.setQUALITYCERTNUM(rs.getString("QUALITYCERTNUM"));
					contractRecord.setREPRESENTATIVECERTNUM(rs.getString("REPRESENTATIVECERTNUM"));
					
					//quality.setAppDate(rs.getDate("appDate"));//审批时间
					//quality.setCreateDate(rs.getDate("createDate"));//记录登记日期
					page.getData().add(contractRecord);
				}
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	@Override
	public Page pagedContractCorpQualQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while (rs.next()) 
				{
					ContractCorpQual contractCorpQual = new ContractCorpQual();
					contractCorpQual.setPRJNUM(rs.getString("PRJNUM"));//项目编号
					contractCorpQual.setPRJNAME(rs.getString("PRJNAME"));//项目名称
					contractCorpQual.setSECTIONNAME(rs.getString("SECTIONNAME"));//标段名称
					
					contractCorpQual.setRECORDNUM(rs.getString("RECORDNUM"));//合同备案编号
					contractCorpQual.setCONTRACTTYPENUM(rs.getString("CONTRACTTYPENUM"));//合同类别
					contractCorpQual.setCONTRACTTYPENAME(rs.getString("CONTRACTTYPENAME"));//合同类别名称
					contractCorpQual.setCONTRACTORCORPNAME(rs.getString("CONTRACTORCORPNAME"));//承包单位名称
					contractCorpQual.setCONTRACTORCORPCODE(rs.getString("CONTRACTORCORPCODE"));//承包单位组织代码
					contractCorpQual.setCONSTRUCTORNAME(rs.getString("CONSTRUCTORNAME"));//项目经理姓名
					contractCorpQual.setTITLELEVE(rs.getString("TITLELEVE"));//资质等级
					contractCorpQual.setPHONE(rs.getString("PHONE"));//联系电话
					contractCorpQual.setQUALIFICATIONSTYPE(rs.getString("QUALIFICATIONSTYPE"));//资质资格类型
					contractCorpQual.setQUALIFICATIONSTYPENAME(rs.getString("QUALIFICATIONSTYPENAME"));//资质资格类型名称
					contractCorpQual.setSPECIALTYTYPE(rs.getString("SPECIALTYTYPE"));//专业类别
					contractCorpQual.setSPECIALTYTYPENAME(rs.getString("SPECIALTYTYPENAME"));//专业类别名称
					contractCorpQual.setRATING(rs.getString("RATING"));//资质资格等级
					contractCorpQual.setRATINGNAME(rs.getString("RATINGNAME"));//资质资格等级名称
					//quality.setAppDate(rs.getDate("appDate"));//审批时间
					//quality.setCreateDate(rs.getDate("createDate"));//记录登记日期
					page.getData().add(contractCorpQual);
				}
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

}
