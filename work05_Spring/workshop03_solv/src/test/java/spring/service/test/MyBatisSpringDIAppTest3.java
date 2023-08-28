package spring.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisSpringDIAppTest3 {
	@Test
	public void unit() throws Exception{
		ApplicationContext context =
                new ClassPathXmlApplicationContext(
                                new String[] {    "/bean/memberservice.xml"     }); //설정 문서 읽어들임

		// <bean id="memberServiceImpl" calss=..이런것을 어노테이션을 해줬기 때문에 아이디 컨벤션이 자동으로 memberServiceImpl 이렇게 된다. 주의!!!!!!!!
        MemberService service = (MemberService)context.getBean("memberServiceImpl");  
        MemberDAO dao = (MemberDAO)context.getBean("memberDAOImpl");
          MemberVO member = new MemberVO("101", "101", "101", "101");

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        //지금 service에는 select만 있기 때문에 DAO를 찾아와서 해야함....따라서 service에 기능을 다 넣기도 함. (셀렉트만 넣는게 맞지만 추후 귀찮아짐... DAO를 받아와서 호출해야 한다는 단점이 존재)
        System.out.println(":: 1. register(INSERT)  ? ");
        dao.registerMember(member);
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
    
        member = service.getMember(member.getId());
        System.out.println(":: 2. get(SELECT)  ? "+member);
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        member.setName("아이유");
        System.out.println(":: 3. update(UPDATE)  ? ");
        dao.updateMember(member);

        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        member = service.getMember(member.getId());
        System.out.println(":: 4. get(SELECT)  ? "+member);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        System.out.println(":: 5. all User(SELECT)  ? ");
        List<MemberVO> list = service.showAllMember();
        for (int i =0 ;  i < list.size() ; i++) {
            System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
            System.out.println( list.get(i).toString() );
        }
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
     
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(":: 7. remove(DELETE)  ? "+dao.deleteMember(member.getId()));
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	}
}
