import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AssignmentSimhwa {
	public static void main(String[] args) {
		Random rnd = new Random();
		int auth = rnd.nextInt(4); // 프로젝트 권한 1~4 (1:creator, 2:admin, 3:member, 4:viewer) ->> 개인프로젝트의 권한설정으로
											// 사용했습니다.

		// Collection version

		Map<Integer, String> authMap = new HashMap<>();
		authMap.put(1, "CREATOR");
		authMap.put(2, "ADMIN");
		authMap.put(3, "MEMBER");
		authMap.put(4, "VIEWER");

		System.out.println("Your Authority is : " + authMap.get(auth));

		// Switch version
		String authStr = null;
		switch (auth) {
		case 1:
			authStr = "CREATOR";
			break;
		case 2:
			authStr = "ADMIN";
			break;
		case 3:
			authStr = "MEMBER";
			break;
		case 4:
			authStr = "VIEWER";
			break;
		default:
			break;
		}
		System.out.println("Switch Version of Auth ->> Your Authority is : " + authStr);
	}
}
