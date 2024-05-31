package test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.Session;

public class Main_Ex1 {

	public static void main(String[] args) throws Exception {
		Reader r = Resources.getResourceAsReader("test/config.xml");
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(r);
		r.close();
		
		SqlSession ss = factory.openSession();
		
		System.out.println("도시 :");
		Scanner scan = new Scanner(System.in);
		String city=scan.nextLine();
		List<LocVO> list = ss.selectList("search_city",city);
		
		for(int i = 0;i<list.size();i++) {
			LocVO vo = list.get(i);
			System.out.println(vo.city);
		}
	}

}
