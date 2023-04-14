package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponents;
import components.RegistrationCheck;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private final CalendarComponents calendarComponents = new CalendarComponents();
    private final RegistrationCheck registrationCheck = new RegistrationCheck();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSelect = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitBtn = $("#submit");


    @Step("Открыть главную страницу")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Закрыть баннеры")
    public RegistrationPage closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Ввести фамилию")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Ввести email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage setGender(String gender) {
        genderSelect.$(byText(gender)).click();
        return this;
    }

    @Step("Ввести телефон")
    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    @Step("Ввести дату рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage setSubject(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage setHobbies(String hobbies) {
        hobbiesSelect.$(byText(hobbies)).click();
        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationPage setUploadPicture(File file) {
        pictureUpload.uploadFile(file);
        return this;
    }

    @Step("Ввести адрес")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    @Step("Клик на кнопку подтвердить")
    public void clickSubmit() {
        submitBtn.click();
    }

    @Step("Проверка сообщения в модальном окне")
    public RegistrationPage verifyResultsModalAppears() {
        registrationCheck.verifyModalAppears();
        return this;
    }

    @Step("Проверка соответствия всех введённых значений")
    public RegistrationPage verifyResults(String key, String value) {
        registrationCheck.verifyResult(key, value);
        return this;
    }

}