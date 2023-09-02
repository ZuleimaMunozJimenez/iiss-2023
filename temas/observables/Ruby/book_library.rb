# book_library.rb

class Book
    attr_reader :title, :author
  
    def initialize(title, author)
      @title = title
      @author = author
    end
  end
  
  class Library
    attr_reader :books
  
    def initialize
      @books = []
      @observers = []
    end
  
    def add_observer(observer)
      @observers << observer
    end
  
    def remove_observer(observer)
      @observers.delete(observer)
    end
  
    def add_book(book)
      @books << book
      notify_observers(book)
    end
  
    def notify_observers(book)
      @observers.each { |observer| observer.update(self, book) }
    end
  end
  