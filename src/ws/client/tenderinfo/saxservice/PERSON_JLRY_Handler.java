/**
 * 用SAX解析XML的Handler
 */
package ws.client.tenderinfo.saxservice;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pojo.PERSON_JLRY;




public class PERSON_JLRY_Handler extends DefaultHandler {
    //存储正在解析的元素的数据
    private PERSON_JLRY PERSON_JLRY=null;
    //存储所有解析的元素的数据
    private List<PERSON_JLRY> PERSON_JLRYs=null;
    //正在解析的元素的名字
    String currentTag="";
    //正在解析的元素的元素值
    String currentValue="";
    //开始解析的元素
    String nodeName=null;
    

    public PERSON_JLRY_Handler(String nodeName) {
        // TODO Auto-generated constructor stub
        this.nodeName=nodeName;
    }
    
    public List<PERSON_JLRY> getList() {
        return PERSON_JLRYs;
    }

    //开始解析文档，即开始解析XML根元素时调用该方法
    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        //System.out.println("--startDocument()--");
        //初始化Map
        PERSON_JLRYs=new ArrayList<PERSON_JLRY>();
    }
    
    //开始解析每个元素时都会调用该方法
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        //判断正在解析的元素是不是开始解析的元素
        // System.out.println("--startElement()--"+qName);
        if(qName.equals(nodeName)){
        	PERSON_JLRY=new PERSON_JLRY();
        }
        
        //判断正在解析的元素是否有属性值,如果有则将其全部取出并保存到map对象中，如:<person id="00001"></person>
//        if(attributes!=null&&PERSON_JLRY!=null)
//        {
//            for(int i=0;i<attributes.getLength();i++){
//                //map.setId(Integer.parseInt(attributes.getValue(0)));
//            	PERSON_JLRY.setId(attributes.getValue(0));
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
        if(currentTag!=null&&PERSON_JLRY!=null){
            currentValue=new String(ch,start,length);
            //如果内容不为空和空格，也不是换行符则将该元素名和值和存入map中
            if("FName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFName(currentValue);
            }
            else if
            ("FCardID".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFCardID(currentValue);
            }
            else if
            ("FEntName".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFEntName(currentValue);
            }
            else if
            ("FCertType".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFCertType(currentValue);
            }
            else if
            ("FEntName1".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFEntName1(currentValue);
            }
            else if
            ("FCertNumber".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFCertNumber(currentValue);
            }
            else if
            ("FRegDate".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFRegDate(currentValue);
            }
            else if
            ("FRegEndDate".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFRegEndDate(currentValue);
            }
            else if
            ("FState".equals(currentTag)&&currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n"))
            {
            	PERSON_JLRY.setFState(currentValue);
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
        	PERSON_JLRYs.add(PERSON_JLRY);
        	PERSON_JLRY=null;
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