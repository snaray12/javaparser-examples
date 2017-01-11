package my_tests.mytests;

import java.lang.String;

public class Hello {
  private String defaultMsg = "Hello World";
  
  public Hello() {
	  this("Hello World");
  }
  
  public Hello(final String msg){
	  this.defaultMsg = msg;
  }
  public void sayHello(String msg) {
    if(null == msg || msg.length() <0) {
       msg = defaultMsg;
    }
    System.out.println(msg);
  }
  public static void main(String[] args) {
    new Hello().sayHello("Welcome 2017");
  }
}
