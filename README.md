**Configuration**
1. Open the `src/test/resources/application.yaml` file.
2. Update with your credentials:

    ```yaml
    general:
      username: YOUR_API_KEY_HERE
    ```
**Usage**
```
mvn clean test  
mvn allure:serve 
```

To run a specific test class using Maven, execute the following command in the terminal:

```
mvn clean test -Dtest=TestClassName

```
| No. | Element Title                            | Xpath                                      |
|-----|------------------------------------------|--------------------------------------------|
| 1   | Username input field - "Login" button    | //*[@id="username"]                        |
| 2   | Password input field - "Password" button | //*[@id="password"]                        |
| 3   | "Sign In" button                         | //*[@id="root"]/div/div[1]main/form/button |
| 4   | Logo                                     | //*[@id="root"]/div/div[1]/div/div[1]/a    |
| 5   | EN Language button                       | //*[@id="root"]/div/div[2]/div/button[1]   |
| 6   | RU Language button                       | //*[@id="root"]/div/div[2]/div/button[2]   |


| No. | Checklist for Tallinn Delivery Login page                                                                                                  | Result |
|-----|--------------------------------------------------------------------------------------------------------------------------------------------|--------|
| 1   | Verify that Login page have following elements on it: "Login", "Password" input fields, "Sign-in" button, Logo, Language buttons and Title |        |
| 2   | Check if all buttons are clickable                                                                                                         |        |
| 3   | Check that the user is able to select the language                                                                                         |        |
| 4   | Check the alignment of displayed elements on the login page that should be compatible with cross-browsing testing                          |        |
| 5   | Check that the application's login page is responsive and aligns properly on different screen resolutions and devices                      |        |
| 6   | Check that after the user clicks on the Logo icon the page refreshes automatically                                                         |        |
| 7   | Check whether tab functionality (moving the cursor from on text box to another) works                                                      |        |
| 8   | Check whether the validation message is displaying based on the input value                                                                |        |
| 9   | Check if the user is not able to submit the request with blank fields                                                                      |        |
| 10  | Check user should not be able to log in with a blank user field and valid password                                                         |        |
| 11  | Check that the user cannot log in with a valid username and blank password field                                                           |        |
| 12  | Check whether the text boxes' minimum and maximum lengths are defined                                                                      |        |
| 13  | Check if the user is not able to exceed the 30 characters in both Login and Password fields                                                |        |
| 14  | Check if the user is not able to submit the request with less than 2 characters in the Login field                                         |        |
| 15  | Check if the user is not able to submit the request with less than 8 characters in the Password field                                      |        |
| 16  | Check that the user cannot log in with both invalid username and password                                                                  |        |
| 17  | Check that the user cannot log in with valid username and invalid password                                                                 |        |
| 18  | Check that the user cannot log in with an invalid username and valid password                                                              |        |
| 19  | Check whether Password field values are displayed in masked/encrypted format                                                               |        |
| 20  | Check whether the user can submit the request through the Enter button                                                                     |        |
| 21  | Check if the user is able to log in with valid credentials                                                                                 |        |
| 22  | Check if the user after log in is redirected to the "Create order" page                                                                    |        |



| No. | Query                                                                   | XPath of the query                          |
|-----|-------------------------------------------------------------------------|---------------------------------------------|
| 4.1 | Select all <td> elements containing names (Names)                       | //td[@class="td3"][not(contains(p, 'Name')) |
| 4.2 | Select all <td> elements whose data-qa attributes begins with "amount-" | //tr//td//p[starts-with(., 'Amount')]       |
| 4.3 | Select all <td> elements with text "John Doe"                           | //tr//td[contains(., 'John Doe')            |

