# Assesment_3

Input java
```java
public class className {
    int value1 = 1 ;
    boolean value2 = true ;
    float value3 = 2.3 ;
    if ( value1 == 1) {
        value1 = 2 ;
    }
    public void SomeFunction1 ( ) {
        value1 = 5;
    }
    public int SomeFunction2 ( ) {
        return 2 ;
    }
    someClass.value = 2 ;
    value1 = someClass.SomeFunction2 ( ) ;
}
```
output:
```
public class className { 
 > Keyword is public token # is 2
 > Class is constructed correctly
int value1 = 1 ; 
 > Keyword is int token # is 9
 > int is decalared correctly
boolean value2 = true ; 
 > Keyword is boolean token # is 8
 > Boolean is decalared correctly
float value3 = 2.3 ; 
 > Keyword is float token # is 7
 > float is decalared correctly
if ( value1 == 1) { 
 > Keyword is if token # is null
[if, (, value1, ==, 1), {]
 > if is not constructed correctly
public void SomeFunction1 ( ) { 
 > this method is constructed correctly
public int SomeFunction2 ( ) { 
 > this method is constructed correctly
someClass.value = 2 ; 
 > Class Dereferencing is constructed correctly
value1 = someClass.SomeFunction2 ( ) ; 
 > Class Dereferencing is constructed correctly
 ```
Picture:
https://github.com/aahmedyusuf/Assesment_3/blob/main/Screen%20Shot%202021-12-08%20at%206.14.50%20PM.png
