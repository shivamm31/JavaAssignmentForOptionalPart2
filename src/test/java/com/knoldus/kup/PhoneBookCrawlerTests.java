package com.knoldus.kup;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookCrawlerTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Phone number not found");
        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Roy");
    }

    @Test
    public void findPhoneNumberByName_CorrectIfFind(){
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Shivam");
        assertThat(phoneNumberActual).isEqualTo("8960475145");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBookActual = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Mudit");
        assertThat(phoneBookActual).isEqualTo("PhoneBook{ PhoneBook = {Shivam=8960475145, Rohan=1234567891}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByName() {
        String phoneNumberActual = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Shivam", "12456578");
        assertThat(phoneNumberActual).isEqualTo("8960475145");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_CorrectIfFoundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Samrat", "1234567891");
        assertThat(name).isEqualTo("Rohan");
    }
}
