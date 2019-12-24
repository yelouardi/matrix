package com.humanup.matrix.vo;

import java.util.Date;

public class PersonVO {
  private String firstName;
  private String lastName;
  private String mailAdresses;
  private Date birthDate;

  public PersonVO() {
  }

  public PersonVO(String firstName, String lastName, String mailAdresses, Date birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.mailAdresses = mailAdresses;
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMailAdresses() {
    return mailAdresses;
  }

  public void setMailAdresses(String mailAdresses) {
    this.mailAdresses = mailAdresses;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
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
          public PersonVO build() {
           return new PersonVO( firstName,  lastName,  mailAdresses,  birthDate);
          }
        }
}
