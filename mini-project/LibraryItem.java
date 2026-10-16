import java.time.LocalDate;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank())       throw new IllegalArgumentException("Item id required");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        this.id = id.trim();
        this.title = title.trim().replace(',', ' ');     // keeps the CSV format safe
    }

    public abstract int loanPeriodDays();                // polymorphic: differs per subclass
    public abstract String type();                       // "BOOK" or "DVD"

    public String getId()        { return id; }
    public String getTitle()     { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public void borrow(Member member) throws ItemNotAvailableException, MemberLimitExceededException {
        if (!available) throw new ItemNotAvailableException("'" + title + "' is already on loan");
        LocalDate today = LocalDate.now();
        member.addLoan(new Loan(id, member.getId(), today, today.plusDays(loanPeriodDays())));
        available = false;          // reached only if addLoan did not throw
    }

    @Override
    public void giveBack() { available = true; }

    @Override
    public String toString() {
        return type() + " " + id + ": " + title + (available ? "" : " [on loan]");
    }
}
