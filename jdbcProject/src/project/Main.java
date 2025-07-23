package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean run = true;
		boolean run2 = false;
		boolean run3 = false;
		boolean run4 = false;
		boolean run5 = false;
		Scanner sc = new Scanner(System.in);
		UsersDAO usrdao = new UsersDAO();
		PostsDAO pstdao = new PostsDAO();
		CommentsDAO cmtdao = new CommentsDAO();
		String loginId = null;
		String id = null;
		int contNum = 0;

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
			// 로그인
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
						run3 = true;
						break;
					} else {
						System.out.println("로그인 실패. 다시 시도해주세요.");
						break;
					}
				}
				break;
			//회원가입	
			case 2:
				System.out.println("회원가입");
				System.out.print("ID: ");
				id = sc.nextLine();

				while (usrdao.idCheck(id)) {
					System.out.println("이미 사용 중인 ID입니다.");
					System.out.print("ID: ");
					id = sc.nextLine();
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
				
				while (usrdao.phoneCheck(phone)) {
					System.out.println("이미 사용 중인 전화번호입니다.");
					System.out.print("전화번호: ");
					id = sc.nextLine();
				}
				
				Users user = new Users(id, pw, phone);
				int result = usrdao.signUp(user);
				if (result == 1) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
				break;
			//전화번호로 id 찾기
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
			// 비밀번호 변경
			case 4:
				System.out.println("비밀번호 변경");
				System.out.print("아이디를 입력하세요: ");
				id = sc.nextLine();

				while (!usrdao.idCheck(id)) {
					System.out.println("해당 ID는 존재하지 않습니다.");
					System.out.print("아이디를 다시 입력하세요: ");
					id = sc.nextLine();
				}
				
				System.out.print("전화번호를 입력하세요: ");
				phone = sc.nextLine();
				
				while(!usrdao.phoneCheck(phone)) {
					System.out.println("해당 전화번호는 존재하지 않습니다.");
					System.out.print("전화번호를 다시 입력하세요 :");
					phone = sc.nextLine();
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
		while (run2) {
			// 게시글
			System.out.println("----------------------------------------------------------------------");
			System.out.printf("%10s %10s %10s\n", "게", "시", "판");
			System.out.println("----------------------------------------------------------------------");
			ArrayList<Posts> list = pstdao.findList();
			System.out.printf("%-3s %-15s %-20s %-15s %-5s %-3s\n", "번호", "작성자", "제목", "작성일시", "댓글 수", "조회수");
			System.out.println("----------------------------------------------------------------------");
			for (Posts post : list) {
				System.out.printf("%-3d %-15s %-20s %-20s %-5d %-3d\n", post.getContentId(), post.getUserId(),
						post.getContentTitle(), post.getCreateTime(), cmtdao.countByPostId(post.getContentId()), post.getViews());
			}
			System.out.println("----------------------------------------------------------------------");
			
			while (run3) {
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
					list = pstdao.findList();
					System.out.printf("%-3s %-15s %-20s %-15s %-3s\n", "번호", "작성자", "제목", "작성일시", "조회수");
					System.out.println("----------------------------------------------------------------------");
					for (Posts post : list) {
						System.out.printf("%-3d %-15s %-20s %-15s %-3d\n", post.getContentId(), post.getUserId(),
								post.getContentTitle(), post.getCreateTime(), post.getViews());
					}
					System.out.println("----------------------------------------------------------------------");
					break;

				case 3:
					System.out.print("검색할 제목 키워드를 입력하세요: ");
					String keyword = sc.nextLine();

					ArrayList<Posts> searchList = pstdao.searchByTitle(keyword);

					if (searchList.isEmpty()) {
						System.out.println("검색 결과가 없습니다.");
						System.out.println("----------------------------------------------------------------------");
					} else {
						System.out.printf("%-5s %-10s %-20s %-20s %-5s\n", "ID", "작성자", "제목", "작성일시", "조회수");
						System.out.println("----------------------------------------------------------------------");

						for (Posts p : searchList) {
							System.out.printf("%-5d %-10s %-20s %-20s %-5d\n", p.getContentId(), p.getUserId(),
									p.getContentTitle(), p.getCreateTime(), p.getViews());
						}
						System.out.println("----------------------------------------------------------------------");
					}
					break;

				case 4:
					System.out.print("조회할 게시글 번호: ");
					int contentId = sc.nextInt();
					contNum = contentId;
					sc.nextLine();

					pstdao.increaseViews(contentId); // 조회수 증가

					Posts post = pstdao.findById(contentId);
					if (post != null) {
						System.out.println("------------------------------ 게시글 상세 -------------------------------");
						System.out.print("번호: " + post.getContentId() + "\s");
						System.out.print("작성자: " + post.getUserId() + "\s");
						System.out.print("작성일: " + post.getCreateTime() + "\s");
						System.out.println("조회수: " + post.getViews() + "\s");
						System.out.println("제목: " + post.getContentTitle());
						System.out.println("내용: " + post.getContent());
						System.out.print("추천" + post.getLikes() + "\t");
						System.out.print("비추천" + post.getHates() + "\n");
						ArrayList<Comments> comments = cmtdao.findByPostId(contNum);
						System.out.println("--------------------------- 댓글 목록 ----------------------------------");
						if (comments.isEmpty()) {
							System.out.println("댓글이 없습니다.");
						} else {
							for (Comments c : comments) {
								System.out.printf("%-10s %-15s %-30s %s\n", "댓글 번호", "작성자 ID", "댓글 내용", "작성 시간");
								System.out.printf("%-10s %-15s %-30s (%s)\n", c.getCommentId(), c.getUserId(), c.getCommentText(), c.getCreateTime());
							}
						}
						run3 = false;
						run4 = true;
					} else {
						System.out.println("게시글이 존재하지 않습니다.");
					}
					break;

				case 9:
					run3 = false;
					run2 = false;
					break;

				default:
					System.out.println("다시 선택해주세요");
					break;
				}
			} // end while

			while (run4) {
				System.out.println("----------------------------------------------------------------------");
				System.out.printf("%10s %10s %10s\n", "게", "시", "글");
				System.out.println("1.게시글 수정");
				System.out.println("2.게시글 삭제");
				System.out.println("3.게시글 추천");
				System.out.println("4.게시글 비추천");
				System.out.println("5.댓글 작성하기");
				System.out.println("6.게시판으로 돌아가기");
				System.out.println("9.프로그램 종료");

				System.out.print("선택: ");
				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				// 게시글 수정
				case 1:
					Posts post = pstdao.findById(contNum);

					if (post != null && post.getUserId().equals(loginId)) {
						System.out.print("새 제목: ");
						String newTitle = sc.nextLine();
						System.out.print("새 내용: ");
						String newContent = sc.nextLine();

						int result = pstdao.updatePost(contNum, newTitle, newContent, loginId);
						if (result == 1) {
							System.out.println("게시글 수정 완료");
							run4 = false;
							run3 = true;
						} else {
							System.out.println("게시글 수정 실패");
						}
					} else {
						System.out.println("수정 권한이 없습니다.");
					}
					break;

				case 2:
					post = pstdao.findById(contNum);
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
					if (pstdao.deletePost(contNum, loginId) == 1) {
						System.out.println("삭제 완료");
						run4 = false;
						run3 = true;
					} else {
						System.out.println("삭제 실패");
					}
					break;

				case 3:
					int result = pstdao.votePost(loginId, contNum, "LIKE");
					if (result == 1)
						System.out.println("추천 완료!");
					else if (result == -1)
						System.out.println("이미 추천/비추천 하였습니다.");
					else
						System.out.println("추천 실패");
					break;

				case 4:
					result = pstdao.votePost(loginId, contNum, "DISLIKE");
					if (result == 1)
						System.out.println("비추천 완료!");
					else if (result == -1)
						System.out.println("이미 추천/비추천 하였습니다.");
					else
						System.out.println("비추천 실패");
					break;

				case 5: // 댓글 목록
					ArrayList<Comments> comments = cmtdao.findByPostId(contNum);
					System.out.println("------------------------------ 댓글 목록 -------------------------------");

					if (comments.isEmpty()) {
						System.out.println("댓글이 없습니다.");
					} else {
						for (Comments c : comments) {
							System.out.printf("%-10s %-15s %-30s %s\n", "댓글 번호", "작성자 ID", "댓글 내용", "작성 시간");
							System.out.printf("%-10s %-15s %-30s (%s)\n", c.getCommentId(), c.getUserId(), c.getCommentText(), c.getCreateTime());
						}
					}
					run4 = false;
					run5 = true;
					break;

				case 6: // 게시판 돌아가기
					run4 = false;
					run3 = true;
					break;

				case 9:
					System.out.println("프로그램 종료");
					run4 = false;
					run2 = false;
					break;

				default:
					System.out.println("다시 선택해주세요.");
				}

			} // end while

			while (run5) {
				System.out.println("----------------------------------------------------------------------");
				System.out.printf("%15s %15s\n", "댓", "글");
				System.out.println("1.댓글 등록");
				System.out.println("2.댓글 수정");
				System.out.println("3.댓글 삭제");
				System.out.println("4.게시판으로 돌아가기");
				System.out.println("9.프로그램 종료");

				System.out.print("선택: ");
				int menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {
				case 1:
					System.out.print("댓글 내용: ");
					String text = sc.nextLine();

					Comments c = new Comments();
					c.setContentId(contNum);
					c.setUserId(loginId);
					c.setCommentText(text);

					int result = cmtdao.insert(c);
					System.out.println(result > 0 ? "등록 성공" : "등록 실패");
					break;

				case 2:
					System.out.print("댓글 번호: ");
					int commentId = Integer.parseInt(sc.nextLine());

					System.out.print("수정할 댓글 내용: ");
					String newText = sc.nextLine();

					System.out.print("비밀번호: ");
					String pw = sc.nextLine();

					int resultCmt = cmtdao.update(commentId, newText, loginId, pw);
					if (resultCmt == 1)
						System.out.println("수정 성공");
					else 
						System.out.println("댓글이 존재하지 않거나 권한이 없습니다.");
					break;

				case 3:
					System.out.print("삭제할 댓글 번호: ");
					commentId = Integer.parseInt(sc.nextLine());

					System.out.print("비밀번호: ");
					pw = sc.nextLine();

					resultCmt = cmtdao.delete(commentId, loginId, pw);
					
					if (resultCmt == 1)
						System.out.println("삭제 성공");
					else
						System.out.println("댓글이 존재하지 않거나 권한이 없습니다.");
					break;

				case 4:
					run5 = false;
					run3 = true;
					break;

				case 9:
					run5 = false;
					run2 = false;
					break;
					
				default:
					System.out.println("다시 선택해주세요.");	
				}
			}

		}

		System.out.println("end of program");
		sc.close();

	}// end main

}// end class