# task.rb

class Task
    attr_accessor :name, :completed
  
    def initialize(name)
      @name = name
      @completed = false
    end
  end
  