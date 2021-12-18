import java.util.Scanner;

/**
 * Driver class which allows the user to interactively modify and view the contents of an AssignmentQueue.
 * @author Bill Lee
 */
public class AssignmentPlanner {
  
  private static final String WELCOME_MSG= "========================================================\n"+
                                           "               Assignment Planner (v1.0)                \n"+
                                           "========================================================\n";
  
  public static void main(String[] args) {
    System.out.println(WELCOME_MSG);
    AssignmentPlannerState state = AssignmentPlannerState.MAIN_MENU;
    AssignmentQueue queue = new AssignmentQueue(10);
    Scanner scanner = new Scanner(System.in);

    while (!state.isDone()) {
      state = state.runState(scanner, queue);
    }
    scanner.close();
  }
}