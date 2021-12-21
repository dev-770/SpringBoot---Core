package hello.core.member;

public interface MemberService {

	public void join(Member Member);
	
	public Member findMember(Long memberId);
}
