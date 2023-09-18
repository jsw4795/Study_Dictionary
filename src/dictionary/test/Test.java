package dictionary.test;

import java.util.List;

import dictionary.dao.DictionaryDAO;
import dictionary.dao.secret.SecretCodeGenerator;
import dictionary.vo.TestVO;

public class Test {

	public static void main(String[] args) {
		DictionaryDAO dao = new DictionaryDAO();
		SecretCodeGenerator scg = new SecretCodeGenerator();
		
		List<TestVO> list = dao.testSelectAll();	
		
		for(TestVO vo : list) {
			System.out.println(vo);
			scg.decodeFile(vo.getQuest());
		}

	}

}
