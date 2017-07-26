/**
 * 用SAX解析XML的Handler
 */
package ws.client.tenderinfo.saxservice;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pojo.TBTenderInfo;




public class TBTenderInfo_Handler extends DefaultHandler {
    //存储正在解析的元素的数据
    private TBTenderInfo TBTenderInfo=null;
    //存储所有解析的元素的数据
    private List<TBTenderInfo> TBTenderInfos=null;
    //正在解析的元素的名字
    String currentTag="";
    //正在解析的元素的元素值
    String currentValue="";
    //开始解析的元素
    String nodeName=null;
    

    public TBTenderInfo_Handler(String nodeName) {
        // TODO Auto-generated constructor stub
        this.nodeName=nodeName;
    }
    
    public List<TBTenderInfo> getList() {
        return TBTenderInfos;
    }

    //开始解析文档，即开始解析XML根元素时调用该方法
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("--startDocument()--");
        //初始化Map
        TBTenderInfos=new ArrayList<TBTenderInfo>();
    }
    
    //开始解析每个元素时都会调用该方法
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        //判断正在解析的元素是不是开始解析的元素
        // System.out.println("--startElement()--"+qName);
        if(qName.equals(nodeName)){
        	TBTenderInfo=new TBTenderInfo();
        }
        
        //判断正在解析的元素是否有属性值,如果有则将其全部取出并保存到map对象中，如:<person id="00001"></person>
//        if(attributes!=null&&TBTenderInfo!=null)
//        {
//            for(int i=0;i<attributes.getLength();i++){
//                //map.setId(Integer.parseInt(attributes.getValue(0)));
//            	TBTenderInfo.setId(attributes.getValue(0));
//            }
//        }              
        currentTag=qName;  //正在解析的元素
    }
    
    //解析到每个元素的内容时会调用此方法
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException 
    {
        // TODO Auto-generated method stub
       // System.out.println("--characters()--");
        if(currentTag!=null&&TBTenderInfo!=null)
        {
            currentValue=new String(ch,start,length);
            //如果内容不为空和空格，也不是换行符则将该元素名和值和存入map中
            if("FID".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setFID(currentValue);
            }
            else if
            ("FBidID".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setFBidID(currentValue);
            }
            else if
            ("FSectionID".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setFSectionID(currentValue);
            }
            else if
            ("TenderNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderNum(currentValue);
            }
            else if
            ("PrjNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setPrjNum(currentValue);
            }
            else if
            ("TenderClassNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderClassNum(currentValue);
            }
            else if
            ("TenderTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderTypeNum(currentValue);
            }
            else if
            ("TenderResultDate".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderResultDate(currentValue);
            }
            else if
            ("TenderMoney".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderMoney(currentValue);
            }
            else if
            ("PrjSize".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setPrjSize(currentValue);
            }
            else if
            ("Area".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setArea(currentValue);
            }
            else if
            ("AgencyCorpName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setAgencyCorpName(currentValue);
            }
            else if
            ("AgencyCorpCode".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setAgencyCorpCode(currentValue);
            }
            else if
            ("TenderCorpName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderCorpName(currentValue);
            }
            else if
            ("TenderCorpCode".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTenderCorpCode(currentValue);
            }
            else if
            ("ConstructorName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructorName(currentValue);
            }
            else if
            ("IDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setIDCardTypeNum(currentValue);
            }
            else if
            ("ConstructorIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructorIDCard(currentValue);
            }
            
            else if
            ("CreateDate".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setCreateDate(currentValue);
            }
            
            else if
            ("UpdateDate".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setUpdateDate(currentValue);
            }
            else if
            ("State".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setState(currentValue);
            }
            else if
            ("FSectionName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setFSectionName(currentValue);
            }
            else if
            ("PrjName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setPrjName(currentValue);
            }
            
            
            else if
            ("TechnicalName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTechnicalName(currentValue);
            }
            else if
            ("TechnicalIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTechnicalIDCardTypeNum(currentValue);
            }
            else if
            ("TechnicalIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTechnicalIDCard(currentValue);
            }
            else if
            ("TechnicalCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setTechnicalCertNum(currentValue);
            }
            else if
            ("QualityName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setQualityName(currentValue);
            }
            else if
            ("QualityIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setQualityIDCardTypeNum(currentValue);
            }
            else if
            ("QualityIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setQualityIDCard(currentValue);
            }
            else if
            ("QualityCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setQualityCertNum(currentValue);
            }
            else if
            ("SecurityName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSecurityName(currentValue);
            }
            else if
            ("SecurityIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSecurityIDCardTypeNum(currentValue);
            }
            else if
            ("SecurityIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSecurityIDCard(currentValue);
            }
            else if
            ("SecurityCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSecurityCertNum(currentValue);
            }
            else if
            ("ConstructionName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructionName(currentValue);
            }
            else if
            ("ConstructionIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructionIDCardTypeNum(currentValue);
            }
            else if
            ("ConstructionIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructionIDCard(currentValue);
            }
            else if
            ("ConstructionCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setConstructionCertNum(currentValue);
            }
            else if
            ("DirectorName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setDirectorName(currentValue);
            }
            else if
            ("DirectorIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setDirectorIDCardTypeNum(currentValue);
            }
            else if
            ("DirectorIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setDirectorIDCard(currentValue);
            }
            else if
            ("DirectorCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setDirectorCertNum(currentValue);
            }
            else if
            ("RepresentativeName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setRepresentativeName(currentValue);
            }
            else if
            ("RepresentativeIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setRepresentativeIDCardTypeNum(currentValue);
            }
            else if
            ("RepresentativeIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setRepresentativeIDCard(currentValue);
            }
            else if
            ("RepresentativeCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setRepresentativeCertNum(currentValue);
            }
            else if
            ("SafetyName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSafetyName(currentValue);
            }
            else if
            ("SafetyIDCardTypeNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSafetyIDCardTypeNum(currentValue);
            }
            else if
            ("SafetyIDCard".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSafetyIDCard(currentValue);
            }
            
            else if
            ("PropietorCorpName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setPropietorCorpName(currentValue);
            }
            else if
            ("PropietorCorpCode".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setPropietorCorpCode(currentValue);
            }
            else if
            ("ProjectAddress".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setProjectAddress(currentValue);
            }
            else if
            ("ProjectCost".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setProjectCost(currentValue);
            }
            else if
            ("SafetyCertNum".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setSafetyCertNum(currentValue);
            }
            else if
            ("Isdelete".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	TBTenderInfo.setIsdelete(currentValue);
            }
            
            
            
            //当前的元素已解析过，将其置空用于下一个元素的解析
            currentTag=null;
            currentValue=null;
        }
            
    }
    
    //每个元素结束的时候都会调用该方法
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO Auto-generated method stub
       // System.out.println("--endElement()--"+qName);
        //判断是否为一个节点结束的元素标签
        if(qName.equals(nodeName)){
        	TBTenderInfos.add(TBTenderInfo);
        	TBTenderInfo=null;
        }
    }
    
    //结束解析文档，即解析根元素结束标签时调用该方法
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
       // System.out.println("--endDocument()--");
        super.endDocument();
    }
}