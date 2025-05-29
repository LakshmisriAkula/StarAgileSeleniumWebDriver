#Cucumber anotations
   #try to build one scenario by using hooks (after and before)
   #	1. navigate to https://automationexercise.com/
   #	2. pick testcase no. 6
   #	1. Launch browser
#2. Navigate to url 'http://automationexercise.com'
#3. Verify that home page is visible successfully
#4. Click on 'Contact Us' button
#5. Verify 'GET IN TOUCH' is visible
#6. Enter name, email, subject and message
#7. Upload file
#8. Click 'Submit' button
#9. Click OK button
#10. Verify success message 'Success! Your details have been submitted successfully.' is visible
#11. Click 'Home' button and verify that landed to home page successfully

Feature: Contact Form Submission on Automation Exercise

  Scenario: Submitting and Verifying Contact Us Form
    Given I launch the browser and navigate to "http://automationexercise.com"
    Then I should see the home page successfully
    When I click on the Contact Us button
    Then I should see "GET IN TOUCH"
    When I enter name "Nithin", email "nithin@gmail.com", subject "WebDriver" and message "Hello"
    And I upload file "C:\\Users\\Lakshmi Sri Akula\\Downloads\\Payslip_PhaniKumar_Jul-2023 (3).pdf"
    And I click the Submit button and accept the alert
    Then I should see the success message "Success! Your details have been submitted successfully."
    When I click the Home button
    Then I should be navigated to the home page successfully


	