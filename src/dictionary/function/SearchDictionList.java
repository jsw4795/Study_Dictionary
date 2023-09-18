package dictionary.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dictionary.dao.DictionaryDAO;
import dictionary.dao.secret.SecretCodeGenerator;
import dictionary.vo.DictionVO;

public class SearchDictionList {
	private DictionaryDAO dao = new DictionaryDAO();
	private SecretCodeGenerator scg = new SecretCodeGenerator();
	private BufferedReader br = null;
	private int maxIndex = 0; // 가지고있는 DICTION의 개수 (숫자 입력받을 때 범위 지정)
	private int index = 0; // D_ID
	private List<DictionVO> list = new ArrayList<DictionVO>(); // DictionVO 여러개를 담을 list

	public List<DictionVO> getList(String id) {
		br = new BufferedReader(new InputStreamReader(System.in));
		list = dao.dictionSelectAll();
		list.sort(Collections.reverseOrder()); // 열람 등급이 낮은 순으로 정렬
		
		return list;
		
		//index = getIndex();
		
		//showDiction(id);
		
	}

	
	public boolean showDiction(List<DictionVO> list, String id, int index) {
		String path = dao.dataFileSelect(list.get(index-1).getD_id()).getFileName();
		char grade = dao.dictionSelect(list.get(index-1).getD_id()).getGrade().charAt(0);
		char userGrade = dao.scoreSelect(id).getGrade().charAt(0);

		System.out.println();

		if (userGrade <= grade) {
			System.out.println("================================================================");
			scg.decodeFile(path);
			System.out.println("================================================================");
			return true;
		}
		else {
			System.out.println("열람할 수 없는 등급입니다."); 
			System.out.println("등급에 맞는 번호를 입력해주세요. [현재 등급 : \"" + userGrade + "\"]\n");
			return false;
		}

	}


}
