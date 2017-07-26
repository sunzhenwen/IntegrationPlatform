package com.tj.jst.outside.business.queryBusiness.dao;

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
import com.tj.jst.outside.business.singleProject.model.SingleProject;

/**
 * ���幤��
 * @author hhc
 *
 */
public class QuerySingleProjectDaoImpl extends BaseDao implements IQuerySingleProjectDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
					SingleProject sp = new SingleProject();
					
					sp.setSpId(rs.getInt("unitid"));//����
					sp.setPrjId(rs.getString("prjid"));//��������
					sp.setSpNum(rs.getString("unitcode"));//��λ����
					sp.setBuildingName(rs.getString("subprjname"));//��λ��(��)��������
					sp.setBuildingArea(rs.getString("buildarea"));//�������(ƽ����)
					sp.setInvestAmount(rs.getString("invest"));//Ͷ�ʶ�(��Ԫ)
					sp.setOvergroundArea(rs.getString("floorbuildarea"));//���Ͻ������(ƽ����)
					sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//���½������(ƽ����)
					sp.setOvergroundNum(rs.getInt("floorcount"));//���ϲ���
					sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//���²���
					sp.setBuildingHeight(rs.getString("buildheight"));//�����߶�(��)
					sp.setEngineeringGrade(rs.getString("prjlevelnum"));//���̵ȼ�   0:���� 1:����  2:С�� 
					sp.setLengthKm(rs.getString("subprojectlength"));//����(����)
					sp.setSpanM(rs.getString("subprojectspan"));//���(��)
					sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
					sp.setProjectSize(rs.getString("pjrsize"));//���̹�ģ
					sp.setOther(rs.getString("memo"));//����
					sp.setLinkName(rs.getString("createtype"));//�����������Ŀ���ڱ�ţ�3��ʩ��ͼ��� 4����ȫ�ල 5��ʩ����� 6���������ձ���
					page.getData().add(sp);
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public SingleProject queryById(long spId)
	{

		SingleProject sp = new SingleProject();
		try {
			
			String qsql = "select * from TBPROJECTUNITINFO where unitid=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setLong(1, spId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				sp.setSpId(rs.getInt("unitid"));//����
				sp.setPrjId(rs.getString("prjid"));//������Ŀ����
				sp.setSpNum(rs.getString("unitcode"));//��λ����
				sp.setBuildingName(rs.getString("subprjname"));//��λ��(��)��������
				sp.setBuildingArea(rs.getString("buildarea"));//�������(ƽ����)
				sp.setInvestAmount(rs.getString("invest"));//Ͷ�ʶ�(��Ԫ)
				sp.setOvergroundArea(rs.getString("floorbuildarea"));//���Ͻ������(ƽ����)
				sp.setUndergroundArea(rs.getString("bottomfloorbuildarea"));//���½������(ƽ����)
				sp.setOvergroundNum(rs.getInt("floorcount"));//���ϲ���
				sp.setUndergroundNum(rs.getInt("bottomfloorcount"));//���²���
				sp.setBuildingHeight(rs.getString("buildheight"));//�����߶�(��)
				sp.setEngineeringGrade(rs.getString("prjlevelnum"));//���̵ȼ�   0:���� 1:����  2:С�� 
				sp.setLengthKm(rs.getString("subprojectlength"));//����(����)
				sp.setSpanM(rs.getString("subprojectspan"));//���(��)
				sp.setPrjStructureTypeNum(rs.getString("structuretypenum"));//�ṹ��ϵ(TBPRJSTRUCTURETYPEDIC)
				sp.setProjectSize(rs.getString("pjrsize"));//���̹�ģ
				sp.setOther(rs.getString("memo"));//����
				sp.setLinkName(rs.getString("createtype"));//�����������Ŀ���ڱ�ţ�3��ʩ��ͼ��� 4����ȫ�ල 5��ʩ����� 6���������ձ���
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return sp;
	}
	
	//�ṹ��ϵ(�ֵ��TBPRJSTRUCTURETYPEDIC)
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		String sql = "select * from TBPRJSTRUCTURETYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("struct"));
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

}
