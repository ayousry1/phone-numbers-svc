# Customers Numbers Challange

The required tools for running this app are as follows

 - Docker
 - Maven
 - NodeJs
 - Angular CLI

# Boot up steps

Below are the list of steps required to run the application.

## Cloning the repository

 1. clone the backend code using the following command or by extracting the attached zip file 'phone-numbers-svc.zip'
 2. clone the frontend code using the following command or by extracting the attached zip file 'phone-numbers-ui.zip'

**Backend repository clone command**

    git clone https://github.com/ayousry1/phone-numbers-svc.git

**Frontend repository clone command**

    git clone https://github.com/ayousry1/phone-numbers-ui.git


## Booting up the backend

 1. navigate to the cloned directory 'phone-numbers-svc'
 2. Open command prompt there and type the following commands

**commands**

    mvn clean install
    
> 
    docker build -t phone-number-svc.jar .
> 

    docker run -p 8080:8080 phone-number-svc.jar

## Booting up the frontend

 1. navigate to the cloned directory 'phone-numbers-ui'
 2. Open command prompt there and type the following commands

**commands**

    npm install
    
> 
    ng serve --prod
## Running the app

 1. open chrome and type this URL http://localhost:4200/
 2. the application works!