package DB;

import java.sql.*;
import java.util.Scanner;

public class ZerobaseMemberService {
    // Java를 통한 DB 핸들링
    public void dbSelect_statement() {
        // DB접속을 위한 5가지
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. password
        // 5. Instance

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        // close하다가 예외가 발생하여 catch로 가게 될 수 있으므로
        // try, catch, 'finally' <- 여기로 가야함!!
        // 그래서 객체를 먼저 생성해주기
        Connection connection = null;
//      PreparedStatement preparedStatement = null; // <- DbTest2에서는 이거 씀
        Statement statement = null; // <- DbTest1에서는 이거 씀
        ResultSet rs = null;

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            /* 3. 스테이트먼트 객체 생성
            Statement statement = null;
            PreparedStatement preparedStatement = null; // <- 이걸 사용하게 됨
            CallableStatement callableStatement = null;
             */

            statement = connection.createStatement();

            // 4. 쿼리 실행
            // sql문 작성
// sql injection 발생 가능성!! 확인해보자
            String sql = " select zm.name, zm.mobile_n , zm.register_date " +
                    " from zerobase_member zm " +
                    " where zm.marketing_yn = '1' ";

            // sql문 실행
            rs = statement.executeQuery(sql);

            // 5. 결과 수행
            while(rs.next()) {
                String name = rs.getString("name");
                String mobile_n = rs.getString("mobile_n");
                String register_date = rs.getString("register_date");

                System.out.println(name + ", " + mobile_n + ", " + register_date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void dbSelect_prepare() {
        // DB접속을 위한 5가지
        // 1. ip(domain)
        // 2. port
        // 3. 계정
        // 4. password
        // 5. Instance

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        // close하다가 예외가 발생하여 catch로 가게 될 수 있으므로
        // try, catch, 'finally' <- 여기로 가야함!!
        // 그래서 객체를 먼저 생성해주기
        Connection connection = null;
        PreparedStatement preparedStatement = null; // <- DbTest2에서는 이거 씀
        // Statement statement = null; // <- DbTest1에서는 이거 씀
        ResultSet rs = null;

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);


            // 4. 쿼리 실행
            // sql문 작성
// 만약, 마케팅선택이 n인 사람들은 어떻게 조회할 수 있을까? sql문을 그때마다 수정해줘야 하나?
// 1. sql문 자체에 변수를 두고 변수를 수정 -> 위험 노출 (sql injection 발생 가능성!!)
            String marketing_yn = "0";

            String sql = " select zm.name, zm.mobile_n , zm.register_date " +
                    " from zerobase_member zm " +
                    " where zm.marketing_yn = ? ";

            /* 3. 스테이트먼트 객체 생성
            Statement statement = null;
            PreparedStatement preparedStatement = null; // <- 이걸 사용하게 됨
            // PreparedStatement 는 매개변수로 sql이 들어가기 때문에 순서가 바뀜
           CallableStatement callableStatement = null;
             */
            preparedStatement = connection.prepareStatement(sql);
            // 변수 sql의 첫번째 ? 위치(첫 번째 매개변수)에 marketing_yn 값을 넣겠다는 뜻
            preparedStatement.setString(1, marketing_yn);

            // sql문 실행
            // 여기도 preparedStatement로 바뀜
            rs = preparedStatement.executeQuery();

            // 5. 결과 수행
            while(rs.next()) {
                String name = rs.getString("name");
                String mobile_n = rs.getString("mobile_n");
                String register_date = rs.getString("register_date");

                System.out.println(name + ", " + mobile_n + ", " + register_date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void register(ZerobaseMember zm) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        // close하다가 예외가 발생하여 catch로 가게 될 수 있으므로
        // try, catch, 'finally' <- 여기로 가야함!!
        // 그래서 객체를 먼저 생성해주기
        /* 3. 스테이트먼트 객체 생성
        Statement statement = null;
        PreparedStatement preparedStatement = null; // <- 이걸 사용하게 됨
        // PreparedStatement 는 매개변수로 sql이 들어가기 때문에 순서가 바뀜
        CallableStatement callableStatement = null;
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null; // <- DbTest2에서는 이거 씀
        // Statement statement = null; // <- DbTest1에서는 이거 씀
        ResultSet rs = null;

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 4. 쿼리 실행
            // sql문 작성
// 만약, 마케팅선택이 n인 사람들은 어떻게 조회할 수 있을까? sql문을 그때마다 수정해줘야 하나?
// 1. sql문 자체에 변수를 두고 변수를 수정 -> 위험 노출 (sql injection 발생 가능성!!)
// Main 에서 개변수로 받게 될 떄는 없어도 됨
//            String nameValue = "김한국";
//            String emailValue = "test4@naver.com";
//            String mobileNum = "01003010815";
//            String passwordValue = "1003";
//            int marketing_yn = 0;

            String sql = " insert into zerobase_member (name, email, mobile_n, password, marketing_yn , register_date) " +
                    " values (?, ?, ?, ?, ?, now()); ";


            preparedStatement = connection.prepareStatement(sql);
            // 변수 sql의 첫번째 ? 위치(첫 번째 매개변수)에 marketing_yn 값을 넣겠다는 뜻
            preparedStatement.setString(1, zm.getNameValue());
            preparedStatement.setString(2, zm.getEmailValue());
            preparedStatement.setString(3, zm.getMobileNum());
            preparedStatement.setString(4, zm.getPasswordValue());
            preparedStatement.setInt(5, zm.getMarketing_yn());

            // sql문 실행
            // 여기도 preparedStatement로 바뀜
            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if(affected > 0) {
                System.out.println("저장 성공. 변경 Data 개수: " + affected);
            } else {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void update() {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        // close하다가 예외가 발생하여 catch로 가게 될 수 있으므로
        // try, catch, 'finally' <- 여기로 가야함!!
        // 그래서 객체를 먼저 생성해주기
        /* 3. 스테이트먼트 객체 생성
        Statement statement = null;
        PreparedStatement preparedStatement = null; // <- 이걸 사용하게 됨
        // PreparedStatement 는 매개변수로 sql이 들어가기 때문에 순서가 바뀜
        CallableStatement callableStatement = null;
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null; // <- DbTest2에서는 이거 씀
        // Statement statement = null; // <- DbTest1에서는 이거 씀
        ResultSet rs = null;

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 4. 쿼리 실행
            // sql문 작성
// 만약, 마케팅선택이 n인 사람들은 어떻게 조회할 수 있을까? sql문을 그때마다 수정해줘야 하나?
// 1. sql문 자체에 변수를 두고 변수를 수정 -> 위험 노출 (sql injection 발생 가능성!!)
            String nameValue = "김한국";
            String emailValue = "test4@naver.com";
            String mobileNum = "01003010815";
            String passwordValue = "1010";
            int marketing_yn = 0;

            String sql = " update zerobase_member " +
                    " set " +
                    "   password = ? " +
                    " where name = ? and mobile_n = ? ;";


            preparedStatement = connection.prepareStatement(sql);
            // 변수 sql의 첫번째 ? 위치(첫 번째 매개변수)에 marketing_yn 값을 넣겠다는 뜻
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, nameValue);
            preparedStatement.setString(3, mobileNum);

            // sql문 실행
            // 여기도 preparedStatement로 바뀜
            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if(affected > 0) {
                System.out.println("변경 성공. 변경 Data 개수: " + affected);
            } else {
                System.out.println("변경 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void withdraw(ZerobaseMember zm) {
        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserId = "testuser3";
        String dbPassword = "zerobase";

        // 1. 드라이버 로드
        // 2. 커넥션 객체 생성
        // 3. 스테이트먼트 객체 생성
        // 4. 쿼리 실행
        // 5. 결과 수행
        // 6. 객체 연결 해제(close)
        // close하다가 예외가 발생하여 catch로 가게 될 수 있으므로
        // try, catch, 'finally' <- 여기로 가야함!!
        // 그래서 객체를 먼저 생성해주기
        /* 3. 스테이트먼트 객체 생성
        Statement statement = null;
        PreparedStatement preparedStatement = null; // <- 이걸 사용하게 됨
        // PreparedStatement 는 매개변수로 sql이 들어가기 때문에 순서가 바뀜
        CallableStatement callableStatement = null;
         */
        Connection connection = null;
        PreparedStatement preparedStatement = null; // <- DbTest2에서는 이거 씀
        // Statement statement = null; // <- DbTest1에서는 이거 씀
        ResultSet rs = null;

        // 1. 드라이버 로드
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 커넥션 객체 생성
        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            // 4. 쿼리 실행
            // sql문 작성
// 만약, 마케팅선택이 n인 사람들은 어떻게 조회할 수 있을까? sql문을 그때마다 수정해줘야 하나?
// 1. sql문 자체에 변수를 두고 변수를 수정 -> 위험 노출 (sql injection 발생 가능성!!)
//            String nameValue = "김한국";
//            String emailValue = "test4@naver.com";
//            String mobileNum = "01003010815";
//            String passwordValue = "1010";
//            int marketing_yn = 0;

            String sql = " delete " +
                    " from zerobase_member " +
                    " where name = ? and email = ? ;";


            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, zm.getNameValue());
            preparedStatement.setString(2, zm.getEmailValue());

            // sql문 실행
            // 여기도 preparedStatement로 바뀜
            int affected = preparedStatement.executeUpdate();

            // 5. 결과 수행
            if(affected > 0) {
                System.out.println("삭제 성공. 삭제 Data 개수: " + affected);
            } else {
                System.out.println("삭제 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 객체 연결 해제(close)
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ZerobaseMemberService zms = new ZerobaseMemberService();
//        zms.dbSelect_prepare();
//        zms.dbSelect_statement();
//        zms.register();
//        zms.update();
//        zms.withdraw();

        Scanner sc = new Scanner(System.in);

        System.out.println("이름 : ");
        String nameValue = sc.next();
        System.out.println("이메일 : ");
        String emailValue = sc.next();
        System.out.println("핸드폰번호(- 제외) : ");
        String mobileNum = sc.next();
        System.out.println("비밀번호 : ");
        String passwordValue = sc.next();
        System.out.println("마케팅 수신 동의여부(0 - 미동의 / 1 - 동의) : ");
        int marketing_yn = sc.nextInt();

        ZerobaseMember zm = new ZerobaseMember();
        zm.setNameValue(nameValue);
        zm.setEmailValue(emailValue);
        zm.setMobileNum(mobileNum);
        zm.setPasswordValue(passwordValue);
        zm.setMarketing_yn(marketing_yn);

        zms.register(zm);

    }
}
