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
 * ��֯����������
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
	 * ��ѯ
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
					codeChange.setCodeChangeId(rs.getString("codeChangeId"));//����
					codeChange.setCorpName(rs.getString("corpName"));//��ҵ����
					codeChange.setOldCode(rs.getString("oldCode"));//���ǰ��֯��������
					codeChange.setNewCode(rs.getString("newCode"));//�������֯��������
					codeChange.setCreateDate(rs.getDate("createDate"));//����ʱ��
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
	 * ��ӱ����¼
	 * @return
	 */
	public String add(CodeChange codeChange)
	{
		String message = "";
		//�޸ı���������е���֯��������
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
				pstmt.setString(1,codeChangeId);	//����
				pstmt.setString(2, codeChange.getCorpId());//��ҵ����
				pstmt.setString(3, codeChange.getCorpName()); //��ҵ����
				pstmt.setString(4, codeChange.getOldCode());//���ǰ��֯��������
				pstmt.setString(5, codeChange.getNewCode()); //�������֯��������
				pstmt.setDate(6, new Date(new java.util.Date().getTime()));//���ʱ��
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
	 * �޸ĸ������е���֯��������
	 * @param construction
	 * @return
	 */
	public boolean modify(CodeChange codeChange)
	{
		boolean checkType = true;
		try {
			conn = ConnectionFactory.getBasicConnection();
			stmt = conn.createStatement();
			//��Ŀ������
			stmt.addBatch("update TBPROJECTINFO_S set buildCorpCode='"+codeChange.getNewCode()+"' where BUILDCORPNAME='"+codeChange.getCorpName()+"'");
			
			//��ͬ����������λ
			stmt.addBatch("update tbcontractrecordmanage set PROPIETORCORPCODE='"+codeChange.getNewCode()+"' where PROPIETORCORPNAME='"+codeChange.getCorpName()+"'");
			//��ͬ�����а���λ
			stmt.addBatch("update tbcontractrecordmanage set CONTRACTORCORPCODE='"+codeChange.getNewCode()+"' where CONTRACTORCORPNAME='"+codeChange.getCorpName()+"'");
			//��ͬ����������
			stmt.addBatch("update tbcontractrecordmanage set UNIONCORPCODE='"+codeChange.getNewCode()+"' where UNIONCORPNAME='"+codeChange.getCorpName()+"'");
			
			//�������쵥λ��֯��������
			stmt.addBatch("update TB_QUALITYSUPERVISION set ECONCORPCODE='"+codeChange.getNewCode()+"' where SURVEYUNIT='"+codeChange.getCorpName()+"'");
			//������Ƶ�λ��֯��������
			stmt.addBatch("update TB_QUALITYSUPERVISION set DESIGNCORPCODE='"+codeChange.getNewCode()+"' where DESIGNUNIT='"+codeChange.getCorpName()+"'");
			//����ʩ����λ��֯��������
			stmt.addBatch("update TB_QUALITYSUPERVISION set CONSCORPCODE='"+codeChange.getNewCode()+"' where CONSTRUCTIONUNIT='"+codeChange.getCorpName()+"'");
			//��������λ��֯��������
			stmt.addBatch("update TB_QUALITYSUPERVISION set SUPERCORPCODE='"+codeChange.getNewCode()+"' where SUPERVISIONUNIT='"+codeChange.getCorpName()+"'");
			//�������뵥λ��֯��������
			stmt.addBatch("update TB_QUALITYSUPERVISION set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");

			
			//��ȫ������ҵ��֯��������
			stmt.addBatch("update TB_SAFETYSUPERVISION set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//ʩ����ɿ��쵥λ��֯��������
			stmt.addBatch("update tbbuilderlicencemanage set ECONCORPCODE='"+codeChange.getNewCode()+"' where ECONCORPNAME='"+codeChange.getCorpName()+"'");
			//ʩ�������Ƶ�λ��֯��������
			stmt.addBatch("update tbbuilderlicencemanage set DESIGNCORPCODE='"+codeChange.getNewCode()+"' where DESIGNCORPNAME='"+codeChange.getCorpName()+"'");
			//ʩ�����ʩ����λ��֯��������
			stmt.addBatch("update tbbuilderlicencemanage set CONSCORPCODE='"+codeChange.getNewCode()+"' where CONSCORPNAME='"+codeChange.getCorpName()+"'");
			//ʩ����ɼ���λ��֯��������
			stmt.addBatch("update tbbuilderlicencemanage set SUPERCORPCODE='"+codeChange.getNewCode()+"' where SUPERCORPNAME='"+codeChange.getCorpName()+"'");
			//ʩ��������뵥λ��֯��������
			stmt.addBatch("update tbbuilderlicencemanage set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//��������������������֯��������
			stmt.addBatch("update TBPROJECTFINISHMANAGE set QCCORPCODE='"+codeChange.getNewCode()+"' where QCCORPNAME='"+codeChange.getCorpName()+"'");
			//��������������ҵ��֯��������
			stmt.addBatch("update TBPROJECTFINISHMANAGE set APPLYCORPCODE='"+codeChange.getNewCode()+"' where APPLYCORPNAME='"+codeChange.getCorpName()+"'");
			
			//��Ȩ��֯��������
			stmt.addBatch("update TO_AUTHORIZATION set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			//��Ȩ����Ȩ��֯��������
			stmt.addBatch("update TO_AUTHORIZATION set AUCORPCODE='"+codeChange.getNewCode()+"' where AUCORPNAME='"+codeChange.getCorpName()+"'");
			
			
			//��Ͷ��,�б굥λ��֯��������
			stmt.addBatch("update TBTENDERINFO set AGENCYCORPCODE='"+codeChange.getNewCode()+"' where AGENCYCORPNAME='"+codeChange.getCorpName()+"'");
			//��Ͷ��,�б굥λ��֯��������
			stmt.addBatch("update TBTENDERINFO set TENDERCORPCODE='"+codeChange.getNewCode()+"' where TENDERCORPNAME='"+codeChange.getCorpName()+"'");
			//��Ͷ��,������а���֯��������
			stmt.addBatch("update TBTENDERINFO set UNIONCORPCODE='"+codeChange.getNewCode()+"' where UNIONCORPNAME='"+codeChange.getCorpName()+"'");
			//��Ͷ��,������λ��֯��������
			stmt.addBatch("update TBTENDERINFO set PROPIETORCORPCODE='"+codeChange.getNewCode()+"' where PROPIETORCORPNAME='"+codeChange.getCorpName()+"'");
			
			//��������,��֯��������
			stmt.addBatch("update TBSKILLEDWORKER set corpcode='"+codeChange.getNewCode()+"' where corpname='"+codeChange.getCorpName()+"'");
			
			//ְ����Ա,��֯��������
			stmt.addBatch("update TBREGTITLEPERSON set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			
			//������ҵͳ�Ʊ���
			stmt.addBatch("update CORP_REPORT set CORPCODE='"+codeChange.getNewCode()+"' where CORPNAME='"+codeChange.getCorpName()+"'");
			
			
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            stmt.executeBatch();
            // ���û�д������ʾ��������ִ�� �ֹ��ύ
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
