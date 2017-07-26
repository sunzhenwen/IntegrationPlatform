package com.tj.jst.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.login.model.Login;

public class LoginDaoImpl implements ILoginDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// ��ѯ��ҵukey��½
	@Override
	public Login query(String results,String check) {
		
		String sql = "";
		
		if(!"1".equals(check))
		{
			sql = "select t.*,"
				+ "(select a.name from TBXZQDMDIC a where a.code=t.provincenum) as provinceName,"
				+ "(select b.name from TBXZQDMDIC b where b.code=t.citynum) as cityName,"
				+ "(select c.name from TBXZQDMDIC c where c.code=t.countynum) as countyName "
				+ "from TBCORPBASICINFO t where t.LOCKNUMBER1='" + results
				+ "' or t.LOCKNUMBER2='" + results + "' "
				+ "or t.LOCKNUMBER3='" + results + "'";
		}else
		{
			sql = "select t.*,"
					+ "(select a.name from TBXZQDMDIC a where a.code=t.provincenum) as provinceName,"
					+ "(select b.name from TBXZQDMDIC b where b.code=t.citynum) as cityName,"
					+ "(select c.name from TBXZQDMDIC c where c.code=t.countynum) as countyName "
					+ "from TBCORPBASICINFO t where (t.corpName='"+results+"') "
							+ "and (t.LOCKNUMBER1 is not null "
							+ "or t.LOCKNUMBER2 is not null "
							+ "or t.LOCKNUMBER3 is not null)"
							+ "and (t.enterprisetype is not null)";
		}
		
		
		Login login = new Login();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login.setuKey(results);
				// ����
				login.setUserId(rs.getString("corpId"));
				// ��ҵ����
				login.setUserName(rs.getString("corpName"));
				// ��֯��������
				login.setCorpCode(rs.getString("corpCode"));
				// ����Ӫҵִ�պ�
				login.setLicenseNum(rs.getString("licenseNum"));
				// ʡ����
				login.setProvincenum(rs.getString("provincenum"));
				// ʡ����
				login.setProvinceName(rs.getString("provinceName"));
				// �б���
				login.setCitynum(rs.getString("citynum"));
				// ������
				login.setCityName(rs.getString("cityName"));
				// ������
				login.setCountynum(rs.getString("countynum"));
				// ������
				login.setCountyName(rs.getString("countyName"));
				// ��ҵӪҵ��ַ
				login.setAddress(rs.getString("address"));
				// ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				login.setEconomicNum(rs.getInt("economicNum"));
				// ��������������
				login.setLegalMan(rs.getString("LEGALMAN"));
				// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				login.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				// ����������֤������
				login.setLegalManIdCard(rs.getString("legalManIdCard"));
				// ����������ְ��
				login.setLegaLManDuty(rs.getString("legaLManDuty"));
				// ����������ְ��
				login.setLegaManProtitle(rs.getString("legaManProtitle"));
				// ע���ʱ�
				login.setRegPrin(rs.getString("REGPRIN"));
				// ��ϵ�绰
				login.setOfficePhone(rs.getString("OFFICEPHONE"));
				// ��ҵ�����ر���
				String spare1 = rs.getString("spare1");
				login.setSpare1(spare1);

				if (spare1.equals("230100")) {
					login.setSpareName("������");
				}
				if (spare1.equals("230200")) {
					login.setSpareName("�������");
				}
				if (spare1.equals("231000")) {
					login.setSpareName("ĵ����");
				}
				if (spare1.equals("230600")) {
					login.setSpareName("����");
				}
				if (spare1.equals("230700")) {
					login.setSpareName("����");
				}
				if (spare1.equals("230400")) {
					login.setSpareName("�׸�");
				}
				if (spare1.equals("230800")) {
					login.setSpareName("��ľ˹");
				}
				if (spare1.equals("231100")) {
					login.setSpareName("�ں�");
				}
				if (spare1.equals("232700")) {
					login.setSpareName("���˰������");
				}
				if (spare1.equals("400021")) {
					login.setSpareName("ɭ��");
				}
				if (spare1.equals("400022")) {
					login.setSpareName("��Һ�");
				}
				if (spare1.equals("400023")) {
					login.setSpareName("��Զ");
				}
				if (spare1.equals("230300")) {
					login.setSpareName("����");
				}
				if (spare1.equals("400020")) {
					login.setSpareName("ũ��");
				}
				if (spare1.equals("230900")) {
					login.setSpareName("��̨��");
				}
				if (spare1.equals("230500")) {
					login.setSpareName("˫Ѽɽ");
				}
				if (spare1.equals("231200")) {
					login.setSpareName("�绯");
				}

				// ��������
				login.setOldOrNew(rs.getString("oldOrNew"));
				// ���ʲ�
				login.setAssets(rs.getString("assets"));
				// ��е�豸
				login.setMachinery(rs.getString("machinery"));
				// ��ҵ����
				login.setEnterPriseType(rs.getString("enterPriseType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return login;
	}

}
