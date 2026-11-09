
/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 7.0
 */
public class LogAnalyzer
{
    public static final int HOURS_PER_DAY = 24;
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public LogAnalyzer(String filename)
    {
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[HOURS_PER_DAY];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts[hour]) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int numberOfAccesses()
    {
        int total = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) {
            total = total + hourCounts[hour];
        }
        return total;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void busiestHour() {
        int busiest = 0;
        int busiestHour = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) {
            int b = hourCounts[hour];
            if (busiest < b) {
                busiest = b;
                busiestHour = hour;
            }
        }
        System.out.println("The busiest hour is: " + busiestHour + " with " + busiest + " accesses.");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void quietestHour() {
        int quietest = 999999;
        int quietestHour = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) {
            int b = hourCounts[hour];
            if (quietest > b) {
                quietest = b;
                quietestHour = hour;
            }
        }
        System.out.println("The quietest hour is: " + quietestHour + " with " + quietest + " accesses.");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void busiest2Hour() {
        int busiest = 0;
        int busiestHour = 0;
        for (int hour = 0; hour < hourCounts.length; hour++) {
            int a = hourCounts[hour];
            int hour2 = hour + 1;
            if (hour2 > 23) {
                hour2 = 0;
            }
            int b = hourCounts[hour2];
            int c = a + b;
            if (busiest < c) {
                busiest = c;
                busiestHour = hour;
            }
        }
        System.out.println("The busiest 2 hour period is: " + busiestHour + " with " + busiest + " accesses.");
    }
}
