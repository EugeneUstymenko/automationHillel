

        //Пример как сделать окно драйвера во все окно
            //driver.manage().window().maximize();


        //Пример просто уссыпить систему - лучше не использовать
            //Thread.sleep(2000);


        //Пример работы с листами локаторов
            /*By inputListLocator = By.xpath("//input");
            List<WebElement> inputs = driver.findElements(inputListLocator);
            System.out.println(inputs.get(4).isEnabled());*/


        //Пример работы с xpath
            /*label[contains(@for, 'ema')]
            label[text()='Enter your email address']/following-sibling::input[@type='text']*/


        //Пример вставки переменной в текст
           /* @Test
            public void stringFormat(){
                String text = "My name is: %s, and my age is: %d";
                String newText = String.format(text, "Leo", 24);
                System.out.println(newText);
            }*/


        //Пример имплисити wait
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds());

        //Пример wait отработки js
            /*public void waitUntilJsIsReady() {
                webDriverWait.until((ExpectedCondition<Boolean>) wd ->
                        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
            }*/


        //Пример работы с двойными массивами и групировкой тестов (например для их исключения)
            /* @Test(groups = "exclude-me")
             public void arrayTest() {
                int[][] array = new int[4][6];
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        array[i][j] = i + j;
                    }
                }
                print(array);
            }
            private void print(int[][] arr) {
                for (int row = 0; row < arr.length; row++)//Cycles through rows
                {
                    for (int col = 0; col < arr[row].length; col++)//Cycles through columns
                    {
                        System.out.printf("%5d", arr[row][col]); //change the %5d to however much space you want
                    }
                    System.out.println(); //Makes a new row
                }
            }*/


        //Пример wait эксплекатор
            //webDriverWait.until(ExpectedConditions.elementToBeClickable(lastLetter));


        //Пример как стрим и функцианальный интерфейс заменил обычные циклы (пример снизу)
            /*selectAllBelowCheckBox.forEach(WebElement::click);
            return selectAllBelowCheckBox.stream().allMatch(WebElement :: isSelected);*/
        //Пример цикла
           /* for (WebElement checkBox : selectAllBelowCheckBox) {
                checkBox.click();
            }
            for (WebElement checkBox : selectAllBelowCheckBox) {
                if(!checkBox.isSelected()){
                    return false;
                }
                break;
            }
            return true;*/


        //Пример как скармливать селениду - веб драйвер
        //WebDriverRunner.setWebDriver(driver);
