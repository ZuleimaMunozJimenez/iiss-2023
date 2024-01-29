from rx import Observable
from rx.subject import Subject
import time

# Definición de la interfaz Observer
class Observer:
    def on_next(self, value):
        pass

    def on_error(self, error):
        pass

    def on_completed(self):
        pass


# Implementación de Observable
class AsyncEventSystem:
    def __init__(self):
        self._subject = Subject()
        self._observers = []

    def trigger_event(self, event_type, event_data):
        print(f"Desencadenando evento de tipo {event_type}")
        self._subject.on_next((event_type, event_data))

    def subscribe(self, observer):
        self._observers.append(observer)
        return self._subject.subscribe(observer)

    def observers(self):
        return iter(self._observers)


# Implementación de Observadores
class ClickEventObserver(Observer):
    def on_next(self, value):
        event_type, event_data = value
        print(f"Manejando evento de clic: {event_data}")


class KeyEventObserver(Observer):
    def on_next(self, value):
        event_type, event_data = value
        print(f"Manejando evento de tecla: {event_data}")


# Ejemplo de uso
async_event_system = AsyncEventSystem()

click_observer = ClickEventObserver()
key_observer = KeyEventObserver()

subscription_click = async_event_system.subscribe(click_observer)
subscription_key = async_event_system.subscribe(key_observer)

# Desencadenar eventos
async_event_system.trigger_event("click", "Botón izquierdo")
async_event_system.trigger_event("key", "Tecla Enter")

# Permitir que las suscripciones tengan tiempo para procesar los eventos
time.sleep(1)

# Iterar sobre observadores
print("Iterando sobre observadores:")
for observer in async_event_system.observers():
    print(observer)

# Cancelar las suscripciones
subscription_click.dispose()
subscription_key.dispose()

# Puedes agregar más eventos después de que las suscripciones han sido canceladas
async_event_system.trigger_event("click", "Botón derecho")
async_event_system.trigger_event("key", "Tecla Escape")

# Permitir que las nuevas suscripciones tengan tiempo para procesar los eventos
time.sleep(1)
