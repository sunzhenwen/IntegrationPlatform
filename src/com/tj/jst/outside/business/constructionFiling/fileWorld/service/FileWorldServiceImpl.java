package com.tj.jst.outside.business.constructionFiling.fileWorld.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.dao.FileWorldDaoImpl;
import com.tj.jst.outside.business.constructionFiling.fileWorld.dao.IFileWorldDao;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * ʩ����ͬwordģ��
 * @author hhc
 *
 */
public class FileWorldServiceImpl implements IFileWorldService {
	
	/**
	 * ��ѯ�б�
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		//�Ȳ�ѯҵ����ж��Ƿ��Ѿ��ύ
		List<FileWorld> fwList = dao.queryFileWorldBusiness(recordId,conType);
		if(fwList.size()!=0)
		{
			//���ҵ�����������˵���Ѿ����й��ύ����ѯģ���
			List<FileWorld> contrasts = dao.queryFileWorld(recordId,conType);
			//ѭ��ҵ���list
			for(int i=0;i<fwList.size();i++)
			{
				//ҵ���list��ֵ
				fwList.get(i).setCheckType("1");
				//ѭ��ģ���list
				for(int k=0;k<contrasts.size();k++)
				{
					//���ģ����е�������ҵ����������ģ���������ͬ��ģ���list�Ƴ�����������
					if(contrasts.get(k).getConId().equals(fwList.get(i).getTemplateId()))
					{
						contrasts.remove(k);
					}
				}
			}
			List<FileWorld> finalList = new ArrayList<FileWorld>();
			//�ϲ�ҵ���list
			finalList.addAll(fwList);
			//�ϲ�ģ���list
			finalList.addAll(contrasts);

			//����
			Collections.sort(finalList, new Comparator<FileWorld>(){  
				/*  
				 * int compare(FileWorld o1, FileWorld o2) ����һ���������͵����ͣ�  
		         * ���ظ�����ʾ��o1 С��o2��  
		         * ����0 ��ʾ��o1��o2��ȣ�  
		         * ����������ʾ��o1����o2��  
		         */  
				public int compare(FileWorld o1, FileWorld o2) {  
					if(o1.getPnumber() > o2.getPnumber()){  
		            	return 1;  
		            }  
		            if(o1.getPnumber() == o2.getPnumber()){  
		            	return 0;  
		            }  
		            return -1;  
		        }  
			});
			//��������list
			return finalList;
		}else
		{
			//���δ�ύ����ѯģ��
			List<FileWorld> fws = dao.queryFileWorld(recordId,conType);
			//���ύ
			for(int i=0;i<fws.size();i++)
			{
				//����Ϊδ�ύ״̬
				fws.get(i).setCheckType("0");
			}
			fwList = null;
			
			//����
			Collections.sort(fws, new Comparator<FileWorld>(){  
				/*  
				 * int compare(FileWorld o1, FileWorld o2) ����һ���������͵����ͣ�  
		         * ���ظ�����ʾ��o1 С��o2��  
		         * ����0 ��ʾ��o1��o2��ȣ�  
		         * ����������ʾ��o1����o2��  
		         */  
				public int compare(FileWorld o1, FileWorld o2) {  
					//����ѧ�������������������  
		            if(o1.getPnumber() > o2.getPnumber()){  
		            	return 1;  
		            }  
		            if(o1.getPnumber() == o2.getPnumber()){  
		            	return 0;  
		            }  
		            return -1;  
		        }  
			});
			
			return fws;
		}
	}
	
	/**
	 * ��ѯ��ϸ
	 */
	public FileWorld queryConMessage(String conId,String checkType,String recordId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		FileWorld fw = new FileWorld();
		if(checkType.equals("0"))
		{
			//δ�ύ,��ѯģ���
			fw = dao.queryFileWorldById(conId);
			fw.setRecordId(recordId);
		}else
		{
			//���ύ,��ѯҵ���
			fw = dao.queryFileWorldBusinessById(conId);
		}
		return fw;
	}
	
	/**
	 * ���δ�ύ����ҵ����в�������
	 * @param fileWorld
	 */
	public String save(FileWorld fileWorld)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		return dao.save(fileWorld);
	}

//	/**
//	 * ������ύ�޸�ҵ����е�����
//	 * @param fileWorld
//	 */
//	public String update(FileWorld fileWorld)
//	{
//		IFileWorldDao dao = new FileWorldDaoImpl();
//		return dao.update(fileWorld);
//	}
	
	/**
	 * ɾ��ҵ������ݻ�ԭģ��
	 * @return
	 */
	public void delete(String conId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		dao.delete(conId);
	}
	
	/**
	 * �鿴
	 * @return
	 */
	public FileWorld viewDetails(String conId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		return dao.viewDetails(conId);
	}
}
