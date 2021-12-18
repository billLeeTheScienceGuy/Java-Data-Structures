import java.util.Arrays;

/**
 * @author Bill Lee
 * This class tests the functionality of the ClimbingTracker class.
 */
public class ClimbingTrackerTester {
  
  /**
   * Checks whether the sendClimb method works as expected.
   * @return true if method functionality is verified, false otherwise.
   */
  public static boolean testSendClimb()
  {
    String[] send = new String[5];
    int numSend = 0;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V2");
    numSend++;;
    ClimbingTracker.sendClimb(send, numSend, "V3");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "88");
    
    //checks if the contents of the send array are equal to what they should be
    if (Arrays.toString(send).equals("[V0, V0, V2, V3, null]"))
    {
      return true;
    }
    return false;
  }
  
  /**
   * Checks whether the failClimb method works as expected.
   * @return true if method functionality is verified, false otherwise.
   */
  public static boolean testFailClimb()
  {
    String[] fail = new String[5];
    int numFail = 0;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V2");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V3");
    numFail++;
    ClimbingTracker.failClimb(fail,numFail, "88");
    
    //checks if the contents of the fail array are equal to what they should be
    if (Arrays.toString(fail).equals("[V0, V0, V2, V3, null]"))
    {
      return true;
    }
    return false;
  }
  
  /**
   * Checks whether the getStats method works as expected.
   * @return true if method functionality is verified, false otherwise.
   */
  public static boolean testGetStats()
  {
    String[] send = new String[5];
    int numSend = 0;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V2");
    numSend++;
    
    String[] fail = new String[5];
    int numFail = 0;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V2");
    numFail++;
    
    String[] edge = new String[5];
    int numEdge = 0;
    
    //checks if all cases of getStats work and that the output is equal to what it should be
    if (ClimbingTracker.getStats(send, numSend, fail, numFail, 2).equals("send: 1.0" + "\n" + "fail: 1.0"))
      {
      if (ClimbingTracker.getStats(send, numSend, edge, numEdge, 10).equals("send: 0.6666666666666666" + "\n" + "fail: --"))
      {
        return true;
      }
      }
    return false;
  }
  
  /**
   * Checks whether the getHistogram method works as expected.
   * @return true if method functionality is verified, false otherwise.
   */
  public static boolean testGetHistogram()
  {
    String[] send = new String[5];
    int numSend = 0;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V0");
    numSend++;
    ClimbingTracker.sendClimb(send, numSend, "V2");
    numSend++;
    
    String[] fail = new String[5];
    int numFail = 0;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V0");
    numFail++;
    ClimbingTracker.failClimb(fail, numFail, "V2");
    numFail++;
    
    String[] edge = new String[5];
    int numEdge = 0;
    
    //checks if all cases of getHistogram work and that the output is equal to what it should be
    if (ClimbingTracker.getHistogram(send, numSend, fail, numFail).equals("V0: - - + +" + "\n" + "V1:"
    + "\n" + "V2: - +" + "\n"))
      {
        if (ClimbingTracker.getHistogram(send, numSend, edge, numEdge).equals("V0: + +" + "\n" + "V1:" + "\n" + "V2: +" + "\n"))
        {
          return true;
        }
      }
    return false;
  }
  
  /**
   * Checks whether all test methods return true.
   * @return true if all test methods return true, false otherwise.
   */
  public static boolean runAllTests()
  {
    //if all of the test methods succeed then return true
    if (testSendClimb() == true && testFailClimb() == true && testGetStats() == true && testGetHistogram() == true)
    {
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) 
  {
    System.out.println(runAllTests());
  }
}