package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static components.TestData.*;

import java.io.File;


public class RegistrationWithFakerTests extends TestBase {
    private final File file = new File("src/test/resources/picture/1.png");
    RegistrationPage registrationPage = new RegistrationPage();

    @Tag("qa")
    @Test
    void registrationTest() {

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setUploadPicture(file)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", mobile)
                .verifyResults("Date of Birth", dayOfBirthDate + " " +
                        monthOfBirthDate + "," + yearOfBirthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", picture)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);

    }
}