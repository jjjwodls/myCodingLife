package programmersAlgo;

import java.util.*;

/**
 * 단속카메라 
 * 
 * 문제 설명 
 * 
 * 고속도로를 이동하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 합니다.
 * 
 * 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의
 * 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * 
 * 차량의 대수는 1대 이상 10,000대 이하입니다. 
 * routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, 
 * routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다. 
 * 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다. 
 * 
 * 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.
 * 
 * 입출력 예
 * 
 * routes return 
 * [[-20,15], [-14,-5], [-18,-13], [-5,-3]] 2 
 * 
 * 입출력 예 설명
 * -5 지점에 카메라를 설치하면 두 번째, 네 번째 차량이 카메라를 만납니다.
 * -15 지점에 카메라를 설치하면 첫 번째, 세 번째 차량이 카메라를 만납니다.
 * 
 * @author jjjwodls
 *
 */
public class Greedy6_SpeedCamera {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		//int[][] routes = {{-20,-10}, {-19,-18}, {-18,-17}, {-17,-13}, {-9,-8}};
		//int[][] routes = {{-20,-10}, {-19,-18}, {-18,-17}, {-17,-13}, {-9,-8}};
		
		Greedy6_SpeedCamera camera = new Greedy6_SpeedCamera();
		System.out.println(camera.solution(routes));
	}	

	public int solution(int[][] routes) {
		int answer = 1;

		Arrays.sort(routes,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int [] compare = routes[0];
		int cameraPosition = compare[1];
		for(int i = 1; i < routes.length ; i++) {
			if(cameraPosition > routes[i][1]) {
				cameraPosition = routes[i][1];
			}
			
			if(cameraPosition < routes[i][0]) {
				answer++;
				cameraPosition = routes[i][1];
			}
		}
		
		return answer;
	}

}