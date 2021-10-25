package example.example.stepDefinition;


import example.example.base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddAndRemoveUser extends Config {
    String firstName = "Rana_FirstName";
    String lastName = "Rana_LastName";
    String userName = "Rana_UserName";
    String userPassword = "Rana_Password";
    String customer = "Company BBB";
    String roleID = "Admin";
    String email = "rana@test.com";
    String phoneNumber = "1111111111";
    String userToDelete = "novak";

    @Given("user navigates to website")
    public void user_navigates_to_website() {
        driver = initDriver("ch");
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
    }

    @When("user clicks on Add User button")
    public void user_clicks_on_add_user_button() {
        driver.findElement(By.xpath("//button[text()=' Add User']")).click();
    }

    @When("user fills in new user details")
    public void user_fills_in_new_user_details() {
        driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(userPassword);
        driver.findElement(By.xpath("//label[text()='"+customer+"']/input")).click();
        Select roleID = new Select(driver.findElement(By.xpath("//select[@name='RoleId']")));
        roleID.selectByValue("2");
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='Mobilephone']")).sendKeys(phoneNumber);
    }

    @When("clicks save button")
    public void clicks_save_button() {
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("validate newly added user exists in webtable")
    public void validate_newly_added_user_exists_in_webtable() {
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']"));

        for (int i = 1; i < rows.size()-1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']["+i+"]/td"));
            for (int j = 1; j < columns.size()-1; j++) {
                if(driver.findElement(By.xpath("//tr[@class='smart-table-data-row ng-scope']["+i+"]/td["+j+"]")).getText().equals(userName)){
                    System.out.println("Username "+userName+" exists in the webtable!");
                }
            }
        }
    }

    @And("quit browser")
    public void quit_browser(){
        driver.quit();
    }

    @When("user finds username novak and delete username novak from webtable")
    public void user_finds_username_novak() throws InterruptedException {
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']"));

        for (int i = 1; i < rows.size()-1; i++) {
            List<WebElement> columns = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']["+i+"]/td"));
            for (int j = 1; j < columns.size()-1; j++) {
                if(driver.findElement(By.xpath("//tr[@class='smart-table-data-row ng-scope']["+i+"]/td["+j+"]")).getText().equals(userToDelete)){

                    System.out.println("Deleting user "+userToDelete);
                    driver.findElement(By.xpath("//tr[@class='smart-table-data-row ng-scope']["+i+"]/td[11]/button")).click();
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//button[text()='OK']")).click();
                }
            }
        }
    }
}
