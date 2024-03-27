import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s2480();
	
	}
	public void s2480()throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String [] nums=br.readLine().split(" ");
		Map<String,Integer> map = new HashMap<>();
		int answer=0;
		
		for (int i = 0; i < nums.length; i++) 
			checkCount(nums[i],map);
		
		int[] cnn= checkCount(map);
		int count=cnn[0];
		int num=cnn[1];
		
		if(count==3)
			answer=10000+(num*1000);
		else if(count ==2 )
			answer=1000+(num*100);
		else
			answer=num*100;
		
		System.out.println(answer);
	}
	
	public int[] checkCount(Map<String,Integer> map) {
		int[] cnn=new int[2];
		Iterator<String> keys= map.keySet().iterator();
		int num=0;
		int max=0;
		int count=0;
		while(keys.hasNext()) {
			String key=keys.next();
			if(count<=map.get(key)) {
				count=map.get(key);
				num=Integer.valueOf(key);
				max= max<num?num:max;
			}
		}
		cnn[0]=count;
		cnn[1]=max;
		return cnn;
	}
	
	public Map<String, Integer> checkCount(String num, Map<String, Integer> map) {
		if(map.containsKey(num)) {
			map.put(num, map.get(num)+1);
		}else {
			map.put(num, 1);
		}
		return map;
	}
}