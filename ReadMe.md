# Courses. Custom framework 
***
### This project contains a custom framework and tasks for testing different functionality.<br/>And some drafts about used stacks on the framework.
\
\
Stack using instruments:

    1. Maven
    2. Selenium/web driver
    3. TestNG
    4. Selenide
    5. Rest-assured
    6. Hamcrest
    7. Jackson-databind
    8. Lombok
    9. Owner
    10. Assertj-core
\
\
Tests 

Test #1 "Check boxes"

    website: http://www.leafground.com/pages/checkbox.html

    Task
    1. Select the languages that you know? Click the Java checkbox, check that it is selected
    2. Confirm Selenium is checked Check that the Selenium checkbox is checked by default
    3. DeSelect only checked Click the I am Selected checkbox, check that it is not selected anymore
    4. Select all below checkboxes Click all checkboxes (try to create a collection of elements using xPath 
       that will be common to all, and in a loop click on each element in the collection), 
       also check that all checkboxes are selected

Test #2 "Ukr net - Mailinator"
    
    website: https://mail.ukr.net/desktop
             https://mail.ukr.net/
             https://www.mailinator.com/v4/public/inboxes.jsp
    
    Task
    1. Add a check that after sending a letter to a user with UkrNet mail, 
       a message is displayed that the letter has been sent
    2. Go to mailinator.com and check that the letter was delivered to the addressee (be careful here, 
       there is also an iFrame here)
    3. Follow the Page Object pattern and create custom classes for mailinator pages

Test #3 "Wait"

     website: http://www.leafground.com/pages/appear.html
              http://www.leafground.com/pages/disapper.html
              http://www.leafground.com/pages/TextChange.html
    
    Task
    1. On the page http://www.leafground.com/pages/disapper.html write a test that will wait until the element 
       "I'm going to disapper.Keep looking at me !!" will disappear
    2. At http://www.leafground.com/pages/appear.html write a test that will wait for the 
       "Voila! I'm here Guys" element to appear on the page
    3. On the page http://www.leafground.com/pages/TextChange.html write a test that will wait until the text 
       in the button becomes "Click ME!"

Test #4 "The internet"

    website: http://the-internet.herokuapp.com/login
    
    Task
    1. On the page http://the-internet.herokuapp.com/login page, check for field validation
    2. Make a negative test - correct name, incorrect password
    3. Make a negative test - incorrect name, correct password
    4. Make a negative test - wrong name, wrong password
    5. Make a positive test - correct name, correct password

Test #5 "Filter element"

    website: http://www.leafground.com/home.html
    
    Task
    1. On the page http://the-internet.herokuapp.com/login page, select all titles wich starting from character 'A'

Test #6 "Use selenide search"

    website: https://www.google.com.ua
    website: https://ru.selenide.org

    Task
    1. Go to google.com
    2. Google "Selenide"
    3. Check if there are more than 7 results
    4. Follow the first link
    5. Check if the page is open
    6. Check that Selenide supports Ukraine
    7. Go to "Blog" tab
    8. Check if the page is open

Test #7 "Rest assured example"

    website: https://petstore.swagger.io/

    task
    1. Write a POST/pet request
    2. Check that the pet has been created
    3. To check use GET/pet/:petId
    4. For the pet entity, create a dto class

    task
    1. Write a POST/store/order request and using the previously created pet
    2. Check that the order has been created
    3. To check use GET/store/order/:orderId
    4. For the order entity, create a dto class
