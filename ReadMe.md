This project contains a custom framework and tasks for testing different functionality.

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
                