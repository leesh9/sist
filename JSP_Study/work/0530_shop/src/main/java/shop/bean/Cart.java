package shop.bean;
import java.util.ArrayList;
import java.util.List;

import mybatis.vo.ProductVO;

public class Cart {
/*
 	카트(장바구니)의 기능분석
 	  1) 제품(ProductVO)을 저장할 수 있는 공간: List<productVO>
 	  2) 1)에서 제품을 검색하는 기능(저장할 떄도 필요한 기능)
 	  3) 1)에 제품을 저장하는 기능
	  4) 1)에서 제품을 삭제하는 기능
	  5) 2)에서 검색한 제품의 수량을 변경하는 기능
	  6) 1)에 저장된 모든 제품들의 총액 계산하는 기능
	  7) 1)에 저장된 모든 제품들을 배열로 반환하는 기능

	위 분석에 따른 장바구니에 속성(맴버변수)
	 - List<ProductVO>
	 - int 또는 long totalPrice //JSP에서 해도 될것 같다

	장바구니의 기능 (맴버메서드) 정의(명칭)
	 - searchProduct() : 제품을 검색하는 기능
	 - addProduct() : 제품을 저장하는 기능
	 - delProduct() : 제품을 삭제하는 기능
	 - changeCount() : 제품의 수량을 변경하는 기능
	 - getTotalPrice() : 저장된 모든 제품들의 총액을 계산하는 기능
	 - getList() : 저장된 모든 제품들을 배열로 반환하는 기능
*/
	
	private List<ProductVO> list;
	private int totalPrice;

	public Cart() {// 생성자 - useBean정의시 자동 호출됨!
		list = new ArrayList<ProductVO>();
	}

	//장바구니의 저장소(list)에서 특정 제품(ProductVO)를 검색하는 기능
	public ProductVO searchProduct(String p_num) {
		ProductVO vo = null;
		for(ProductVO pvo : list) {
			if(pvo.getP_num().equals(p_num)) {
				//찾은 경우는 pvo를 vo에 저장한 후 반복문 탈출
				vo = pvo;
				break;
			}
		}
		return vo;
	}
	//장바구니에 있는 모든 제품들을 배열로 반환하는 기능
	public ProductVO[] getList() {
		ProductVO[] ar = null;
		if (list.size()>0) {
			ar = new ProductVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}

	//진열대에서 제품을 하나 얻어내에 장바구니에 저장하는 기능
	public void addProduct(ProductVO pvo) {
		list.add(pvo);
	}
	public void addProduct(ShopBean sb, String p_num) {
		// 먼저 이미 장바구니에 있는 제품인지? 검색을 먼저 하자!
		ProductVO vo = searchProduct(p_num);

		//vo가 null이면 장바구니에 저장되지 않은 제품이고,
		//vo가 null이 아니면 이미 장바구니에 저장된 제품이다.
		//이미 저장된 제품은 수량만 1증가하자
		if(vo != null) {
			vo.setQuant(vo.getQuant()+1);//저장된 수량을 얻어내어 1을더한다.
			return;//제어권 반환
		}
		//====================장바구니에 제품이 없는경우=========================
		//인자로 넘어온 pnum을 ShopBean에게 줘서
		//해당 제품(ProductVO)을 얻어낸다
		sb.setP_num(p_num);
		vo=sb.getProduct();

		vo.setQuant(1);
		//얻어낸 제품을 장바구니에 저장한다.
		list.add(vo);
	}
	//장바구니에서 특정 제품을 검색하여 삭제하는 기능
	public boolean delProduct(String p_num) {
		boolean value = false;

		//장바구니에서 검색
		ProductVO vo = searchProduct(p_num);
		if (vo != null) {
			value=list.remove(vo);

		}

		return value;

	}

	//장바구니에서 원하는 제품을 검색한 후 수량만 변경하는 기능
	public void changeCount(String pnum, int q) {
		ProductVO vo = searchProduct(pnum);
		if(vo != null) {
			vo.setQuant(q);
		}
	}

}












