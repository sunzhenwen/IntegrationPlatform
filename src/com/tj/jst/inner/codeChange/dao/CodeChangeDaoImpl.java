package com.tj.jst.inner.codeChange.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.codeChange.model.CodeChange;

/**
 * 组织机构代码变更
 * @author hhc 2016-04-21
 *
 */
public class CodeChangeDaoImpl extends BaseDao implements ICodeChangeDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
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
					CodeChange codeChange = new CodeChange();
					codeChange.setCodeChangeId(rs.getString("codeChangeId"));//主键
					codeChange.setCorpName(rs.getString("corpName"));//企业名称
					codeChange.setOldCode(rs.getString("oldCode"));//变更前组织机构代码
					codeChange.setNewCode(rs.getString("newCode"));//变更后组织机构代码
					codeChange.setCreateDate(rs.getDate("createDate"));//创建时间
					page.getData().add(codeChange);
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

	/**
	 * 添加变更记录
	 * @return
	 */
	public String add(CodeChange codeChange)
	{
		String message = "";
		//修改变更各个表中的组织机构代码
		boolean checkType = this.modify(codeChange);
		if(checkType)
		{
			String codeChangeId = UUID.randomUUID().toString();
			try {
				conn = ConnectionFactory.getBasicConnection();
				conn.setAutoCommit(false);
				String sql = "insert into CODE_CHANGE(codeChangeId,corpId,corpName,oldCode,"
						+ "newCode,createDate) "
						+ "values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,codeChangeId);	//主键
				pstmt.setString(2, codeChange.getCorpId());//企业主键
				pstmt.setString(3, codeChange.getCorpName()); //企业名称
				pstmt.setString(4, codeChange.getOldCode());//变更前组织机构代码
				pstmt.setString(5, codeChange.getNewCode()); //变更后组织机构代码
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));//变更时间
				pstmt.executeUpdate();
				conn.commit();
				message = "1";
			} catch (SQLException e) {
				message = "2";
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
			
		}else
		{
			message = "2";
		}
		return message;
	}
	
	
	/**
	 * 修改各个表中的组织机构代码
	 * @param construction
	 * @return
	 */
	public boolean modify(CodeChange codeChange)
	{
		boolean checkType = true;
		try {
			conn = ConnectionFactory.getBasicConnection();
			stmt = conn.createStatement();
			//项目报建表
			stmt.addBatch("update TBPROJECTINFO_S set buildCorpCode='"+codeChange.getNewCode()+"' where BUILDCORPNAME='"+codeChange.getCorpName()+"'");
			
			//合同备案发包单位
			stmt.addBatch("update tbcontractrecordmanage set PROPIETORCORPCODE='"+codeChange.getNewCode()+"' where PROPIETORCORPNAME='"+codeChange.getCorpName()+"'");
			//合同备案承包单位
			stmt.addBatch("update tbcontractrecordmanage set CONTRACTORCORPCODE='"+codeChange.getNewCode()+"' where CONTRACTORCORPNAME='"+codeChange.getCorpName()+"'");
			//合同备案联合体
			stmt.addBatch("update tbcontractrecordmanage set UNIONCORPCODE='"+codeChange.getNewCode()+"' where UNIONCORPNAME='"+codeChange.getCorpName()+"'");
			
			//质量勘察单位组织机构代码
			stmt.addBatch("update TB_QUALITYSUPERVISION set ECONCORPCODE='"+codeChange.getNewCode()+"' where SURVEYUNIT='"+codeChange.getCorpName()+"'");
			//质量设计单位组织机构代码
			stmt.addBatch("update TB_QUALITYSUPERVISION set DESIGNCORPCODE='"+codeChange.getNewCode()+"' where DESIGNUNIT='"+codeChange.getCorpName()+"'");
			//质量施工单位组织机构代码
			stmt.addBatch("update TB_QUALITYSUPERVISION set CONSCORPCODE='"+codeChange.getNewCode()+"' where CONSTRUCTIONUNIT='"+codeChange.getCorpName()+"'");
			//质量监理单位组织机构代码
			stmt.addBatch("update TB_QUALITYSUPERVISION set SUPERCORPCODE='"+codeChange.getNewCode()+"' where SUPERVISIONUNIT='"+codeChange.getCorpName()+"'");
			//质量申请单位组织机构代码
			stmt.addBatch("update TB_QUALITYSUPERVISION set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");

			
			//安全申请企业组织机构代码
			stmt.addBatch("update TB_SAFETYSUPERVISION set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//施工许可勘察单位组织机构代码
			stmt.addBatch("update tbbuilderlicencemanage set ECONCORPCODE='"+codeChange.getNewCode()+"' where ECONCORPNAME='"+codeChange.getCorpName()+"'");
			//施工许可设计单位组织机构代码
			stmt.addBatch("update tbbuilderlicencemanage set DESIGNCORPCODE='"+codeChange.getNewCode()+"' where DESIGNCORPNAME='"+codeChange.getCorpName()+"'");
			//施工许可施工单位组织机构代码
			stmt.addBatch("update tbbuilderlicencemanage set CONSCORPCODE='"+codeChange.getNewCode()+"' where CONSCORPNAME='"+codeChange.getCorpName()+"'");
			//施工许可监理单位组织机构代码
			stmt.addBatch("update tbbuilderlicencemanage set SUPERCORPCODE='"+codeChange.getNewCode()+"' where SUPERCORPNAME='"+codeChange.getCorpName()+"'");
			//施工许可申请单位组织机构代码
			stmt.addBatch("update tbbuilderlicencemanage set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//竣工验收质量检测机构组织机构代码
			stmt.addBatch("update TBPROJECTFINISHMANAGE set QCCORPCODE='"+codeChange.getNewCode()+"' where QCCORPNAME='"+codeChange.getCorpName()+"'");
			//竣工验收申请企业组织机构代码
			stmt.addBatch("update TBPROJECTFINISHMANAGE set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//授权组织机构代码
			stmt.addBatch("update TO_AUTHORIZATION set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			//授权被授权组织机构代码
			stmt.addBatch("update TO_AUTHORIZATION set AUCORPCODE='"+codeChange.getNewCode()+"' where AUCORPNAME='"+codeChange.getCorpName()+"'");
			
			
			//招投标,招标单位组织机构代码
			stmt.addBatch("update TBTENDERINFO set AGENCYCORPCODE='"+codeChange.getNewCode()+"' where AGENCYCORPNAME='"+codeChange.getCorpName()+"'");
			//招投标,中标单位组织机构代码
			stmt.addBatch("update TBTENDERINFO set TENDERCORPCODE='"+codeChange.getNewCode()+"' where TENDERCORPNAME='"+codeChange.getCorpName()+"'");
			//招投标,联合体承包组织机构代码
			stmt.addBatch("update TBTENDERINFO set UNIONCORPCODE='"+codeChange.getNewCode()+"' where UNIONCORPNAME='"+codeChange.getCorpName()+"'");
			//招投标,发包单位组织机构代码
			stmt.addBatch("update TBTENDERINFO set PROPIETORCORPCODE='"+codeChange.getNewCode()+"' where PROPIETORCORPNAME='"+codeChange.getCorpName()+"'");
			
			//技术工人,组织机构代码
			stmt.addBatch("update TBSKILLEDWORKER set corpcode='"+codeChange.getNewCode()+"' where corpname='"+codeChange.getCorpName()+"'");
			
			//职称人员,组织机构代码
			stmt.addBatch("update TBREGTITLEPERSON set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			
			//建筑企业统计报表
			stmt.addBatch("update CORP_REPORT set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			
			
			// 取消自动提交
            conn.setAutoCommit(false);
            stmt.executeBatch();
            // 如果没有错误，则表示可以向下执行 手工提交
            conn.commit();
			
		} catch (SQLException e) 
		{
			checkType = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, stmt, null);
		}
		return checkType;
	}
}
