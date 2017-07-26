/**
 * 封装解析业务类
 */
package ws.client.tenderinfo.saxservice;

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import pojo.TBTenderInfo;



public class TBTenderInfo_SaxService {
    
    public static List<TBTenderInfo> ReadXML(InputStream is,String NodeName){
        try {
            //创建一个解析XML的工厂对象
            SAXParserFactory parserFactory=SAXParserFactory.newInstance();
            //创建一个解析XML的对象
            SAXParser parser=parserFactory.newSAXParser();
            //创建一个解析助手类
            TBTenderInfo_Handler myhandler=new TBTenderInfo_Handler(NodeName);
           // parser.parse(uri, myhandler);
            parser.parse(is, myhandler);
            return myhandler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            
        }
        return null;
        
    }
}