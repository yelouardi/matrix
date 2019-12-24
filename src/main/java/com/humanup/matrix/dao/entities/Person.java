package com.humanup.matrix.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person{

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  private String mailAdresses;
  private Date birthDate;

  protected Person() {}

  public Person(String firstName, String lastName, String mailAdresses,Date birthDate ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mailAdresses = mailAdresses;
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMailAdresses() {
    return mailAdresses;
  }

  public Date getBirthDate() {
    return birthDate;
  }


  public static class Builder{

          private String firstName;
          private String lastName;
          private String mailAdresses;
          private Date birthDate;

           public Builder() {
           }

           public Builder setFirstName(String firstName) {
             this.firstName = firstName;
             return this;
           }

           public Builder setLastName(String lastName) {
             this.lastName = lastName;
             return this;
           }

           public Builder setMailAdresses(String mailAdresses) {
             this.mailAdresses = mailAdresses;
             return this;
           }

           public Builder setBirthDate(Date birthDate) {
             this.birthDate = birthDate;
             return this;
           }
           public Person build(){
             return new Person( firstName,  lastName,  mailAdresses, birthDate);
           }
         }
}