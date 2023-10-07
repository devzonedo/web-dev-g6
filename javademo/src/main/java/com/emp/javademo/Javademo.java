

package com.emp.javademo;


public class Javademo {

    public static void main(String[] args) {
        System.out.println("Hi Java");
        
//        
//        int x = 10;
//        String myName = "Ravinath"; 
        
        User myUser = new User();
        myUser.setId(13);
        myUser.setFirst_name("Ravinath");

        
        User myUser2 = new User();
        myUser2.setRole_code("Student");

        
      int i =  myUser.getId();
        System.out.println("i:"+i);
    }  
    
    
}
