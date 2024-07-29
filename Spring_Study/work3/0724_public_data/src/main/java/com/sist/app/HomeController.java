package com.sist.app;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		URL url = new URL("https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName="+URLEncoder.encode("강남구")+"&dataTerm=DAILY&pageNo=1&numOfRows=100&returnType=xml&serviceKey=LGJwRYUnjFABurhH4%2BLhBkNY9B9iUaWZG3N5Y2rzlM70kV97pRIzhj%2FTtB%2B%2FZiH4ZQP1wcikIrpZEaEXxC3g2g%3D%3D");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		//서버로 부터 받는 자원이 xml문서이므로 헤더에 mimeType을 지정한다.
		conn.setRequestProperty("Content-Type", "application/xml");
		
		conn.connect();
		
		//이제 요청하여 받을 자원들을 처리할 객체를 준비
		SAXBuilder builder = new SAXBuilder();
		//이 객체를 사용하기 위해 MVNRepository.com에서
		// jdom으로 검색! -->버전 2.0.6을 받아서 pom.xml에 의존성 추가
		
		Document doc = builder.build(conn.getInputStream());
		
		//루트엘리먼트 얻기
		Element root = doc.getRootElement();//response라는 루트
		
		//루트의 자식들중 body요소를 얻어낸다.
		Element body = root.getChild("body");
		
		//body안에 있는 items라는 요소를 얻어낸다.
		Element items =body.getChild("items");
		List<Element> list = items.getChildren("item");
		System.out.println(list);
		//위의 list에 저장된 Elemnt를 DataVO로 변환하기 위해 저장소를 준비
		List<DataVO> data_list = new ArrayList<DataVO>();
		for(Element e :list) {
			DataVO dvo = new DataVO();
			String pm10Value = e.getChildText("pm10Value");
			String pm10Grade = e.getChildText("pm10Grade");
			String coValue = e.getChildText("coValue");
			String coGrade = e.getChildText("coGrade");
			String khaiValue = e.getChildText("khaiValue");
			String khaiGrade = e.getChildText("khaiGrade");
			 
			dvo.setPm10Value(pm10Value);
			dvo.setPm10Grade(pm10Grade);
			dvo.setCoValue(coValue);
			dvo.setCoGrade(coGrade); 
			dvo.setKhaiValue(khaiValue);
			dvo.setKhaiGrade(khaiGrade);
			data_list.add(dvo);
		}
		model.addAttribute("data_list", data_list);
		return "home";
	}
	
}
