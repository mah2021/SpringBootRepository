DataBase :
There are 6 tables (employee (information about every employee and also admin and accountant)
                leaves (for request leaves from employee and if admin set status=true means he/she accept leave)
                role(show three roles in database (EMPLOYEE , ADMIN , ACCOUNTANT))
                salary ( show the basic salary and calculate tax and then return remain salary that must give employee)
                user-role (include user_id and role_id)
                user-entity ( to login by email and password for Authentication )


in our project ,create two repository for every entity class ( CrudRepository and Jparepository)

use swagger to test project . 

at first when you type http://swagger-ui.html show a page that need username and password 

to encrypt password and save in database , use https://bcrypt-generator.com 
then you must decrypt to login to swagger .

There are 3 roles in this project and we saved three username and password for these roles :
EMPLOYEE ROLES : user@gmail.com for username and user for password.
ADMIN ROLES : admin@gmail.com for sername and admin for password.
ACCOUNTANT ROLE :zeitongraph@gmail.com for username and 13591363ma4 for password.
