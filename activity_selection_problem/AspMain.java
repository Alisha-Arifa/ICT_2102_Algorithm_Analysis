package activity_selection_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AspMain {
	public static void main(String[] args) {
		
		ArrayList<ActivitySelectionProblem> list = new ArrayList<ActivitySelectionProblem>();
		
		int n;
		System.out.println("Enter the array size: ");
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			ActivitySelectionProblem activity = new ActivitySelectionProblem();
			System.out.print("Enter the name for Activity "+ (i+1) + " : ");
			activity.setActivity(sc.nextLine());
			System.out.print("Enter the start time for "+activity.getActivity()+" :");
			activity.setStart(sc.nextInt());
			System.out.print("Enter the finish time forv"+activity.getActivity()+" :");
			activity.setFinish(sc.nextInt());
			sc.nextLine();
			list.add(activity);
			}

		
		Collections.sort(list, new ASPComparator());
		check(list);
	}
	private static void check(ArrayList<ActivitySelectionProblem> list) {
		// TODO Auto-generated method stub
		int last = -1;
		for(ActivitySelectionProblem problem : list) {
			if(problem.getStart()>=last) {
				System.out.println(problem.getActivity());
				last = problem.getFinish();
			}
		}
	}

}