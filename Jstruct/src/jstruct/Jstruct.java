/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jstruct;
import javolution.io.Struct;
/**
 *
 * @author http://javolution.org/apidocs/javolution/io/Struct.html
 */
public class Jstruct {
public enum Gender { MALE, FEMALE };
 public static class Date extends Struct {
     public final Unsigned16 year = new Unsigned16();
     public final Unsigned8 month = new Unsigned8();
     public final Unsigned8 day   = new Unsigned8();
 }
 public static class Student extends Struct {
     public final Enum32<Gender>       gender = new Enum32<Gender>(Gender.values());
     public final UTF8String           name   = new UTF8String(64);
     public final Date                 birth  = inner(new Date());
     public final Float32[]            grades = array(new Float32[10]);
     public final Reference32<Student> next   =  new Reference32<Student>();
 }
    
    public static void main(String[] args) {
       
        
 Student student = new Student();
 student.gender.set(Gender.MALE);
 student.name.set("John Doe"); 
 int age = 2003 - student.birth.year.get();
 student.grades[2].set(12.5f);
 student = student.next.get();
    }
    
}
