package study.effective.item56;

import java.util.List;
import java.util.ArrayList;

/**
 * 이펙티브 자바 아이템 56 예제 클래스
 *
 * @author 홍길동
 */
public class Item56 {

    public static void main(String[] args) {
        UserService service = new UserService();

        // 사용자 추가
        User user = new User("hongildong", "홍길동", 30);
        service.addUser(user);

        // 사용자 조회 및 업데이트
        User foundUser = service.findUserByUsername("hongildong");
        System.out.println("찾은 사용자: " + foundUser);

        // 사용자 삭제
        service.removeUser("hongildong");
    }
}

/**
 * 사용자 정보를 관리하는 서비스 클래스
 */
class UserService {
    private final List<User> users = new ArrayList<>();

    /**
     * 새로운 사용자를 시스템에 추가합니다.
     *
     * @param user 추가할 사용자 객체 (null이 아니어야 함)
     * @return 추가 성공 여부
     * @throws NullPointerException user가 null인 경우
     */
    public boolean addUser(User user) {
        if (user == null) {
            throw new NullPointerException("사용자 객체는 null이 될 수 없습니다");
        }
        return users.add(user);
    }

    /**
     * 사용자명으로 사용자를 조회합니다.
     *
     * @param username 조회할 사용자의 사용자명
     * @return 찾은 사용자 객체
     * @throws IllegalArgumentException 해당 사용자명을 가진 사용자가 없는 경우
     */
    public User findUserByUsername(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다: " + username));
    }

    /**
     * 사용자를 시스템에서 제거합니다.
     *
     * @param username 제거할 사용자의 사용자명
     * @return 제거 성공 여부
     */
    public boolean removeUser(String username) {
        return users.removeIf(u -> u.getUsername().equals(username));
    }
}

/**
 * 시스템의 사용자를 나타내는 클래스
 */
class User {
    private final String username;
    private final String name;
    private int age;

    /**
     * 새로운 사용자 객체를 생성합니다.
     *
     * @param username 사용자명
     * @param name 실제 이름
     * @param age 나이
     */
    public User(String username, String name, int age) {
        this.username = username;
        this.name = name;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', name='" + name + "', age=" + age + '}';
    }
}
