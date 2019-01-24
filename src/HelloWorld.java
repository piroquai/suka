import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloWorld {
    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "C:/Users/Pedro/Documents/Selenium/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.253:8080/cgi-bin");
//        Thread.sleep(2000);
//
        WebElement loginButton = driver.findElement(By.className("login-btn-ct"));
//        if (loginInput!=null) System.out.println("yes");
        loginButton.click();
        sleeper(2000);
        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys("admin");

        WebElement pwdInput = driver.findElement(By.id("pwd"));
        pwdInput.sendKeys("admin");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
//        sleeper(10000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        clicker("ext-gen62",driver,wait); //cancel update
        clicker("ext-gen153",driver,wait); //App Center
        sleeper(11000);
        clicker("ext-gen372",driver,wait); //Install Manually
        sleeper(2000);

        System.out.println(driver.findElements(By.id("fileext-gen648-file")).size());
        clicker("fileext-gen648-file",driver,wait); //Browse
        sleeper(2000);
        driver.switchTo().activeElement().sendKeys("C:\\Users\\Pedro\\Downloads\\goodsync-server-qnap.qpkg");
        sleeper(2000);
        driver.switchTo().activeElement().submit();
        //install 676
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen62")));
//        WebElement cancelUpdate = driver.findElementById("ext-gen62");
////        System.out.println(driver.findElements(By.id("ext-gen62")).size());
//        cancelUpdate.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen153")));
//        WebElement appButton = driver.findElementById("ext-gen153");
//        appButton.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen373")));
//        WebElement installButton = driver.findElementById("ext-gen373");
//        installButton.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen1260")));
//        WebElement browseButton = driver.findElementById("ext-gen1260");
//        browseButton.click();
    }

    public static void sleeper(long millis){
        try {
            Thread.sleep(millis);
            System.out.println("sleep");//milliseconds
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void clicker(String id, ChromeDriver driver, WebDriverWait wait){

//        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        WebElement currentButton = driver.findElementById(id);
        currentButton.click();
    }
}

//        boolean alert=true;
//        while (alert){
//            try {
//                driver.switchTo().alert();
//                alert=true;
//                System.out.println(1);
//                driver.switchTo().alert().dismiss();
//            } catch (NoAlertPresentException Ex) {
//                System.out.println(0);
//                alert=false;
//            }
//        }
