class Car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        # simulate accelerating
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        # simulate stopping
        print(f"{self.manufacturer} {self.model} has stopped")


# Create 3 different car objects
car1 = Car(manufacturer="Toyota", model="Corolla", make="Sedan",
           transmission="Manual", color="Red")
car2 = Car(manufacturer="Honda", model="Civic", make="Sedan",
           transmission="Automatic", color="Blue")
car3 = Car(manufacturer="Ford", model="Mustang", make="Coupe",
           transmission="Manual", color="Black")

# Calling methods
car1.accelerate()   # Toyota Corolla is moving
car1.stop()         # Toyota Corolla has stopped

car2.accelerate()   # Honda Civic is moving
car2.stop()         # Honda Civic has stopped

car3.accelerate()   # Ford Mustang is moving
car3.stop()         # Ford Mustang has stopped
