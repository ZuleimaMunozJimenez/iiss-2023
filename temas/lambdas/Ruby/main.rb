# main.rb

require_relative 'todo_list'

todo_list = TodoList.new

# Definimos una lambda para agregar tareas
add_task_lambda = ->(task_name) { todo_list.add_task(task_name) }

# Definimos una lambda para marcar tareas como completadas
mark_completed_lambda = ->(task_name) { todo_list.mark_completed(task_name) }

loop do
puts "¿Que quieres hacer?"
puts "1. Añadir tarea"
puts "2. Marcar tarea como completada"
puts "3. Salir"
op = gets.chop
    if op != '1' && op != '2'
        break
    end
case op
when '1'
    loop do
        puts "Introduce una nueva tarea:"
        tarea = gets
        add_task_lambda.call(tarea)
        puts "Tus tareas actuales son:"
        todo_list.display_tasks
        puts "¿Quieres introducir una nueva tarea? s/n"
        bucle = gets.chomp
        if bucle == 'n'
            break
        end
    end
when '2'
    loop do
        todo_list.display_tasks
        puts "¿Que tarea quieres marcar como completa? Introduce la tarea"
        compl = gets
        mark_completed_lambda.call(compl)
        puts "¿Quieres completar otra tarea? s/n"
        bucle = gets.chomp
        if bucle == 'n'
            break
        end
    end
else
    puts "Opcion no valida"
end
end

# Mostramos la lista de tareas
todo_list.display_tasks
