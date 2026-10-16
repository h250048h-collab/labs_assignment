import java.time.LocalDate;

public record Loan(String itemId, String memberId, LocalDate borrowedOn, LocalDate dueOn) {

    public Loan {                                   // compact constructor = validation
        if (itemId == null || itemId.isBlank() || memberId == null || memberId.isBlank())
            throw new IllegalArgumentException("Loan needs an item id and a member id");
        if (dueOn.isBefore(borrowedOn))
            throw new IllegalArgumentException("Due date cannot be before borrow date");
    }

    public boolean isOverdue(LocalDate today) { return today.isAfter(dueOn); }

    @Override
    public String toString() { return itemId + " -> " + memberId + " (due " + dueOn + ")"; }
}
