import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank())     throw new IllegalArgumentException("Member id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Member name required");
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId()   { return id; }
    public String getName() { return name; }
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    void addLoan(Loan loan) throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException(
                name + " already has the maximum of " + MAX_LOANS + " loans");
        }
        loans.add(loan);
    }

    void restoreLoan(Loan loan) { loans.add(loan); }     // used when loading from file

    boolean removeLoan(String itemId) {
        return loans.removeIf(l -> l.itemId().equals(itemId));
    }

    @Override
    public String toString() { return id + " " + name + " (" + loans.size() + " loans)"; }
}
