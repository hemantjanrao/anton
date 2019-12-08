package driver.implementation;

import driver.DriverManager;
import org.openqa.selenium.edge.EdgeDriverService;

public class EdgeDriverManager extends DriverManager {

    private EdgeDriverService edgService;

    @Override
    protected void startService() {
        if (null == edgService) {
            try {
                edgService = null;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {

    }

    @Override
    protected void createDriver() {

    }
}
