package ws.client.tenderinfo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import pojo.CORP_AQSCXKZ;
import pojo.PERSON_JLRY;
import pojo.PERSON_SLRY;
import pojo.PERSON_TZZY;
import pojo.TBTenderInfo;
import pojo.TBTenderPersonInfo;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import ws.client.tenderinfo.GetAQSCXKZListResponse.GetAQSCXKZListResult;
import ws.client.tenderinfo.GetBidNoticeInfoResponse.GetBidNoticeInfoResult;
import ws.client.tenderinfo.GetBidNoticeListResponse.GetBidNoticeListResult;
import ws.client.tenderinfo.GetBidPersonListResponse.GetBidPersonListResult;
import ws.client.tenderinfo.GetJLRYListResponse.GetJLRYListResult;
import ws.client.tenderinfo.GetSLRYListResponse.GetSLRYListResult;
import ws.client.tenderinfo.GetTZZYListResponse.GetTZZYListResult;
import ws.client.tenderinfo.saxservice.CORP_AQSCXKZ_SaxService;
import ws.client.tenderinfo.saxservice.PERSON_JLRY_SaxService;
import ws.client.tenderinfo.saxservice.PERSON_SLRY_SaxService;
import ws.client.tenderinfo.saxservice.PERSON_TZZY_SaxService;
import ws.client.tenderinfo.saxservice.TBTenderInfo_SaxService;
import ws.client.tenderinfo.saxservice.TBTenderPersonInfo_SaxService;


public class InfoClient 
{

	    /** 
	     * 获取招投标信息(TBTenderInfo)集合
	     *  
	     * @param s 加密字符串
	     * @param row 准备获取的行数
	     * @return TBTenderInfoList
	     * @throws Exception 
	     */ 
		 public List<TBTenderInfo> getTBTenderInfoList(String s,int row) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        GetBidNoticeListResult  result = infoSoap.getBidNoticeList(s, row);
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        List<TBTenderInfo> TBTenderInfoList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            t.setOutputProperty("encoding","gb2312");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();
			    //System.out.println("招投标："+xmlStr);	  
				InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
			    TBTenderInfoList=TBTenderInfo_SaxService.ReadXML(in_withcode,"Row");
			
			 } 
	         catch (TransformerException e) 
		     {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			
			return TBTenderInfoList;
		   }
	  
		    /** 
		     * 通过FSectionID更新状态State为1表示收到上传成功
		     *  
		     * @param s 密字符串
		     * @param FSectionID  要设置状态的ID值
		     * @return 1设置成功 0失败或没有数据
		     * @throws Exception 
		     */ 
			 public int setTBTenderInfoState(String FSectionID,String s) 
			 {
				Info factory = new Info();
				InfoSoap infoSoap = factory.getInfoSoap();
		        int State = infoSoap.setBidNoticeState(FSectionID, s);         
				return State;		
			 }
	 
		 
		    /** 
		     * 未导入的招投标信息（TBTenderInfo）总数
		     *  
		     * @param s 加密字符串		   
		     * @return count 总数
		     * @throws Exception 
		     */ 
			 public int getTBTenderInfoCount(String s) 
			 {
				Info factory = new Info();
				InfoSoap infoSoap = factory.getInfoSoap();
		        int count = infoSoap.getBidNoticeListCount(s);
				return count;		
			 }
		 
		 
	 
		    /** 
		     * 通过FSectionID获取单个招投标信息(TBTenderInfo)
		     *  
		     * @param s 加密字符串
		     * @param FSectionID 
		     * @return TBTenderInfoList
		     * @throws Exception 
		     */ 
			 public List<TBTenderInfo> getTBTenderInfoList(String s,String FSectionID) 
			 {
				Info factory = new Info();
				InfoSoap infoSoap = factory.getInfoSoap();
		        GetBidNoticeInfoResult  result = infoSoap.getBidNoticeInfo(s, FSectionID);
		        Object o = result.content.get(0);
		        ElementNSImpl doc=(ElementNSImpl) o;
		        List<TBTenderInfo> TBTenderInfoList=new ArrayList();
		        try 
		        {
		            TransformerFactory  tf  =  TransformerFactory.newInstance();
		            Transformer t = tf.newTransformer();
		            t.setOutputProperty("encoding","gb2312");
		            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
					t.transform(new DOMSource(doc), new StreamResult(bos));
				    String xmlStr = bos.toString();
				    //System.out.println("招投标："+xmlStr);	  
					InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
				    TBTenderInfoList=TBTenderInfo_SaxService.ReadXML(in_withcode,"Row");
				
				 } catch (TransformerException e) 
			      {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				
				return TBTenderInfoList;
			   }
	 
	 
	    /** 
	     * 获取招投标人员信息集合(TBTenderPersonInfo)
	     *  
	     * @param s 加密字符串
	     * @param row 准备获取的行数
	     * @return TBTenderPersonInfoList
	     * @throws Exception 
	     */ 
		 public List<TBTenderPersonInfo> getTBTenderPersonInfoList(String s,int row) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
			GetBidPersonListResult  result = infoSoap.getBidPersonList(s, row);       
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        List<TBTenderPersonInfo> TBTenderPersonInfoList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            t.setOutputProperty("encoding","gb2312");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();
			   // System.out.println("人员："+xmlStr);	  
				InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
				TBTenderPersonInfoList=TBTenderPersonInfo_SaxService.ReadXML(in_withcode,"Row");
			
			 } catch (TransformerException e) 
		      {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			
			return TBTenderPersonInfoList;
		 }
	 
		 
