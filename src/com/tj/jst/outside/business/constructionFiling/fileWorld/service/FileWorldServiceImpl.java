package com.tj.jst.outside.business.constructionFiling.fileWorld.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.dao.FileWorldDaoImpl;
import com.tj.jst.outside.business.constructionFiling.fileWorld.dao.IFileWorldDao;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * 施工合同word模板
 * @author hhc
 *
 */
public class FileWorldServiceImpl implements IFileWorldService {
	
	/**
	 * 查询列表
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		//先查询业务表，判断是否已经提交
		List<FileWorld> fwList = dao.queryFileWorldBusiness(recordId,conType);
		if(fwList.size()!=0)
		{
			//如果业务表中有数据说明已经进行过提交，查询模板表
			List<FileWorld> contrasts = dao.queryFileWorld(recordId,conType);
			//循环业务表list
			for(int i=0;i<fwList.size();i++)
			{
				//业务表list设值
				fwList.get(i).setCheckType("1");
				//循环模板表list
				for(int k=0;k<contrasts.size();k++)
				{
					//如果模板表中的主键与业务表中所存的模板表的外键相同，模板表list移除该主键对象
					if(contrasts.get(k).getConId().equals(fwList.get(i).getTemplateId()))
					{
						contrasts.remove(k);
					}
				}
			}
			List<FileWorld> finalList = new ArrayList<FileWorld>();
			//合并业务表list
			finalList.addAll(fwList);
			//合并模板表list
			finalList.addAll(contrasts);

			//排序
			Collections.sort(finalList, new Comparator<FileWorld>(){  
				/*  
				 * int compare(FileWorld o1, FileWorld o2) 返回一个基本类型的整型，  
		         * 返回负数表示：o1 小于o2，  
		         * 返回0 表示：o1和o2相等，  
		         * 返回正数表示：o1大于o2。  
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
			//返回最终list
			return finalList;
		}else
		{
			//如果未提交，查询模板
			List<FileWorld> fws = dao.queryFileWorld(recordId,conType);
			//已提交
			for(int i=0;i<fws.size();i++)
			{
				//设置为未提交状态
				fws.get(i).setCheckType("0");
			}
			fwList = null;
			
			//排序
			Collections.sort(fws, new Comparator<FileWorld>(){  
				/*  
				 * int compare(FileWorld o1, FileWorld o2) 返回一个基本类型的整型，  
		         * 返回负数表示：o1 小于o2，  
		         * 返回0 表示：o1和o2相等，  
		         * 返回正数表示：o1大于o2。  
		         */  
				public int compare(FileWorld o1, FileWorld o2) {  
					//按照学生的年龄进行升序排列  
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
	 * 查询详细
	 */
	public FileWorld queryConMessage(String conId,String checkType,String recordId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		FileWorld fw = new FileWorld();
		if(checkType.equals("0"))
		{
			//未提交,查询模板表
			fw = dao.queryFileWorldById(conId);
			fw.setRecordId(recordId);
		}else
		{
			//已提交,查询业务表
			fw = dao.queryFileWorldBusinessById(conId);
		}
		return fw;
	}
	
	/**
	 * 如果未提交，在业务表中插入数据
	 * @param fileWorld
	 */
	public String save(FileWorld fileWorld)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		return dao.save(fileWorld);
	}

//	/**
//	 * 如果已提交修改业务表中的数据
//	 * @param fileWorld
//	 */
//	public String update(FileWorld fileWorld)
//	{
//		IFileWorldDao dao = new FileWorldDaoImpl();
//		return dao.update(fileWorld);
//	}
	
	/**
	 * 删除业务表数据还原模板
	 * @return
	 */
	public void delete(String conId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		dao.delete(conId);
	}
	
	/**
	 * 查看
	 * @return
	 */
	public FileWorld viewDetails(String conId)
	{
		IFileWorldDao dao = new FileWorldDaoImpl();
		return dao.viewDetails(conId);
	}
}
