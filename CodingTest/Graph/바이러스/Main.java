package 바이러스;

import java.io.*;
import java.util.*;

public class Main {

	public static boolean visited[];
	public static ArrayList<Integer> arrayList[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int vertexNum = Integer.parseInt(br.readLine());
		int edgeNum = Integer.parseInt(br.readLine());
		arrayList = new ArrayList[vertexNum+1];
		visited = new boolean[vertexNum+1];
		
		for(int i=1;i<=vertexNum;i++) {
			arrayList[i] = new ArrayList();
		}
		for(int i=0;i<edgeNum;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arrayList[a].add(b);
			arrayList[b].add(a);
		}
		dfs(1);
		int count = 0;
		for(boolean b : visited) {
			if(b == true) {
				count++;
			}
		}
		System.out.println(count-1);
	}
	public static void dfs(int n) {
		visited[n] = true;
		for(int i=0;i<arrayList[n].size();i++) {
			int nowVertex = arrayList[n].get(i);
			if(visited[nowVertex] == false) {
				visited[nowVertex] = true;
				dfs(nowVertex);
			}
		}
	}

}
