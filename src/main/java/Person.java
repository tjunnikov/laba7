
public class Person {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public int dayBirth;
    public String monthBirth;
    public int yearBirth;
    public String address;
    public String city;
    public String state;
    public int zip;
    public int country;
    public String phone;

    public Person(
            String firstName,  //имя
            String lastName,  //фамилия
            String email,  //email
            String password,  //пароль
            int dayBirth,  //дата др
            String monthBirth,  //месяц др
            int yearBirth,  //год др
            String address,  //улица
            String city,  //город
            String state,  //штат
            int zip,  //индекс
            int country,  //страна
            String phone  //номер
    ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
    }
}
