import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Library {
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId()))
            throw new IllegalArgumentException("Item id already exists: " + item.getId());
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId()))
            throw new IllegalArgumentException("Member id already exists: " + member.getId());
        members.put(member.getId(), member);
    }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (member == null) throw new IllegalArgumentException("No such member: " + memberId);
        if (item == null)   throw new IllegalArgumentException("No such item: " + itemId);
        item.borrow(member);
    }

    public void giveBack(String memberId, String itemId) {
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (member == null) throw new IllegalArgumentException("No such member: " + memberId);
        if (item == null)   throw new IllegalArgumentException("No such item: " + itemId);
        if (!member.removeLoan(itemId))
            throw new IllegalArgumentException(member.getName() + " has not borrowed " + itemId);
        item.giveBack();
    }

    public List<LibraryItem> searchByTitle(String text) {
        return items.values().stream()
            .filter(i -> i.getTitle().toLowerCase().contains(text.toLowerCase()))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .toList();
    }

    public List<Loan> overdueLoans() {
        LocalDate today = LocalDate.now();
        return members.values().stream()
            .flatMap(m -> m.getLoans().stream())
            .filter(l -> l.isOverdue(today))
            .sorted(Comparator.comparing(Loan::dueOn))
            .toList();
    }

    // ---------- persistence (Lab 10) ----------
    public void save(Path dir) throws IOException {
        Files.createDirectories(dir);

        Files.write(dir.resolve("items.csv"), items.values().stream()
            .map(i -> String.join(",", i.type(), i.getId(), i.getTitle(),
                                  String.valueOf(i.isAvailable())))
            .toList());

        Files.write(dir.resolve("members.csv"), members.values().stream()
            .map(m -> m.getId() + "," + m.getName().replace(',', ' '))
            .toList());

        Files.write(dir.resolve("loans.csv"), members.values().stream()
            .flatMap(m -> m.getLoans().stream())
            .map(l -> String.join(",", l.itemId(), l.memberId(),
                                  l.borrowedOn().toString(), l.dueOn().toString()))
            .toList());
    }

    public void load(Path dir) throws IOException {
        items.clear();
        members.clear();

        Path itemsFile = dir.resolve("items.csv");
        if (Files.exists(itemsFile)) {
            for (String line : Files.readAllLines(itemsFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                LibraryItem item = switch (p[0]) {
                    case "BOOK" -> new Book(p[1], p[2]);
                    case "DVD"  -> new Dvd(p[1], p[2]);
                    default -> throw new IOException("Unknown item type: " + p[0]);
                };
                item.setAvailable(Boolean.parseBoolean(p[3]));
                items.put(item.getId(), item);
            }
        }

        Path membersFile = dir.resolve("members.csv");
        if (Files.exists(membersFile)) {
            for (String line : Files.readAllLines(membersFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                members.put(p[0], new Member(p[0], p[1]));
            }
        }

        Path loansFile = dir.resolve("loans.csv");
        if (Files.exists(loansFile)) {
            for (String line : Files.readAllLines(loansFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                Member m = members.get(p[1]);
                if (m != null) {
                    m.restoreLoan(new Loan(p[0], p[1], LocalDate.parse(p[2]), LocalDate.parse(p[3])));
                }
            }
        }
    }
}
