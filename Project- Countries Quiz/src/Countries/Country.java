package Countries;

import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Country.java
 * <pre>
 *   Project     <b>CountriesGUI Database</b>
 *   Description This class providing country database
 *   Platform    Java(TM) SE Runtime Environment 1.8.0_151
 *   System      Windows 10 version 
 *   Course      <i>CS 142 Winter 2018</i>
 * </pre>
 *
 * @author:	Sanyapoom Sirijirakarn and Quynh Duc Vu
 * @version: 	1.00
 */
public class Country
{

    private String name;
    private float countryPop;
    private String capital;
    private float capitalPop;
    private Integer size;
    private String location;
    private String language;
    private String river;
    private String flagName;
    //private ImageIcon  flag;
    ImageIcon flag;
    
    //default constructor
    /*
     * Method: Country()
     * Description: This is a default constructor for Country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 1/30/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public Country()
    {
        name = "";
        countryPop = 0;
        capital = "";
        capitalPop = 0;
        size = 0;
        location = "";
        language = "";
        river = "";
        flag = null;
        flagName = "";
    }
    /*
     * Method: Country(String name, float countryPop, String capital, float capitalPop, Integer size, 
                String location, String language, String river, String flag , String flagName)
     * Description: This is an overload constructor for Country
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem name,  capital,  size,  location,  language,  river, flag, flagName
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public Country(String name, float countryPop, String capital, 
            float capitalPop, Integer size, String location, String language, 
            String river, ImageIcon flag, String flagName)
    {
        this.name = name;
        this.countryPop = countryPop;
        this.capital = capital;
        this.capitalPop = capitalPop;
        this.size = size;
        this.location = location;
        this.language = language;
        this.river = river;
        this.flag = flag;
        this.flagName = flagName;
    }
    /*
     * Method: Country(Country anotherCountry)
     * Description: This is an overloaded copy constructor
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem anotherOpera
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public Country(Country anotherCountry)
    {
        name = anotherCountry.name;
        countryPop = anotherCountry.countryPop;
        capital = anotherCountry.capital;
        capitalPop = anotherCountry.capitalPop;
        size = anotherCountry.size;
        location = anotherCountry.location;
        language = anotherCountry.language;
        river = anotherCountry.river;
        flag = anotherCountry.flag;
    }
    /*
     * Method: getName()
     * Description: This is getter for name
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
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
     * Date: 2/9/2018
     * @parem name
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setName(String name) {
        this.name = name;
    }
    /*
     * Method: getCountryPop()
     * Description: This is getter for countryPop
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return countryPop
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public float getCountryPop()
    {
        return countryPop;
    }
    /*
     * Method: setCountryPop(float countryPop)
     * Description: This is setter for countryPop
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem countryPop
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setCountryPop(float countryPop)
    {
        this.countryPop = countryPop;
    }
    /*
     * Method: getCapital()
     * Description: This is getter for capital
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return capital
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0 
     */ 
    public String getCapital() {
        return capital;
    }
    /*
     * Method: setCapital(String capital)
     * Description: This is setter for capital
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem capital
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    /*
     * Method: getCapitalPop()
     * Description: This is getter for capitalPop
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return capitalPop 
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public float getCapitalPop()
    {
        return capitalPop;
    }
    /*
     * Method: setCapitalPop(float capitalPop)
     * Description: This is setter for capitalPop
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem capitalPop
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setCapitalPop(float capitalPop)
    {
        this.capitalPop = capitalPop;
    }
    /*
     * Method: getSize()
     * Description: This is getter for size
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return size
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public Integer getSize() {
        return size;
    }
    /*
     * Method: setSize(Integer size)
     * Description: This is setter for size
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem size
     * @return void 
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setSize(Integer size) {
        this.size = size;
    }
    /*
     * Method: getLocation()
     * Description: This is getter for location
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return location
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0 
     */ 
    public String getLocation() {
        return location;
    }
    /*
     * Method: setLocation(String location)
     * Description: This is setter for location
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem location
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setLocation(String location) {
        this.location = location;
    }
    /*
     * Method: getLanguage()
     * Description: This is getter for language
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return language
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public String getLanguage() {
        return language;
    }
    /*
     * Method: setLanguage(String language)
     * Description: This is setter for language
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem language
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setLanguage(String language) {
        this.language = language;
    }
    /*
     * Method: getRiver()
     * Description: This is getter for river
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return river
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public String getRiver() {
        return river;
    }
    /*
     * Method: setRiver(String river)
     * Description: This is setter for river
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem river
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public void setRiver(String river) {
        this.river = river;
    }
    /*
     * Method: getFlag()
     * Description: This is getter for flag
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return flag
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
      public ImageIcon getFlag()
    {
        return flag;
    }
    /*
     * Method: setFlag(ImageIcon flag, int width, int height)
     * Description: This is setter for flag and resize image to that of JLabel
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem flag
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0 
     */ 
    public void setFlag(ImageIcon flag, int width, int height)
    {
        Image image = flag.getImage(); // transform it
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        flag = new ImageIcon(newImg);
        this.flag = flag;
    }
     public String getFlagName()
     {
         return flagName;
     }
     public void setFlagName(String flagName)
     {
         this.flagName = flagName;
     }
    
    /*
     * Method: toString
     * Description: This is an overriding toString class
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 2/9/2018
     * @parem void
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    @Override
    public String toString()
    {
        return "Country{" + "name=" + name + ",country population=" + countryPop
                + ", capital=" + capital + "capital population=" + capitalPop 
                + ", size=" + size + ", location=" + location + ", language=" 
                + language + ", river=" + river + ", flag=" + flag + '}';
    }
    /*
     * Method: equals
     * Description: This is an overriding equal class
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 1/24/2018
     * @parem obj
     * @return true/false
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Country other = (Country) obj;
        if (this.countryPop != other.countryPop)
        {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
        {
            return false;
        }
        if ((this.capital == null) ? (other.capital != null) : !this.capital.equals(other.capital))
        {
            return false;
        }
        return true;
    }
    
    /*
     * Method: equals
     * Description: This is an equal class
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 1/30/2018
     * @parem country
     * @return true/false
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    public boolean equals(Country country)
    {
        if(this.getName().equalsIgnoreCase(country.getName())&&
                (closeEnough(this.getCountryPop(), country.getCountryPop()))
        
                )
            return true;
        else
            return false;
    }
    /*
     * Method: closeEnough
     * Description: This is a class to check if value is close enough
     * Environment: PC, Windows 10, NetBeans 8.0, jdk 1.8.0_144
     * Date: 1/30/2018
     * @parem x, y
     * @return void
     * @author Sanyapoom Sirijirakarn and Quynh Duc Vu
     * @version 1.0.0
     */ 
    private boolean closeEnough(float x,float y)
    {
        final double EPSILON = 1E-9;
        if(Math.abs(x-y) < EPSILON)
            return true;
        else
            return false;
    }
    
}
