import java.util.Scanner;

/**
 * Represents the state machine enum of the assignment planner CLI application.
 * @author Bill Lee
 */
public enum AssignmentPlannerState {
  MAIN_MENU {
    public boolean isDone() {
      return false;
    }

    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      System.out.println("\n[1] Add an assignment");
      System.out.println("[2] Complete the earliest assignment");
      System.out.println("[3] Print all assignments");
      System.out.println("[4] Clear all assignments");
      System.out.println("[0] Quit");
      System.out.print("Select an option: ");

      if (scanner.hasNextInt()) {
        int input = scanner.nextInt();
        scanner.nextLine(); 
        switch (input) {
          case 1:
            return ADD_ASSIGNMENT;
          case 2:
            return COMPLETE_ASSIGNMENT;
          case 3:
            return PRINT_ASSIGNMENTS;
          case 4:
            return CLEAR_ASSIGNMENTS;
          case 0:
            return DONE;
          default:
            System.out.println("Invalid input");
            return MAIN_MENU;
        }
      } else {
        System.out.println("Invalid input");
        scanner.nextLine(); 
        return MAIN_MENU;
      }
    }
  },

  DONE {
    public boolean isDone() {
      return true;
    }
    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      return DONE;
    }
  },

  ADD_ASSIGNMENT {
    public boolean isDone() {
      return false;
    }
    public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
      if (queue.size() >= queue.capacity()) {
        System.out.println("Queue is full. Cannot add any more assignments.");
        return MAIN_MENU;
      }
      
      Assignment assignment = null;
      System.out.print("Enter the name of the assignment: ");
      String name = scanner.nextLine();
      System.out.print("Enter the due date in the format MM/DD HH: ");
      String dateStr = scanner.nextLine();

      String[] dates = dateStr.split(" ");
      if (dates.length != 2) {
        System.out.println("Invalid date format");
        return ADD_ASSIGNMENT;
      }

      try { 
        int hour = Integer.parseInt(dates[1]);
        String[] parts = dates[0].split("/");
        if (parts.length != 2) {
          System.out.println("Invalid date format");
          return ADD_ASSIGNMENT;
        }
        int month = Integer.parseInt(parts[0]); 
        int dayOfMonth = Integer.parseInt(parts[1]); 
        assignment = new Assignment(name, month, dayOfMonth, hour);
      } catch (NumberFormatException | RuntimeException e) {
        System.out.println("Invalid Assignment / Date format");
        return ADD_ASSIGNMENT;
      }

      queue.enqueue(assignment);
      return MAIN_MENU;
    }
  },
  
  COMPLETE_ASSIGNMENT {
	  public boolean isDone() {
		  return false;
	  }
	  public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
		  if (queue.isEmpty() == true) {
			  System.out.println("No assignments to complete");
			  return MAIN_MENU;
		  } else {
			  Assignment completed = queue.dequeue();
			  System.out.println("Highest priority assignment completed: " + completed.toString());
			  return MAIN_MENU;
		  }
	  }
  },
  
  PRINT_ASSIGNMENTS {
	  public boolean isDone() {
		  return false;
	  }
	  public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
		  if (queue.isEmpty()) {
			  System.out.println("No assignments to print");
			  return MAIN_MENU;
		  } else {
			  System.out.println(queue.toString());
			  return MAIN_MENU;
		  }
	  }
  },
  
  CLEAR_ASSIGNMENTS {
	  public boolean isDone() {
		  return false;
	  }
	  public AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue) {
		  queue.clear();
		  System.out.println("All assignments cleared");
		  return MAIN_MENU;
	  }
  };

  public abstract boolean isDone();
  public abstract AssignmentPlannerState runState(Scanner scanner, AssignmentQueue queue);
}