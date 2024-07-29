package com.sist.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Member;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.vo.MemberVO;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login/kakao")
	public ModelAndView login(String code) {
		ModelAndView mv = new ModelAndView();
		//인자는 카카오 서버로 부터 받는 값이다.
		
		//받은 인증 코드를 가지고 2번째 카카오서버와 통신을 하기 위해
		// 토큰을 요청하여 받아야 한다.
		String access_token = "";
		String refresh_token = "";
		
		String reqUrl ="https://kauth.kakao.com/oauth/token";
		
		try {
			 URL url = new URL(reqUrl);
		     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        
		     //필수 헤더 세팅
		     conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		     conn.setRequestMethod("POST");
		     conn.setDoOutput(true); //OutputStream으로 POST 데이터를 넘겨주겠다는 옵션.
		     
		     //전달하고자 하는 파라미터들을 보낼 OutputStream생성!
		     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream())); 
		     //카카오API문서에 있는 4개의 파라미터들을 정의하기 위해 문자열 편집이 필요함!
		     // 예) grant_type = authorization_code
		     StringBuffer sb = new StringBuffer();
		     
		     sb.append("grant_type=authorization_code");
		     sb.append("&client_id=adab169f407acde428c3ca3913d7af32");
		     sb.append("&redirect_uri=http://localhost:8080/app/login/kakao");
		     sb.append("&code=");
		     sb.append(code);
		     
		     bw.write(sb.toString());
		     bw.flush();
		     
		     //카카오서버에 요청을 보낸 후 응답결과가 성공적인 경우(200)에만
		     //토큰들을 받아내야 한다.
		     int res_code = conn.getResponseCode();
		     
		     if (res_code == 200) {
				//요청을 통해 얻은 JSON타입의 결과 메시지를 읽어온다.
		    	 BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    	 
		    	 StringBuffer result = new StringBuffer();
		    	 String line = null;
		    	 //한줄 단위로 읽어서 result라는 StringBuffer에 적재한다.
		    	 
		    	 while ((line=br.readLine())!=null) {
					result.append(line);	
				}
//		    	 System.out.println(result.toString());
		    	// JSON파싱 처리: "access_token"과
			     // "refresh_token"을 찾아내어 값을 얻어내야 한다.
		    	 JSONParser pars = new JSONParser();
		    	 //위 객체는 mvnrepository에서 json-simple로 검색하여
		    	 // 첫번째로 나오는 구글의 라이브러리를 얻었다.
		    	 // 이 파서를 통해 문자열로 되어 있는 json 
		    	 
		    	 Object obj = pars.parse(result.toString());
		    	 JSONObject json = (JSONObject)obj;
		    	 access_token = (String)json.get("access_token");
		    	 refresh_token = (String)json.get("refresh_token");
		    	 //이제 받은 토큰을 가지고 마지막 3번째 호출인
		    	 // [사용자 정보를 요청]해야 한다.
		    	 String apiURL = "https://kapi.kakao.com/v2/user/me";
		    	 String header = "Bearer "+access_token;
		    	 
		    	 URL url2 = new URL(apiURL);
		    	 
		    	 HttpURLConnection conn2 = (HttpURLConnection)url2.openConnection();
		    	 
		    	 conn2.setDoOutput(true);
		    	 conn2.setRequestProperty("Authorization", header);
		    	 conn2.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		    	 
		    	 res_code = conn2.getResponseCode();
		    	 if (res_code==200) {
		    		 BufferedReader brdm = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
			    	 
			    	 StringBuffer res = new StringBuffer();
			    	 String str = null;
			    	 //한줄 단위로 읽어서 result라는 StringBuffer에 적재한다.
			    	 
			    	 while ((str=brdm.readLine())!=null) {
						res.append(str);	
					}
			    	 System.out.println(res.toString());
			    	 
			    	 JSONObject data = (JSONObject) pars.parse(res.toString());
			    	 String id = String.valueOf(data.get("id")); // Convert Long to String
			    	 JSONObject properties = (JSONObject) data.get("properties");
			    	 String nickname = (String) properties.get("nickname");
			    	 String profile_image = (String) properties.get("profile_image");
			    	 System.out.println(id + "/" + nickname + "/" + profile_image);
			    	 
			    	 
			    	 MemberVO mvo = new MemberVO();
			    	 mvo.setNickName(nickname);
			    	 mvo.setP_img(profile_image);
			    	 
			    	 //이렇게 카카오에서 정보를 mvo에 저장을 시킨 후
			    	 // ModelAndView에 저장하자!
			    	 mv.addObject("mvo",mvo);
			    	 mv.setViewName("reg2");
				}
			}
		     
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mv;
	}
}
