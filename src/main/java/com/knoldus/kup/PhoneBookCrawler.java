package com.knoldus.kup;

import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {

   private PhoneBook phnBook;

   public PhoneBookCrawler(PhoneBook phnBook) {
      this.phnBook = phnBook;
   }

   public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
      return phnBook.findPhoneNumberByName(name).orElseThrow(()->new IllegalArgumentException("Phone number not found"));
   }

   public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
      return phnBook.findPhoneNumberByName(name).orElse(phnBook.toString());
   }

//  reimplemented exercise 2 using streams instead of using PhoneBook's findPhoneNumberByName
   public Optional<String> findPhoneNumberByName(String name){
      return Stream.of(phnBook)
              .map(phoneBook1 -> Optional.ofNullable(phoneBook1.getPhoneMap()
                      .get(name)))
              .findFirst().orElse(Optional.empty());
   }

//   reimplemented exercise 3 using streams instead of using PhoneBook's findPhoneNumberByName
   public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFoundByStreams(String name){
      return Stream.of(phnBook)
              .map(phoneBook1 -> Optional.ofNullable(phoneBook1
                              .getPhoneMap()
                      .get(name)).orElse(phoneBook1.toString()))
              .findFirst().get();
   }

//   exercise 7
   public String findPhoneNumberByNameOrNameByPhoneNumber(String name,String phoneNumber){
         return Stream.of(phnBook.findPhoneNumberByName(name),phnBook.findNameByPhoneNumber(phoneNumber))
                 .filter(Optional::isPresent)
                 .map(Optional::get)
                 .findFirst().get();
   }

}
