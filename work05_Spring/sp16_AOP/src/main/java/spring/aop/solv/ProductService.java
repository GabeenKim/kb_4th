package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//핵심 관심사만 들어 있킄 클래스 
// Target Class... 
public class ProductService {
	
    public String deleteProduct(String id) {
        System.out.println(id+" :: deleteProduct..logic..삭제 성공"); //Cross-Cutting-Concern   
        return "삭제된 상품 ID :"+id;
    }
}
