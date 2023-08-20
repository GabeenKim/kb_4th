package broker.twotier.test;

import java.sql.SQLException;
import java.util.ArrayList;

import broker.twotier.dao.Database;
import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;

public class DatabaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, DuplicateSSNException, RecordNotFoundException {
		Database db = new Database("127.0.0.1");
//		try {
//			db.addCustomer(new CustomerRec("888-888","Gabeen","인천"));
//			db.deleteCustomer("888-888");
			
//			ArrayList<SharesRec> sr = db.getPortfolio("111-111");
//			for(SharesRec s : sr) System.out.println(s);
//			
			
//		}catch (DuplicateSSNException e){
			
//		}catch (RecordNotFoundException e){
			
//		}
	}

}
