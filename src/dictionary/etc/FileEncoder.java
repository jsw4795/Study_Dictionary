package dictionary.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dictionary.dao.DictionaryDAO;
import dictionary.dao.secret.SecretCodeGenerator;
import dictionary.vo.DatafileVO;
import dictionary.vo.TestVO;

public class FileEncoder {
	// 실행하면 DB에 있는 모든 파일 암호화
	public static void main(String[] args) {
		DictionaryDAO dao = new DictionaryDAO();
		SecretCodeGenerator scg = new SecretCodeGenerator();
		
//		List<DatafileVO> list = dao.dataFileSelectAll();
//		for(DatafileVO temp : list) {
//			scg.encodeFile(temp.getFileName());
//		}
		
//		List<TestVO> list = dao.testSelectAll();
//		for(TestVO temp : list) {
//			scg.encodeFile(temp.getQuest());
//		}
		
//		scg.encodeFile("./files/quest/Java3.txt");
//		scg.encodeFile("./files/quest/DB13.txt");
//		scg.encodeFile("./files/quest/DB14.txt");
		scg.encodeFile("./files/quest/Java28.txt");

	}

}
