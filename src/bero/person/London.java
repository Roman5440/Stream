package bero.person;

import java.util.*;
import java.util.stream.Collectors;

public class London {
    private Collection<Person> people;

    public London() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        people = persons;
    }

    public long countYounger18() {
        return people.stream().filter(person -> person.getAge() < 18).count();
    }

    public List<String> getPrizyvnikovSurnames() {
        return people.stream().filter(p -> p.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    public List<Person> filterRabotospasobnye() {
        return people.stream()
                .filter(p -> Education.HIGHER == p.getEducation())
                .filter(p -> {
                    boolean womanYonger60 = p.getSex() == Sex.WOMAN && p.getAge() <= 60;
                    boolean manYonger65 = p.getSex() == Sex.MAN && p.getAge() <= 65;
                    return p.getAge() >= 18 && (womanYonger60 || manYonger65);
                }).sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