//		/**
//		 * @param args
//		 * 
//		 */
//		 public List<TBTenderInfo> getTBTenderInfoList(String s,String TenderNum) 
//		 {
//			Info factory = new Info();
//			InfoSoap infoSoap = factory.getInfoSoap();
//	        GetBidNoticeListResult  result = infoSoap.getBidNoticeList(s,TenderNum);        
//	        Object o = result.content.get(0);
//	        ElementNSImpl doc=(ElementNSImpl) o;
//	        List<TBTenderInfo> TBTenderInfoList=new ArrayList();
//	        try 
//	        {
//	            TransformerFactory  tf  =  TransformerFactory.newInstance();
//	            Transformer t = tf.newTransformer();
//	            t.setOutputProperty("encoding","gb2312");
//	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
//				t.transform(new DOMSource(doc), new StreamResult(bos));
//			    String xmlStr = bos.toString();
//			    System.out.println("招投标："+xmlStr);	  
//				InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
//				TBTenderInfoList=TBTenderInfo_SaxService.ReadXML(in_withcode,"Row");
//					 
//			 } catch (TransformerException e) 
//			 {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			 }
//			return TBTenderInfoList;
//		   }
	 		 
		/**
		 * @param args
		 * 招投标人员更新状态
		 */
		 public int setTBTenderPersonInfoState(String fid,String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        int State = infoSoap.setBidPersonState(fid, s);         
			return State;		
		 }
		 
		 
		/**
		 * @param args
		 * 查询招投标人员总数
		 */
		 public int getTBTenderPersonInfoCount(String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        int count = infoSoap.getBidPersonListCount(s);
			return count;		
		 }
		 
		 
	
		 /**
		 * @param args
		 * 获取三类人员信息
		 */
		 public List<PERSON_SLRY> getPERSON_SLRYList(String FIdCertNo,String FEntName,String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        GetSLRYListResult  result = infoSoap.getSLRYList(FIdCertNo, FEntName, s);     
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        List<PERSON_SLRY> PERSON_SLRYList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            //window环境
	            //t.setOutputProperty("encoding","gb2312");
	            
	            //linux环境
	            t.setOutputProperty("encoding","utf-8");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();	   
			    InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
			    PERSON_SLRYList=PERSON_SLRY_SaxService.ReadXML(in_withcode,"Row");	
		    } catch (TransformerException e) 
	        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }	    
			return PERSON_SLRYList;
		  }
		 
		/**
		 * @param args
		 * 获取安全生产许可证企业
		 */
		 public List<CORP_AQSCXKZ> getCORP_AQSCXKZList(String FCorpCode,String FName,String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        GetAQSCXKZListResult  result = infoSoap.getAQSCXKZList(FCorpCode, FName, s);
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        //String xmlStr = doc.getTextContent(); 
	        List<CORP_AQSCXKZ> CORP_AQSCXKZList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            t.setOutputProperty("encoding","gb2312");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();	   
			 
				InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
				CORP_AQSCXKZList=CORP_AQSCXKZ_SaxService.ReadXML(in_withcode,"Row");
		    } catch (TransformerException e) 
	        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			return CORP_AQSCXKZList;
		  }
		 
		 	 
		/**
		 * @param args
		 * 获取监理人员信息
		 */
		 public List<PERSON_JLRY> getPERSON_JLRYList(String FIdCertNo,String FEntName,String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
	        GetJLRYListResult  result = infoSoap.getJLRYList(FIdCertNo, FEntName, s);
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        List<PERSON_JLRY> PERSON_JLRYList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            t.setOutputProperty("encoding","gb2312");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();	   
			    InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
			    PERSON_JLRYList=PERSON_JLRY_SaxService.ReadXML(in_withcode,"Row");
		    } catch (TransformerException e) 
	        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			return PERSON_JLRYList;
		  }  
		 
		 
		/**
		 * @param args
		 * 获取特种人员
		 */
		 public List<PERSON_TZZY> getPERSON_TZZYList(String FIdCertNo,String FEntName,String s) 
		 {
			Info factory = new Info();
			InfoSoap infoSoap = factory.getInfoSoap();
			GetTZZYListResult result = infoSoap.getTZZYList(FIdCertNo, FEntName, s);
	        Object o = result.content.get(0);
	        ElementNSImpl doc=(ElementNSImpl) o;
	        List<PERSON_TZZY> PERSON_TZZYList=new ArrayList();
	        try 
	        {
	            TransformerFactory  tf  =  TransformerFactory.newInstance();
	            Transformer t = tf.newTransformer();
	            t.setOutputProperty("encoding","gb2312");
	            ByteArrayOutputStream  bos  =  new  ByteArrayOutputStream();
				t.transform(new DOMSource(doc), new StreamResult(bos));
			    String xmlStr = bos.toString();	   
			    InputStream in_withcode = new  ByteArrayInputStream(xmlStr.getBytes());
			    PERSON_TZZYList=PERSON_TZZY_SaxService.ReadXML(in_withcode,"Row");
		    } catch (TransformerException e) 
	        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			return PERSON_TZZYList;
		  } 
		
		 //获取当前时间字符串
			public static String getCurrentDate()
			{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String dayTime=formatter.format(date);	
			
				return dayTime;
			}
			
		 
		 public static void main(String[] args)
			//public static void main(String[] args) 
		    {
			
			 InfoClient  infoClient=new InfoClient();
			 
			 int count1=infoClient.getTBTenderInfoCount("1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			 int count2=infoClient.getTBTenderPersonInfoCount("1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			 
			 
			 System.out.println(getCurrentDate()+"TBTenderInfo未导入数量"+count1);
			 System.out.println(getCurrentDate()+"TBTenderInfoCount未导入数量"+count2);
				//infoClient.getTBTenderInfoList("1RGQywA@AtMTEjwADAADYEwAA2BMAAA==", "2329091508250102-BD-001");
				
//				for(int j=0;j<500;j++)
//				{
//					List<TBTenderInfo> TBTenderInfoList=infoClient.getTBTenderInfoList("1RGQywA@AtMTEjwADAADYEwAA2BMAAA==", "2302051507220101-BD-001");
//					System.out.println("第"+j+"次");
//					for(int i=0;i<TBTenderInfoList.size();i++)
//					{
//						TBTenderInfo dto=TBTenderInfoList.get(i);
//						System.out.println(getCurrentDate()+"招投标："+dto.getTenderNum()+dto.getFSectionName());
//						
//					}
//					
//				}
				
				
				

				//	infoClient.getTBTenderPersonInfoList("1RGQywA@AtMTEjwADAADYEwAA2BMAAA==", 10);
					//System.out.println("第"+j+"次");
//					for(int i=0;i<TBTenderInfoList.size();i++)
//					{
//						TBTenderInfo dto=TBTenderInfoList.get(i);
//						System.out.println(getCurrentDate()+"招投标："+dto.getTenderNum()+dto.getFSectionName());
//						
//					}
					

				
				
				
//				
//				for(int j=0;j<1000;j++)
//				{
//					List<PERSON_TZZY> PERSON_TZZYList=infoClient.getPERSON_TZZYList("", "逊克县建筑工程公司", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
//					System.out.println("第"+j+"次");
//					for(int i=0;i<PERSON_TZZYList.size();i++)
//					{
//						PERSON_TZZY dto=PERSON_TZZYList.get(i);
//						System.out.println(getCurrentDate()+"特种专业人员："+i+","+dto.getFCertNumber()+","+dto.getFEntName()+","+dto.getFEntName1()+","+dto.getFIdCertNo()+","+dto.getFKindName()+","+dto.getFName());
//						
//					}
//				}
				
//				for(int j=0;j<500;j++)
//				{
//					List<CORP_AQSCXKZ> CORP_AQSCXKZList=infoClient.getCORP_AQSCXKZList("", "黑龙江省盛达劳务有限责任公司", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
//					System.out.println("第"+j+"次");
//					for(int i=0;i<CORP_AQSCXKZList.size();i++)
//					{
//						CORP_AQSCXKZ dto=CORP_AQSCXKZList.get(i);
//						System.out.println(getCurrentDate()+"安全生产许可："+i+","+dto.getFCertNumber()+","+dto.getFCorpCode()+","+dto.getFName()+","+dto.getFRegDate()+","+dto.getFRegEndDate()+","+dto.getFState());
//						
//					}
//				}
				
//				for(int j=0;j<500;j++)
//				{
//					List<PERSON_JLRY> PERSON_JLRYList=infoClient.getPERSON_JLRYList("", "黑龙江正义建设工程项目管理有限公司", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
//					System.out.println("第"+j+"次");
//					for(int i=0;i<PERSON_JLRYList.size();i++)
//					{
//						PERSON_JLRY dto=PERSON_JLRYList.get(i);
//						System.out.println(getCurrentDate()+"监理："+i+","+dto.getFCardID());
//						
//					}
//				}
				
				
//				List<CORP_AQSCXKZ> CORP_AQSCXKZList=infoClient.getCORP_AQSCXKZList("", "黑龙江省盛达劳务有限责任公司", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
//				for(int i=0;i<CORP_AQSCXKZList.size();i++)
//				{
//					CORP_AQSCXKZ dto=CORP_AQSCXKZList.get(i);
//					System.out.println(getCurrentDate()+"安全生产许可："+i+","+dto.getFCertNumber()+","+dto.getFCorpCode()+","+dto.getFName()+","+dto.getFRegDate()+","+dto.getFRegEndDate()+","+dto.getFState());
//					
//				}
//				
//				
//				for(int j=0;j<1000;j++)
//				{
//				    List<PERSON_SLRY> PERSON_SLRYList=infoClient.getPERSON_SLRYList("23118119871221022X", "", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
//				    System.out.println("第"+j+"次");
//				    for(int i=0;i<PERSON_SLRYList.size();i++){
//						PERSON_SLRY dto=PERSON_SLRYList.get(i);
//						System.out.println(getCurrentDate()+"三类人员："+i+","+dto.getFCertNumber()+","+dto.getFEntName()+","+dto.getFCertType()+","+dto.getFIdCertNo()+","+dto.getFEntName1()+","+dto.getFName());
//						
//					}
//				}

//				System.out.println(getCurrentDate()+"接口导入结束");
//				
		    }	
		 
		 
		 
		 
}
