package project;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		boolean run2 = false;
		Scanner sc = new Scanner(System.in);
		UsersDAO usrdao = new UsersDAO();
		PostsDAO pstdao = new PostsDAO();

		System.out.printf("%10s %10s %10s\n", "게", "시", "판");
		// 회원 정보
		String id = null;
		while (run) {
			System.out.println("회원 정보");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. ID 찾기");
			System.out.println("4. PW 변경");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				System.out.println("로그인");
				String pw;
				while (true) {
					System.out.print("ID: ");
					id = sc.nextLine();

					System.out.print("비밀번호: ");
					pw = sc.nextLine();

					if (usrdao.logIn(id, pw)) {
						System.out.println("로그인 성공!");
						run = false;
						run2 = true;
						break;
					} else {
						System.out.println("로그인 실패. 다시 시도해주세요.");
					}
				}
				break;

			case 2:
				System.out.println("회원가입");
				System.out.print("ID: ");
				id = sc.nextLine();

				if (usrdao.idCheck(id)) {
					System.out.println("이미 사용 중인 ID입니다.");
					break;
				}

				System.out.print("비밀번호: ");
				pw = sc.nextLine();

				System.out.print("비밀번호 확인: ");
				String pwc = sc.nextLine();
				while (!pw.equals(pwc)) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
					System.out.print("비밀번호 확인: ");
					pwc = sc.nextLine();
				}

				System.out.print("전화번호: ");
				String phone = sc.nextLine();

				Users user = new Users(id, pw, phone);
				int result = usrdao.signUp(user);
				if (result == 1) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
				break;

			case 3:
			    System.out.print("전화번호 입력 : ");
			    phone = sc.nextLine();

			    if (!usrdao.phoneCheck(phone)) {
			        System.out.println("등록된 전화번호가 없습니다.");
			        break;
			    }

			    id = usrdao.findIdByPhone(phone);
			    if (id != null) {
			        System.out.println("해당 전화번호의 ID는: " + id + "입니다.");
			    } else {
			        System.out.println("ID를 찾을 수 없습니다.");
			    }
			    break;
				


			case 4:
				System.out.println("비밀번호 변경");
				System.out.print("아이디를 입력하세요: ");
				id = sc.nextLine();

				while (!usrdao.idCheck(id)) {
					System.out.println("해당 ID는 존재하지 않습니다.");
					System.out.print("아이디를 다시 입력하세요: ");
					id = sc.nextLine();
				}

				System.out.print("변경할 비밀번호를 입력하세요: ");
				String newPw = sc.nextLine();

				result = usrdao.changePassword(id, newPw);
				if (result == 1) {
					System.out.println("비밀번호가 성공적으로 변경되었습니다.");
				} else {
					System.out.println("비밀번호 변경 실패.");
				}
				break;

			case 5:
				run = false;
				break;

			default:
				System.out.println("다시 선택해주세요");
				break;
			}
			}// end user while
			
			//게시글
			while (run2) {
				System.out.printf("%10s %10s %10s\n", "게", "시", "판");
				System.out.println("1. 게시글 등록");
				System.out.println("2. 게시글 목록");
				System.out.println("3. 게시글 검색");
				System.out.println("4. 게시글 상세 조회");
				System.out.println("6. 게시글 제목 수정");
				System.out.println("7. 게시글 삭제");
				System.out.println("9. 프로그램 종료");
				
				System.out.print("선택: ");
				int menu = sc.nextInt();
				sc.nextLine();
				switch (menu) {
				case 1:
					System.out.println("등록할 게시글을 작성해주세요");

				    System.out.print("제목을 입력하세요: ");
				    String contentTitle = sc.nextLine();

				    System.out.print("내용을 입력하세요: ");
				    String content = sc.nextLine();

				    int nextPostId = pstdao.getPostCount() + 1;

				    Posts newPost = new Posts();
				    newPost.setContentId(nextPostId);
				    newPost.setUserId(id);  // 로그인 후 저장된 변수
				    newPost.setContentTitle(contentTitle);
				    newPost.setContent(content);
//				    newPost.setCreateTime(new String(System.currentTimeMillis()));
				    newPost.setViews(0);

				    int result = pstdao.createPost(newPost);
				    if (result == 1) {
				        System.out.println("게시글 등록 성공!");
				    } else {
				        System.out.println("게시글 등록 실패...");
				    }
				    break;
					
				case 2:
					ArrayList<Posts> postList = pstdao.findList();
					System.out.printf("%-3s  %-8s  %-10s %-12s %3s\n", "글번호", "작성자", "제목", "작성시간", "조회수");
					System.out.println("===========================================================================");
					for(int i = 0; i < postList.size(); i++) {
						System.out.printf("%-3s  %-8s  %-10s %-12s %3s\n",
								postList.get(i).getContentId(),
								postList.get(i).getUserId(),
								postList.get(i).getContentTitle(),
								postList.get(i).getCreateTime(),
								postList.get(i).getViews());
					}
					break;
					
				case 9 :
					run2 = false;
					break;
				
				default :
					System.out.println("다시 선택해주세요");
					break;
				}
			}

			while (run) {
				System.out.printf("%6s %6s %6s %6s %6s\n", "게", "시", "글", "내", "용");
				System.out.println("1.게시글 내용");
				System.out.println("2.게시글 내용 수정");
				System.out.println("3.게시글 추천");
				System.out.println("4.게시글 비추천");
				System.out.println("5.댓글 목록 보기");
			}

			while (run2) {
				System.out.printf("%6s %6s %6s %6s\n", "댓", "글", "목", "록");
				System.out.println("1.댓글 목록");
				System.out.println("2.댓글 등록");
				System.out.println("3.댓글 수정");
				System.out.println("4.댓글 삭제");
			}
		
		sc.close();
		System.out.println("end of program");

	}// end main

}
// end class
