public class Main {
    public static void main(String[] args) {
        try {
            Person mom = new Person.PersonBuilder()
                    .setName("Анна")
                    .setSurname("Вольф")
                    .setAge(31)
                    .setCity("Сидней")
                    .build();

            Person son = mom.newChildBuilder()
                    .setName("Антошка")
                    .build();

            System.out.println("У " + mom + " есть сын, " + son);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}