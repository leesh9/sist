<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   .btn{
      width: 70px;
      height: 20px;
      text-align: center;
      padding: 0px;
   }
   .btn a{
      display: block;
      width: 100%;
      height: 20px;
      padding: 4px;
      line-height: 20px;
      background: #27a;
      color: #fff;
      border-radius: 3px;
      text-decoration: none;
      font-weight: bold;
      font-size: 12px;
   }
   .btn a:hover{
      background: #fff;
      color: #27a;
      border: 1px solid #27a;
   }   
   div#wrap{
      width: 400px;
      margin: 30px auto;
   }
   table th, table td{
      padding: 3px;
   }
   table tbody td>input{
      width: 120px;
      border: 1px solid #27a;
      padding: 4px;
   }
   
   .phone{ width: 50px; }
   .txt_R{ text-align: right; }
   
   .success{
      color: #00f;
      font-weight: bold;
      font-size: 11px;
   }
   .fail{
      color: #f00;
      font-weight: bold;
      font-size: 11px;
   }
   div#box{
      display: inline-block;
      width: 65px;
      height: 20px;
      padding: 0;
      margin: 0;
      margin-left: 3px;
   }
   div#my_win{ display: none; }
</style>
</head>
<body>
   <div id="wrap">
      <form action="" method="post">
         <table>
            <colgroup>
               <col width="100px"/>
               <col width="*"/>
            </colgroup>
            <tbody>
               <tr>
                  <th class="txt_R"><label for="s_id">ID:</label></th>
                  <td>
                     <input type="text" id="s_id" name="id"/>
                     <div id="box"></div>
                  </td>
               </tr>
               <tr>
                  <th class="txt_R"><label for="s_pw">PW:</label></th>
                  <td>
                     <input type="password" id="s_pw" name="pw"/>
                  </td>
               </tr>
               <tr>
                  <th class="txt_R"><label for="s_name">NAME:</label></th>
                  <td>
                     <input type="text" id="s_name" name="name"/>
                  </td>
               </tr>
               <tr>
                  <th class="txt_R"><label for="s_email">EMAIL:</label></th>
                  <td>
                     <input type="text" id="s_email" name="email"/>
                  </td>
               </tr>
               <tr>
                  <th class="txt_R"><label for="s_phone">PHONE:</label></th>
                  <td>
                     <input type="text" id="s_phone" name="phone" class="phone"/>
                     - <input type="text" name="phone" class="phone"/>
                     - <input type="text" name="phone" class="phone"/>
                  </td>
               </tr>
            </tbody>
            <tfoot>
               <tr>
                  <td colspan="2">
                     <p class="btn">
                        <a href="javascript: reg()">등록</a>
                     </p>
                  </td>
               </tr>
               <tr>
               	<td colspan="2" id="res">
               	
               	</td>
               </tr>
            </tfoot>
         </table>
      </form>
   </div>
   <div id="my_win" title="결과">
		ㅁㄴㅇㄻ
	</div>
   
   <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   <script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
   <script type="text/javascript">
   	$(function() {
		//현재문서 안에 아이디가 s_id인 요소에 키보드가 누를때마다
		//수행하는 함수를 이벤트로 적용하자
		$("#s_id").bind("keyup",function(){
			//아이디가 s_id요소의 값을 가져와서 변수 str에 저장
			let str = $("#s_id").val();
			//console.log(str);
			
			//str의 문자열의 길이가 4자 이상일 때만 서버와 통신하자!
			if(str.length>3){
				$.ajax({
					url: "check_id.jsp",
					type: "post",
					data: "m_id="+encodeURIComponent(str),
				}).done(function(data){
					//성공적으로 수행이 끝났을 때
					$("#box").html(data)
				});
			}else{
				$("#box").html("")
			}
		});
		
	});
   	function reg() {
		if($("#box").find("span.success").length>0){
			let m_id = $("#s_id").val();
			let m_pw = $("#s_pw").val();
			let m_name = $("#s_name").val();
			let m_email = $("#s_email").val();
			let m_phone = "";
			let p_list = document.getElementsByName("phone");
			let type="0";
			
			if(m_id.trim().length<1){
				type="아이디를 입력하세요";
				$("#s_id").focus();
			}else if(m_pw.trim().length<1){
				type="비밀번호를 입력하세요";
				$("#s_pw").val("");
				$("#s_pw").focus();
			}else if(m_name.trim().length<1){
				type="이름을 입력하세요";
				$("#s_name").val("");
				$("#s_name").focus();
			}else if(m_email.trim().length<1){
				type="이메일을 입력하세요";
				$("#s_email").val("");
				$("#s_email").focus();
			}else{
				for(let i=0; i<p_list.length;i++){
					if(p_list[i].value.length>0)
						m_phone+=p_list[i].value;
					else{
						type="번호를 다시 입력하세요"
						p_list[i].value="";
						p_list[i].focus();
						break;
					}
				}
			}
			if(type=="0"){
				$.ajax({
					url: "sign.jsp",
					type: "post",
					data: "m_id="+encodeURIComponent(m_id)+
						  "&m_pw="+encodeURIComponent(m_pw)+
						  "&m_name="+encodeURIComponent(m_name)+
						  "&m_email="+encodeURIComponent(m_email)+
						  "&m_phone="+encodeURIComponent(m_phone)
				}).done(function(data){
					$("#my_win").html(data.trim());
					$("#my_win").dialog();
					
				});
			}else{
				$("#my_win").html(type);
				$("#my_win").dialog();
			}
		}
	}
   </script>
   
</body>
</html>
