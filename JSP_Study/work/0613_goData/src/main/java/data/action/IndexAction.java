package data.action;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import data.vo.ItemVO;

public class IndexAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 공공데이터 경로
		String path ="http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?serviceKey=j04BJITj7IitA7PSblWH85CqGilLG0%2B3t2iZJLHr0CAELhJX%2FkI3%2BrAjNvw%2FzhVomFvYNL3IzD52IuJ3BhuoAA%3D%3D&pageNo=1&numOfRows=10&zcode=11";
		
		//위의 경로를 가지고 URL객체 생성
		URL url = new URL(path);
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		//받을 자원이 xml문서임을 증명하기 위해 mimeType을 설정한다.
		conn.setRequestProperty("Content-Type", "application/xml");
		conn.connect();
				
		// 이제 JDOM파서를 이용하여 요청의 결과 즉, 웅덥우ㅏ 냐용을
		// xml문서 객체로 얻어내야 한다.
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(conn.getInputStream());
		
		//문서 객체에서 루트 요소를 얻어내야 한다.
		Element root = doc.getRootElement();
		
		//루트의 자식들 중 body를 얻어낸다.
		Element body = root.getChild("body");
		
		//body안에 있는 items라는 요소를 얻어내자
		Element items = body.getChild("items");
		
		//items안에 있는 자식요소들 중 item들을 얻어내자
		List<Element> list = items.getChildren("item");
		
		//위의 list를 배열화 시키기 위해 배열을 준비
		ItemVO[] ar = null;
		if(list != null && list.size()>0) {
			ar = new ItemVO[list.size()];
		}
		int i=0;
		for(Element e : list) {
			//e는 곧 items에 있는 item요소다.
			String statNm = e.getChildText("statNm");
			String chagerType = e.getChildText("chgerType");
			String addr = e.getChildText("addr");
			String lat = e.getChildText("lat");
			String lng = e.getChildText("lng");
			String useTime = e.getChildText("useTime");

			ItemVO ivo = new ItemVO();
			ivo.setAddr(addr);
			ivo.setChagerType(chagerType);
			ivo.setLat(lat);
			ivo.setLng(lng);
			ivo.setStatNm(statNm);
			ivo.setUseTime(useTime);
			ar[i] = ivo;
			i++;
		}//for의 끝
		request.setAttribute("ar", ar);
		return "index.jsp";
	}

}
