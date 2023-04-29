package solved_problem.programmers.level03.메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char) menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toList());

        for (Set<String> set : orderList) {
            System.out.println(set.toString());
        }

        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }

        System.out.println(courses.toString());

        getCourses('A', new HashSet<>(), orderList, courses);

        System.out.println(courses.toString());

        return courses.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);
    }

    private void getCourses(char nextMenu,
                            Set<String> selectedMenus,
                            List<Set<String>> orderList,
                            Map<Integer, List<Course>> courses) {

        System.out.println(nextMenu);
        System.out.println(selectedMenus);
        System.out.println(orderList);
        System.out.println(courses);
        System.out.println("------------------");

        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();

        if (occurrences < 2) {
            return;
        }

        int size = selectedMenus.size();
        if (courses.containsKey(size)) {
            List<Course> courseList = courses.get(size);
            String courseStr = selectedMenus.stream()
                    .sorted()
                    .collect(Collectors.joining(""));

            Course course = new Course(courseStr, occurrences);

            Course original = courseList.get(0);

            if (original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrences == occurrences) {
                courseList.add(course);
            }

        }

        if (size >= 10) {
            return;
        }

        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }

    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "course='" + course + '\'' +
                    ", occurrences=" + occurrences +
                    '}';
        }
    }

}
