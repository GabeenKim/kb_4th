package spring.service.hello.dao.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;

public class DAOTestApp04UsingSpring {

	public static void main(String[] args) {
		//MemberDAOImpl를 직접 여기서 생성하면은... 재사용성이 떨어진다. 
		//직접 연결 되어져 있다는 것은 Coupling이 Tight하다는 의미 
		//결합도를 아예 없애는 방법이 바로 DI Container = BeanFactory를 사용하는 것!
		/*
		 	내가 주문서를 작성하면 
		 	DI Container가 주문서대로 객체를 생성
		 	여기서 DIContainer에서 생성 후 저장된 객체를 받아서 사용하면 된다. 
		 	getBean()사용 
		*/
		
		//1. 주문서를 읽어들임과 동시에 공장을 생성 
		BeanFactory factory = new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );
		
		//2. 공장에서 저장하고 있는 dao bean을 찾아온다....사용하기 위해서(호출)
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		
		//3. 빈의 기능을 호출 
		dao.register("kblife", "김국민", "선릉");
		dao.delete("haha0071");
		
	}

}
