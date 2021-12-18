/**
 * @author Bill Lee
 * This class tracks a person's climbs and calculates relevant statistics and data to display how well the person is doing.
 */
public class ClimbingTracker 
{
  /**
   * The sendClimb method adds a new successful climb to the end of the array of successful climbs.
   * @param send is the array that the climbing grade will be added to the end of.
   * @param numSend is the current size of the send array.
   * @param grade is the rating of the climb being added. Should be formatted with a capital 'V' followed
   * by a number 0-7. For example: "V3" would be a valid grade.
   * @return the current size of the array.
   */
  public static int sendClimb(String[] send, int numSend, String grade)
  {
    //Checks to make sure grade is formatted correctly and then adds grade to the array if it is
    if (grade.charAt(0) == 'V')
    {
      if (grade.length() == 2)
      {
        if (Character.isDigit(grade.charAt(1)) == true)
        {
          send[numSend] = grade;
          numSend++;
        }
      }
    }
    return numSend;
  }
  /**
   * The failClimb method adds a new failed climb to the end of the array of failed climbs.
   * @param fail is the array that the climbing grade will be added to the end of.
   * @param numFail is the current size of the fail array.
   * @param grade is the rating of the climb being added. Should be formatted with a capital 'V' followed
   * by a number 0-7. For example: "V3" would be a valid grade.
   * @return the current size of the array.
   */
  public static int failClimb(String[] fail, int numFail, String grade)
  {
    //Checks to make sure grade is formatted correctly and then adds grade to the array if it is
    if (grade.charAt(0) == 'V')
    {
      if (grade.length() == 2)
      {
        if (Character.isDigit(grade.charAt(1)) == true)
        {
          fail[numFail] = grade;
          numFail++;
        }
      }
    }
    return numFail;
  }
  /**
   * The getStats method displays the average of the most recent successful climbs and the average of the most
   * recent failed climbs based on historyLength.
   * @param send is the array of successful climbs.
   * @param numSend is the current size of send array.
   * @param fail is the array of failed climbs
   * @param numFail is the current size of fail array.
   * @param historyLength is how many of the most recent climbs the person wants to take the average of.
   * @return a formatted string displaying the average grade of successful climbs and the average grade of failed climbs.
   */
  public static String getStats(String[] send, int numSend,String[] fail, int numFail, int historyLength)
  {
    String stats = "";
    String temp = "";
    double x = 0.0;
    double y = 0.0;
    //temporarily holds the original value of historyLength
    int tempHolder = historyLength;
    //if the size of the send array is less than or equal to zero the appropriate error is added to the stats string
    if (numSend <= 0)
    {
      stats = stats + "send: --";
    }
    //if historyLength is less than or equal to zero the appropriate errors are added to the stats string
    if (historyLength <= 0)
    {
      stats = "send: --" + "\n" + "fail: --";
    }
    if (historyLength > numSend)
    {
      historyLength = numSend;
    }
    //general case for send array. Calculates the average using a for loop and adds value to the stats string
    if (numSend > 0)
    {
      for (int i = numSend - historyLength; i < numSend; i++)
      {
        temp = send[i];
        x += Integer.parseInt(temp.substring(1));
      }
      x = x/historyLength;
      stats = stats + "send: " + x;
      historyLength = tempHolder;
    }
    //If the size of the fail array is less than or equal to zero the appropriate error is added to the stats string
    if (numFail <= 0)
    {
      stats = stats + "\n" + "fail: --";
    }
    if (historyLength > numFail)
    {
      historyLength = numFail;
    }
    //general case for fail array. Calculates the average using a for loop and adds value to the stats string
    if (numFail > 0)
    {
      for (int i = numFail - historyLength; i < numFail; i++)
      {
        temp = fail[i];
        y += Integer.parseInt(temp.substring(1));
      }
      y = y/historyLength;
      stats = stats + "\n" + "fail: " + y;
      historyLength = tempHolder;
    }
    return stats;
  }
  /**
   * The getHistogram method displays a histogram containing data from all climbs recorded in both arrays.
   * The data is displayed with one grade per line with each grade followed a '-' for ever fail and a '+'
   * for every success. For example: "V0: - - +
   * V1: +"
   * @param send is the array of successful climbs.
   * @param numSend is the current size of the send array.
   * @param fail is the array of failed climbs.
   * @param numFail is the current size of the fail array.
   * @return a formatted string displaying a histogram of each grade using '-' for fail and '+'
   * for success.
   */
  public static String getHistogram(String[] send, int numSend, String[]fail, int numFail)
  {
    int max = 0;
    String histogram = "";
    //if both arrays are length 0, then no data to display
    if (numSend == 0 && numFail == 0)
    {
      return "Error: no data to display";
    }
    //if a grade in send array is higher than the current max, the max is updated to the new highest grade
    for (int i = 0; i < numSend; i++)
    {
      if (Integer.parseInt(send[i].substring(1)) > max)
      {
        max = i;
      }
    }
    //if a grade in the fail array is higher than the current max, the max is updated to the new highest grade
    for (int w = 0; w < numFail; w++)
    {
      if (Integer.parseInt(fail[w].substring(1)) > max)
      {
        max = w;
      }
    }
    //adds a new line after every grade
    for (int i = 0; i < max + 1; i++)
    {
        histogram = histogram + "V" + i + ":";
        //adds a '-' to the end of the grade for every fail
        for (int k = 0; k < numFail; k++)
        {
          if (Integer.parseInt(fail[k].substring(1)) == i)
          {
            histogram = histogram + " -";
          }
        }
        //adds a '+' to the end of the grade for every success
        for (int k = 0; k < numSend; k++)
        {
          if (Integer.parseInt(send[k].substring(1)) == i)
          {
            histogram = histogram + " +";
          }
        }
        histogram = histogram + "\n";
      }
    return histogram;
    }
  }