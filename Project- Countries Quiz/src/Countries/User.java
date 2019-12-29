package Countries;
/*
 * User.java
 * <pre>
 *   Project     <b>CountriesGUI Database</b>
 *   Description This class providing User database
 *   Platform    Java(TM) SE Runtime Environment 1.8.0_151
 *   System      Windows 10 version 
 *   Course      <i>CS 142 Winter 2018</i>
 * </pre>
 *
 * @author:	Sanyapoom Sirijirakarn and Quynh Duc Vu
 * @version: 	1.00
 */
public class User {
    private String name;
    private int firstScore;
    private int secondScore;
    private int thirdScore;
    /*
     * Method: User()
     * Description: This is a default constructor for Country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public User()
    {
        name = "";
        firstScore = 0;
        secondScore = 0;
        thirdScore = 0;
    }
    /*
     * Method: User(String name, int firstScore, int secondScore, int thirdScore)
     * Description: This is a overload constructor for Country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public User(String name, int firstScore, int secondScore, int thirdScore)
    {
        this.name = name;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.thirdScore = thirdScore;
    }
    /*
     * Method: getName()
     * Description: This is getter for name
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return name
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public String getName() {
        return name;
    }
    /*
     * Method: setName(String name)
     * Description: This is setter for name
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem name
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setName(String name) {
        this.name = name;
    }
    /*
     * Method: getFirstScore()
     * Description: This is getter for first score
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return firstScore
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public int getFirstScore() {
        return firstScore;
    }
    /*
     * Method: setFirstScore(int firstScore)
     * Description: This is setter for firstScore
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem firstScore
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }
    /*
     * Method: getSecondScore()
     * Description: This is getter for secondScore
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return secondScore
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public int getSecondScore() {
        return secondScore;
    }
    /*
     * Method: setSecondScore(int secondScore)
     * Description: This is setter for secondScore
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem secondScore
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }
    /*
     * Method: getThirdScore()
     * Description: This is getter for thirdScore
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem void
     * @return thirdScore
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public int getThirdScore() {
        return thirdScore;
    }
    /*
     * Method: setThirdScore(int thirdScore)
     * Description: This is setter for thirdScore
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/15/2018
     * @parem thirdScore
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setThirdScore(int thirdScore) {
        this.thirdScore = thirdScore;
    }
}
