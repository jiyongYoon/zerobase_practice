package DB;

import java.util.List;

public class MemberTest {
    public static void main(String[] args) {
        Member member = new Member();
        MemberService ms = new MemberService();

        // 회원가입
        boolean result = ms.register(member);

        // 회원탈퇴
        boolean result2 = ms.withdraw(member);

        //회원목록보기
        List<Member> memberList = ms.getList();


    }
}
