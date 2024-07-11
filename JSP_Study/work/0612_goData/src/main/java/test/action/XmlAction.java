package test.action;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.DOMImplementation;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import test.vo.PersonalVO;

public class XmlAction implements Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청할 경로를 변수에 저장한다.
		String path = "http://localhost:8080/0612_goData/data/test.xml";
		
		URL url = null;
		
		try {
			url =new URL(path);//웹상의 경로를 객체화한 것
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type", "application/xml");//헤더에
			//받을 자원이 어떤 자원인지? mimeType을 지정한다.
			conn.connect();
			
			//이제 요청하여 받을 자원들을 처리할 JDOM객체들을 준비
			SAXBuilder builder = new SAXBuilder();
			
			//문서객체 생성
			Document doc = builder.build(conn.getContentType());
			
			//생성된 문서객체로 부터 루트를 얻어내자
			Element root =doc.getRootElement();
			System.out.println(root.getName());
			
			Element totalCount = root.getChild("totalCount");
			
			List<Element> p_list = root.getChildren("personal");
			PersonalVO[] ar = new PersonalVO[p_list.size()];
			//위의 배열이 지금은 비어있지만 아래의 반복문을 수행하면
			// 채워지도록 해야 하고 이 배열이 request에 저장되어야 한다.
			int i =0;
			for(Element e : p_list) {
				//이름 - personnal안에 있는 자식들 중
				//		태그 이름이 "name"인 요소의 문자열 가져오기
				String name = e.getChildText("name");
				System.out.println("이름:"+name);
				
				String email = e.getChildText("email");
				System.out.println("이메일:"+email);
				
				ar[i] = new PersonalVO(name, email);
				i++;
			}//for의 끝
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "personal.jsp";
	}
}
