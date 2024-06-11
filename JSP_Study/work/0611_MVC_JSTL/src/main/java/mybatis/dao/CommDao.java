package mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.CommVO;

public class CommDao {
    public static int add(CommVO cvo){
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.insert("comm.add", cvo);
        if(cnt > 0) 
            ss.commit();
        else
            ss.rollback();
        ss.close();
        return cnt;
    }
}
