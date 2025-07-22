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
		PostContentsDAO pctdao = new PostContentsDAO();
		String loginId = null;
		String id = null;
		int contentId = 0;

		System.out.printf("%10s %10s %10s\n", "게", "시", "판");
		System.out.println("----------------------------------------------------------------------");
		// 회원 정보
		while (run) {
			System.out.println("회원 정보");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. ID 찾기");
			System.out.println("4. PW 변경");
			System.out.println("9. 프로그램 종료");
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
						loginId = id;
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

			case 9:
				run = false;
				break;

			default:
				System.out.println("다시 선택해주세요");
				break;
			}
		} // end user while

		// 게시글
		while (run2) {
			System.out.println("----------------------------------------------------------------------");
			System.out.printf("%15s %15s %15s\n", "게", "시", "판");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 게시글 목록");
			System.out.println("3. 게시글 검색");
			System.out.println("4. 게시글 상세 조회");
			System.out.println("9. 프로그램 종료");

			System.out.print("선택: ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				System.out.print("제목 입력: ");
				String title = sc.nextLine();
				System.out.print("내용 입력: ");
				String content = sc.nextLine();

				Posts newPost = new Posts();
				newPost.setUserId(loginId);
				newPost.setContentTitle(title);
				newPost.setContent(content);

				int result = pstdao.createPost(newPost);
				if (result == 1) {
					System.out.println("게시글 등록 성공");
				} else {
					System.out.println("게시글 등록 실패");
				}
				break;

			case 2:
				ArrayList<Posts> list = pstdao.findList();
				System.out.printf("%-5s %-10s %-20s %-15s %-5s\n", "번호", "작성자", "제목", "작성일시", "조회수");
				System.out.println("----------------------------------------------------------------------");
				for (Posts post : list) {
					System.out.printf("%-5d %-10s %-20s %-20s %-5d\n", post.getContentId(), post.getUserId(),
							post.getContentTitle(), post.getCreateTime(), post.getViews());
				}
				break;

			case 3:
				System.out.print("검색할 제목 키워드를 입력하세요: ");
				String keyword = sc.nextLine();

				ArrayList<Posts> searchList = pstdao.searchByTitle(keyword);

				if (searchList.isEmpty()) {
					System.out.println("❌ 검색 결과가 없습니다.");
				} else {
					System.out.printf("%-5s %-10s %-20s %-20s %-5s\n", "ID", "작성자", "제목", "작성일시", "조회수");
					System.out.println("----------------------------------------------------------------------");

					for (Posts p : searchList) {
						System.out.printf("%-5d %-10s %-20s %-20s %-5d\n", p.getContentId(), p.getUserId(),
								p.getContentTitle(), p.getCreateTime(), p.getViews());
					}
				}
				break;

			case 4:
				System.out.print("조회할 게시글 번호: ");
				contentId = sc.nextInt();
				sc.nextLine();

				pstdao.increaseViews(contentId); // 조회수 증가

				Posts post = pstdao.findById(contentId);
				if (post != null) {
					System.out.println("------ 게시글 상세 ------");
					System.out.println("번호: " + post.getContentId());
					System.out.println("작성자: " + post.getUserId());
					System.out.println("제목: " + post.getContentTitle());
					System.out.println("내용: " + post.getContent());
					System.out.println("작성일: " + post.getCreateTime());
					System.out.println("조회수: " + post.getViews());
					run2 = false;
					run = true;
				} else {
					System.out.println("❌ 게시글이 존재하지 않습니다.");
				}
				break;

			case 9:
				run2 = false;
				break;

			default:
				System.out.println("다시 선택해주세요");
				break;
			}
		} // end while

		while (run) {
			System.out.printf("%6s %6s %6s %6s %6s\n", "게", "시", "글", "내", "용");
			System.out.println("1.게시글 수정");
			System.out.println("2.게시글 삭제");
			System.out.println("3.게시글 추천");
			System.out.println("4.게시글 비추천");
			System.out.println("5.댓글 목록 보기");
			System.out.println("6.게시판으로 돌아가기");
			System.out.println("9.프로그램 종료");

			System.out.println("선택: ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				Posts post = pstdao.findById(contentId);

				if (post != null && post.getUserId().equals(loginId)) {
					System.out.print("새 제목: ");
					String newTitle = sc.nextLine();
					System.out.print("새 내용: ");
					String newContent = sc.nextLine();

					int result = pctdao.updatePost(contentId, newTitle, newContent);
					if (result == 1) {
						System.out.println("게시글 수정 완료");
					} else {
						System.out.println("게시글 수정 실패");
					}
				} else {
					System.out.println("수정 권한이 없습니다.");
				}
				
			case 2: 
				post = pstdao.findById(contentId);
				if (!post.getUserId().equals(loginId)) {
					System.out.println("삭제 권한이 없습니다.");
					break;
				}
				System.out.print("비밀번호 확인: ");
				String pw = sc.nextLine();
				if (!usrdao.logIn(loginId, pw)) {
					System.out.println("비밀번호 틀림");
					break;
				}
				if (pctdao.deletePost(contentId) == 1)
					System.out.println("삭제 완료");
				else
					System.out.println("삭제 실패");
				run = false; // 수정이 필요
				break;

			case 3: // 추천
				int result = pctdao.votePost(loginId, contentId, "LIKE");
				if (result == 1)
					System.out.println("추천 완료!");
				else if (result == -1)
					System.out.println("이미 추천/비추천 하였습니다.");
				else
					System.out.println("추천 실패");
				break;

			case 4: // 비추천
				result = pctdao.votePost(loginId, contentId, "DISLIKE");
				if (result == 1)
					System.out.println("비추천 완료!");
				else if (result == -1)
					System.out.println("이미 추천/비추천 하였습니다.");
				else
					System.out.println("비추천 실패");
				break;

//			case 5: 
//				commentDAO.showComments(contentId);
//				break;

//				case 6: 
//				run = false;
//				break;

			case 9:
				System.out.println("프로그램 종료");
				System.exit(0);
				break;

			default:
				System.out.println("❗ 잘못된 입력입니다.");
			}

		} // end while

		while (run2) {
			System.out.printf("%6s %6s %6s %6s\n", "댓", "글", "목", "록");
			System.out.println("1.댓글 등록");
			System.out.println("2.댓글 수정");
			System.out.println("3.댓글 삭제");
			System.out.println("4.게시판으로 돌아가기");
			System.out.println("9.프로그램 종료");
		}

		sc.close();
		System.out.println("end of program");

	}// end main

}
// end class
