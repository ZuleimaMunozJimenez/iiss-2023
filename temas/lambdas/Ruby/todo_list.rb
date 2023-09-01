# todo_list.rb

require_relative 'task'

class TodoList
  def initialize
    @tasks = []
  end

  def add_task(name)
    task = Task.new(name)
    @tasks.push(task)
  end

  def mark_completed(task_name)
    task = @tasks.find { |t| t.name == task_name }
    if task
      task.completed = true
    else
      puts "Tarea no encontrada: #{task_name}"
    end
  end

  def display_tasks
    puts "Tareas:"
    @tasks.each do |task|
      status = task.completed ? "[x]" : "[ ]"
      puts "#{status} #{task.name}"
    end
  end
end
