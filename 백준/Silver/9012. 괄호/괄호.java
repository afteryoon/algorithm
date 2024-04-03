
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
	
	/*
	 * 1. )가 더 많으면 성립하지 않는다.
	 * 2. 개수가 같고 시작이 "( "끝점이 ")" 라면 성립한다
	 */
	static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n의 개수
		int n= Integer.parseInt(br.readLine());
		
		for (int i = 0; i <n; i++) {
			//pvs를 판별하는 메서드 호출
			String state=(checkPvs(br.readLine())?"YES":"NO" );
			sb.append(state).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	//입력 받은 값을 매개변수로 boolean을 return 하는 메서드
	public static boolean checkPvs(String vps) {
		//'('를 체크하는 left 와 )를 체크하는 right
		int left=0;
		int right=0;
		//조건절이 너무 길어져 빼놓은 vps의 마지막 char index가 담긴 변수
		int vpsL=vps.length()-1;
		
		//길이만큼 반복하여 개수를 체크
		for (int j = 0; j < vps.length(); j++) {
			if(vps.charAt(j)=='(')
				left++;
			else
				right++;
			
			//)가 더 많은 순간이 오면 성립하지 않기에 false return
			if(right>left) 
				return false;
			
		}
		
		//개수가 같으면서 시작점과 끝점을 확인 후 결과값 return
		return( left==right && vps.charAt(0)=='(' && vps.charAt(vpsL)==')' );
	}
	
}
