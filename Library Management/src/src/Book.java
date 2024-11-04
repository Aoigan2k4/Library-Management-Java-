package src;

import java.time.LocalDate;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final boolean isAvailable;
    private LocalDate dueDate;
    private LocalDate borrowDate;

    private Book(Builder builder, LocalDate dueDate, LocalDate borrowDate) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.isAvailable = builder.isAvailable;
        this.dueDate = dueDate;
        this.borrowDate = borrowDate;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void setBorrowDate(){
        this.borrowDate = LocalDate.now();
    }
    public LocalDate getBorrowDate(){
        return borrowDate;
    }
    public void setDueDate(){
        this.dueDate = getBorrowDate().minusDays(14);
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isAvailable(boolean b) {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "ISBN:'" + isbn +
                ", Title:'" + title +
                ", Author:'" + author +
                ", Available:" + isAvailable +
                ", Borrow Date:" + borrowDate +
                ", Due Date:" + dueDate;
    }

    public static class Builder {
        private final String isbn;
        private final String title;
        private String author = "";
        private boolean isAvailable = true;
        private LocalDate borrowDate;
        private LocalDate dueDate;

        public Builder(String isbn,String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }
        public Builder isAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
            return this;
        }
        public Book build()
        {
            return new Book(this, null,null);
        }
        public void setAvailable(boolean available) {
            isAvailable = available;
        }
    }
}

