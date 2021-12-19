package com.library;

public class PhysicalBook extends Book {
    private Member member;
    private String condition;

    public PhysicalBook(String title, String author, String isbn, String condition) {
        super(title, author, isbn);
        if (condition == null) {
            this.condition = "New";
        } else {
            this.condition = condition;
        }
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition += String.format("%s%n", condition);
    }

    public boolean isAvailable() {
        return member == null;
    }

    @Override
    public void printDetails() {
        String memString;
        if (member == null) {
            memString = "Currently available!";
        } else {
            memString = String.format("Currently lent to: %s", member.getName());
        }
        
        super.printDetails();
        System.out.println(
                String.format("Condition: %s%n %s",
                        this.getCondition(),
                        memString));
    }

}
