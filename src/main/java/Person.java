public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;
    protected boolean isAgeKnown;
    protected boolean isCityKnown;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (hasAge()) {
            return age;
        } else return 0;
    }

    public boolean isAgeKnown() {
        return isAgeKnown;
    }

    public String getCity() {
        if (hasCity()) {
            return city;
        } else return "non";
    }

    public boolean isCityKnown() {
        return isCityKnown;
    }

    public Person(String name, String surname, int age, String city, boolean isAgeKnown, boolean isCityKnown) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.isAgeKnown = isAgeKnown;
        this.isCityKnown = isCityKnown;
    }

    protected boolean hasCity() {
        return isCityKnown;
    }

    protected boolean hasAge() {
        return isAgeKnown;
    }

    public void setCity(String city) {
        this.city = city;
    }

    protected void happyBirthday() {
        age++;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        if (this.age > 5) {
            return name + " " + surname;
        } else return name;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(name)
                .setSurname(this.surname);
    }

    public static class PersonBuilder {
        private String name;
        private String surname;

        private int age;
        private String city;
        private boolean isAgeKnown;
        private boolean isCityKnown;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if(age < 0 ) {
                throw new IllegalArgumentException("Возраст не может быть меньше ноля.");
            } else {
            this.age = age;
            return this;}
        }

        public PersonBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public PersonBuilder setIsAgeKnown(boolean isAgeKnown) {
            this.isAgeKnown = isAgeKnown;
            return this;
        }

        public PersonBuilder setIsCityKnown(boolean isCityKnown) {
            this.isCityKnown = isCityKnown;
            return this;
        }

        public Person build() {
            if(this.name.equals("") || this.surname.equals("")) {
                throw new IllegalStateException("Имя и фамилия не могут быть пустыми");
            } else
            {return new Person(name, surname, age, city, isAgeKnown, isCityKnown);}
        }
    }
}